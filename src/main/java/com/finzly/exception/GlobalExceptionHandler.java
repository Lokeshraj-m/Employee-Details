package com.finzly.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {
	@ExceptionHandler(ResourceEmptyException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceEmptyException resourceNotFoundException){
		return new ResponseEntity<String>("No employee details with id", HttpStatus.BAD_REQUEST);
	}
}
