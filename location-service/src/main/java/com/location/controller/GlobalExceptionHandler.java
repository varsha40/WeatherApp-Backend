package com.location.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.location.exception.InvalidLocationNameException;
import com.location.exception.LocationAlreadyExistsException;
import com.location.exception.LocationNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
     * Method is used to handle InvalidLocationNameException.
     * 
     * @param e : InvalidLocationNameException class object.
     * @return ResponseEntity : String containing the error message.
     */
    @ExceptionHandler({ InvalidLocationNameException.class })
    public ResponseEntity<String> invalidLocationNameException(InvalidLocationNameException e) {
    	
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }
    
	/**
     * Method is used to handle UserNotFoundException.
     * 
     * @param e : UserNotFoundException class object.
     * @return ResponseEntity : Object containing the response status and Response object.
     */
    @ExceptionHandler({ LocationAlreadyExistsException.class })
    public ResponseEntity<String> locationAlreadyExistsException(LocationAlreadyExistsException e) {
    	
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }
    
	/**
     * Method is used to handle UserNotFoundException.
     * 
     * @param e : UserNotFoundException class object.
     * @return ResponseEntity : Object containing the response status and Response object.
     */
    @ExceptionHandler({ LocationNotFoundException.class })
    public ResponseEntity<String> locationNotFoundException(LocationNotFoundException e) {
    	
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    } 
}
