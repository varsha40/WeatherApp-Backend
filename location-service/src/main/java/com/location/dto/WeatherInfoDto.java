package com.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfoDto {
	
	@JsonProperty("location")
	private LocationDto locationDto;
	@JsonProperty("current")
	private CurrentDto currentDto;
	@JsonProperty("forecast")
	private ForecastDto forecastDto;
}
