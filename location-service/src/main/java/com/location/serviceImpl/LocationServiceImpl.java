package com.location.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.location.Repository.LocationRepository;
import com.location.client.WeatherInfoClient;
import com.location.dto.TemperatureDto;
import com.location.dto.WeatherInfoDto;
import com.location.exception.InvalidLocationNameException;
import com.location.exception.LocationAlreadyExistsException;
import com.location.exception.LocationNotFoundException;
import com.location.models.Location;
import com.location.service.LocationService;
import com.location.util.LocationUtility;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private WeatherInfoClient weatherInfoClient;

	/**
	 * Save location
	 * 
	 * @param locationName
	 * 
	 * @return TemperatureDto
	 * 
	 * @throws LocationAlreadyExistsException
	 * @throws InvalidLocationNameException
	 * @throws LocationNotFoundException
	 */

	public TemperatureDto saveLocation(String locationName)
			throws LocationAlreadyExistsException, InvalidLocationNameException, LocationNotFoundException {

		// Check whether location name is empty
		if (locationName.isEmpty() || locationName == null) {

			throw new InvalidLocationNameException(LocationUtility.INVALID_LOCATION_NAME);
		}

		// Check if location exists or not
		if (findBylocationName(locationName) != null) {

			throw new LocationAlreadyExistsException(LocationUtility.LOCATION_ALREADY_EXISTS);
		}

		// Check weather location Name is valid or not
		if (getWeatherInfo(locationName).getBody() == null) {

			throw new LocationNotFoundException(LocationUtility.MATCHING_LOCATION_NOT_FOUND);
		}

		Location location = new Location(locationName, getAllLocations().size());

		// Save location
		location = locationRepository.save(location);

		if (location != null) {

			if (location.getLocation() != null) {

				ResponseEntity<WeatherInfoDto> weatherInfo = getWeatherInfo(location.getLocation());

				return new TemperatureDto(location,
						weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getMaxTemp(),
						weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getMinTemp(),
						weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getConditionDto()
								.getText(),
						weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getConditionDto()
								.getIcon());
			}
		}

		return null;
	}

	/**
	 * Find location by location Name
	 * 
	 * @param locationName
	 * 
	 * @return Location
	 */

	public Location findBylocationName(String location) {

		return locationRepository.findByLocation(location);

	}

	/**
	 * Fetch Weather Info for location
	 * 
	 * @param locationName
	 * 
	 * @return {@link ResponseEntity<WeatherInfoDto>}
	 */
	private ResponseEntity<WeatherInfoDto> getWeatherInfo(String locationName) {

		ResponseEntity<WeatherInfoDto> weatherInfo = weatherInfoClient.getWeatherInfoforLocation(locationName);

		return weatherInfo;
	}

	/**
	 * Fetch All locations
	 * 
	 * return TemperatureDto
	 */
	@Override
	public TemperatureDto fetchAllLocationsDetails(String location) {

		Location loc = findBylocationName(location);

		// Fetch Min and max temperature for location
		ResponseEntity<WeatherInfoDto> weatherInfo = getWeatherInfo(loc.getLocation());

		return new TemperatureDto(loc,
				weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getMaxTemp(),
				weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getMinTemp(),
				weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getConditionDto()
						.getText(),
				weatherInfo.getBody().getForecastDto().getForecastDayDto().get(0).getDayDto().getConditionDto()
						.getIcon());
	}

	/**
	 * Delete location By Id
	 * 
	 * @param location
	 * 
	 */
	@Override
	public void deleteLocations(String location) {
		
		// Get location by location Name
		Location locationDetail = findBylocationName(location);
		
		// Get all Locations
		List<Location> locations = getAllLocations();
		
		// Check if Locations are empty or not
		if(!locations.isEmpty()) {
			
			// Filter out Locations
			List<Location> locationsToChange = locations.stream().filter(loc -> loc.getLocationOrder() > locationDetail.getLocationOrder()).collect(Collectors.toList());
			
			// Check if Locations are empty or not
			if(!locationsToChange.isEmpty()) {
				
				locationsToChange.forEach(loc->loc.setLocationOrder(loc.getLocationOrder()-1));
			}
		}
		
		// Delete location By location name
		locationRepository.deleteByLocation(location);

	}

	/**
	 * Fetch weather info for location
	 * 
	 * @param locationName
	 * 
	 * @return {@link ResponseEntity<WeatherInfoDto>}
	 * 
	 * @throws LocationNotFoundException
	 */
	@Override
	public ResponseEntity<WeatherInfoDto> getWeatherInfoForLocation(String locationName)
			throws LocationNotFoundException {

		Location location = findBylocationName(locationName);
		if (location == null) {

			return getWeatherInfo("Bhubaneswar");

		}

		return getWeatherInfo(locationName);
	}

	/**
	 * Fetch list of locations
	 * 
	 * @return ({@link List<Location>}
	 */

	@Override
	public List<Location> getAllLocations() {

		return locationRepository.findAll(Sort.by(Sort.Direction.ASC, "locationOrder"));
	}

	/**
	 * Update location Order for Location
	 * 
	 * @param source
	 * @param destination
	 * 
	 * @return {@link List<location>}
	 */
	@Override
	public List<Location> updateLocationOrder(Integer source, Integer destination) {
		
		List<Location> locationsToChange = null;
		
		// Fetch all locations
		List<Location> locations = getAllLocations();
		
		if(source < destination) {
			
			// Filter Locations to change
			locationsToChange = locations.stream().filter(location -> (location.getLocationOrder() >= source) 
					&& (location.getLocationOrder() <=destination)).collect(Collectors.toList());
			
			// Change the order of locations
			locationsToChange.forEach(location -> {
				if(location.getLocationOrder() == source) {
					location.setLocationOrder(destination);
				}
				else {
					location.setLocationOrder(location.getLocationOrder()-1);
				}
			});
		}
		else {
			
			// Filter Locations to change
			locationsToChange = locations.stream().filter(location -> (location.getLocationOrder() <= source) 
					&& (location.getLocationOrder() >= destination)).collect(Collectors.toList());
			
			// Change the order of locations
			locationsToChange.forEach(location -> {
				if(location.getLocationOrder() == source) {
					location.setLocationOrder(destination);
				}
				else {
					location.setLocationOrder(location.getLocationOrder() + 1);
				}
			});
		}
		
		// Save all updated Locations
		List<Location> updatedLocations = locationRepository.saveAll(locationsToChange);
		
		return updatedLocations;
	}
}
