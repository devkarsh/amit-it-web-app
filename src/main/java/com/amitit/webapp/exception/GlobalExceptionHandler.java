package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CourseNotFoundException.class)
public ResponseEntity handleException(CourseNotFoundException exception)
{
	return new ResponseEntity(exception.getMessage(),HttpStatus.BAD_REQUEST);
}

	

}
