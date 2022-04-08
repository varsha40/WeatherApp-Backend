package com.weather.weatherinfo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastDto {
	
	@JsonProperty("forecastday")
	private List<ForecastDayDto> forecastDayDto;
}
