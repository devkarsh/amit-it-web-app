package com.amitit.webapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
		@ExceptionHandler(exception = SyllabusServiceException.class)
		public ResponseEntity handleEmployeeServiceException(SyllabusServiceException ese) {
			return new ResponseEntity(ese.getExMessage(), ese.getHttpStatus());
		}
		
}
