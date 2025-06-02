package com.amitit.webapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailServiceException.class)
	public ResponseEntity handleEmailServiceException(EmailServiceException ex) {

		return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
	}

}
