package com.amitit.webapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CourseServiceException.class)
	public ResponseEntity handleCourseServiceException(CourseServiceException courseexception) {
		return new ResponseEntity(courseexception.getMessage(), courseexception.getHttpStatus());
	}

}
