package com.weather.weatherinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherinfo.dto.WeatherInfoDto;

@Service
public class WeatherInfoService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${service.url}")
	private String key;

	/**
	 * Fetch Weather Location Info for a location
	 * 
	 * @param location The LocationName
	 * 
	 * @return ({@link ResponseEntity<WeatherInfoDto>}
	 * @throws LocationNotFoundException
	 */
	public ResponseEntity<WeatherInfoDto> getWeatherInfoforLocation(String location) {

		ResponseEntity<WeatherInfoDto> response = null;
		try {
			
			//Fetch weather info for a location
			String url = key + location + "&days=7&aqi=yes&alerts=no";
			response = restTemplate.getForEntity(url, WeatherInfoDto.class);

		} catch (HttpClientErrorException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getStatusCode());
		}

		return response;
	}
}
