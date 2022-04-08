package com.location.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDto {
	
	@JsonProperty("forecastday")
	private List<ForecastDayDto> forecastDayDto;
}
