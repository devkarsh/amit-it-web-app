package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CourseServiceException.class)
public ResponseEntity handleException(CourseServiceException exception)
{
	return new ResponseEntity(exception.getMessage(),exception.getHttpStatus());
}

	

}


