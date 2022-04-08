package com.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentDto {
	
	@JsonProperty("temp_c")
	private double tempCelcius;
	@JsonProperty("temp_f")
	private double tempfahrenheit;
	@JsonProperty("condition")
	private ConditionDto conditionDto;
	@JsonProperty("wind_mph")
	private double windSpeed;
	@JsonProperty("precip_in")
	private double precipitation;
	@JsonProperty("humidity")
	private Integer humidity;
	@JsonProperty("feelslike_c")
	private Integer feelsLike;
	@JsonProperty("air_quality")
	private AirQualityDto airQualityDto;
}
