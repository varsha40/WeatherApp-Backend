package com.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AstroDto {
	
	@JsonProperty("sunrise")
	private String sunrise;
	@JsonProperty("sunset")
	private String sunset;
}
