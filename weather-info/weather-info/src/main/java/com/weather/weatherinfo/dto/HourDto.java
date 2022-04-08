package com.weather.weatherinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HourDto {
	
	@JsonProperty("time")
	private String time;
	@JsonProperty("temp_c")
	private double tempCelcius;
	@JsonProperty("temp_f")
	private double tempFahrenheit;
	@JsonProperty("condition")
	private ConditionDto conditionDto;

}
