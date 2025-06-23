package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amitit.webapp.constant.UserProfileConstants;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = SyllabusServiceException.class)
	public ResponseEntity handleSyllabusServiceException(SyllabusServiceException syllabusServiceException) {
		return new ResponseEntity(syllabusServiceException.getExMessage(), syllabusServiceException.getHttpStatus());
	}

	
	@ExceptionHandler(UserServiceException.class)
    public ResponseEntity<String> handleUserServiceException(UserServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(UserProfileConstants.UNEXPECTED_ERROR);
    }
}
