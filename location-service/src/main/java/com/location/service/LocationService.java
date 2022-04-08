package com.location.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.location.dto.TemperatureDto;
import com.location.dto.WeatherInfoDto;
import com.location.exception.InvalidLocationNameException;
import com.location.exception.LocationAlreadyExistsException;
import com.location.exception.LocationNotFoundException;
import com.location.models.Location;

@Service
public interface LocationService {

	TemperatureDto saveLocation(String location)
			throws LocationAlreadyExistsException, InvalidLocationNameException, LocationNotFoundException;

	TemperatureDto fetchAllLocationsDetails(String location);

	List<Location> getAllLocations();

	void deleteLocations(String location);

	ResponseEntity<WeatherInfoDto> getWeatherInfoForLocation(String location) throws LocationNotFoundException;

	List<Location> updateLocationOrder(Integer source, Integer destination);

}
