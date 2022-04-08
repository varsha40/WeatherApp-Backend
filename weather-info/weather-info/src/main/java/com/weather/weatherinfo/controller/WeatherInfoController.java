package com.weather.weatherinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weatherinfo.dto.WeatherInfoDto;
import com.weather.weatherinfo.service.WeatherInfoService;

@RequestMapping("/weatherInfo")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherInfoController {

	@Autowired
	private WeatherInfoService weatherInfoService;
	
	/**
	 * Fetch Weather Location Info for a location
	 * 
	 * @param location The LocationName
	 * 
	 * @return ({@link ResponseEntity<WeatherInfoDto>}
	 * @throws LocationNotFoundException 
	 */
	@GetMapping("/{location}")
	public ResponseEntity<WeatherInfoDto> getWeatherInfoforLocation(@PathVariable String location){
		
		return weatherInfoService.getWeatherInfoforLocation(location);
	}
}
