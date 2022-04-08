package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.location.dto.TemperatureDto;
import com.location.dto.WeatherInfoDto;
import com.location.exception.InvalidLocationNameException;
import com.location.exception.LocationAlreadyExistsException;
import com.location.exception.LocationNotFoundException;
import com.location.models.Location;
import com.location.service.LocationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/location")
@Transactional
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	/**
	 * Save location
	 * 
	 * @param locationName
	 * 
	 * @return TemperatureDto
	 * @throws LocationAlreadyExistsException
	 * @throws InvalidLocationNameException 
	 * @throws LocationNotFoundException 
	 */
	@PostMapping("/{locationName}")
	public TemperatureDto saveLocation(@PathVariable String locationName) throws LocationAlreadyExistsException, InvalidLocationNameException, LocationNotFoundException {
		 
		 return locationService.saveLocation(locationName);
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

	@GetMapping("/{location}")
	public ResponseEntity<WeatherInfoDto> getWeatherInfoForLocation(@PathVariable String location) throws LocationNotFoundException {
		
		return locationService.getWeatherInfoForLocation(location);
	}
	
	/**
	 * Get Weather Info for all locations
	 * 
	 * @param location
	 * 
	 * @return  TemperatureDto
	 */
	@GetMapping("/all-info/{location}")
	public TemperatureDto getWeatherInfoForAllLocations(@PathVariable String location){
		
		return locationService.fetchAllLocationsDetails(location);
	}
	
	/**
	 * Get Weather Info for all locations
	 * 
	 * @return {@link List<Location>}
	 */
	@GetMapping("/all")
	public List<Location> getAllLocations(){
		
		return locationService.getAllLocations();
	}
	
	/**
	 * Update location Order for Location
	 * 
	 * @param source
	 * @param destination
	 *
	 * @return {@link List<Location>}
	 */
	@PutMapping("/location-order")
	public List<Location> updateLocationOrder(@RequestParam Integer source, @RequestParam Integer destination) {
		
		return locationService.updateLocationOrder(source, destination);
	}
	
	/**
	 * Delete location By Id
	 * 
	 * @param location
	 * 
	 */
	@DeleteMapping("/{location}")
	public void deleteLocation(@PathVariable String location) {
		
		locationService.deleteLocations(location);
	}
	
}
