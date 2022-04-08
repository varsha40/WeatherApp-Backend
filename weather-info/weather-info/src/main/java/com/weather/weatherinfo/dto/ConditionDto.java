package com.weather.weatherinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConditionDto {
	
	@JsonProperty("text")
	private String text;
	@JsonProperty("icon")
	private String icon;
}
