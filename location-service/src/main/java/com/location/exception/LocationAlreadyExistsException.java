package com.location.exception;

public class LocationAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LocationAlreadyExistsException(String message) {
		super(message);
	}
}
