package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;

public class CourseServiceException extends RuntimeException {
	private String exMessage;
	private HttpStatus httpStatus;

	public CourseServiceException(String exMessage, HttpStatus httpStatus) {
		this.exMessage = exMessage;
		this.httpStatus = httpStatus;
	}

	public String getExMessage() {
		return exMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}