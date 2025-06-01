package com.amitit.webapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = SyllabusServiceException.class)
	public ResponseEntity handleSyllabusServiceException(SyllabusServiceException syllabusServiceException) {
		return new ResponseEntity(syllabusServiceException.getExMessage(), syllabusServiceException.getHttpStatus());
	}

}
