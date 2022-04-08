package com.location.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDayDto {
	
	@JsonProperty("date")
	private String date;
	@JsonProperty("day")
	private DayDto dayDto;
	@JsonProperty("astro")
	private AstroDto astroDto;
	@JsonProperty("hour")
	private List<HourDto> hourDto;
}
