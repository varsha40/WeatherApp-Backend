package com.location.dto;

import com.location.models.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureDto {
	
	private Location location;
	private double minTemp;
	private double maxTemp;
	private String text;
	private String icon;
	
}
