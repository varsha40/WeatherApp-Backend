package com.weather.weatherinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayDto {
	
	@JsonProperty("mintemp_c")
	private double minTemp;
	@JsonProperty("maxtemp_c")
	private double maxTemp;
	@JsonProperty("daily_will_it_snow")
	private Integer willItSnow;
	@JsonProperty("daily_chance_of_rain")
	private Integer dailyChanceOfRain;
	@JsonProperty("condition")
	private ConditionDto conditionDto;
	@JsonProperty("uv")
	private Integer uv;
}
