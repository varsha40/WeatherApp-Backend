package com.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirQualityDto {
	
	@JsonProperty("pm2_5")
	private double airQualityIndex;
}
