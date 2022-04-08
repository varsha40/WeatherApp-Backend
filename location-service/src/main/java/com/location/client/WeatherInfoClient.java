package com.location.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.location.dto.WeatherInfoDto;

@FeignClient(name = "weather-info", url = "http://localhost:8082")
public interface WeatherInfoClient {
	
	@GetMapping(value = "/weatherInfo/{location}")
	public ResponseEntity<WeatherInfoDto> getWeatherInfoforLocation(@PathVariable String location);
}
