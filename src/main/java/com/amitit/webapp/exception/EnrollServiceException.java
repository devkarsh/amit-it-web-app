package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;

public class EnrollServiceException extends RuntimeException {

	private final HttpStatus httpStatus;

	public EnrollServiceException(String message) {
		super(message); // ✅ sets the message correctly
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public EnrollServiceException(String message, HttpStatus httpStatus) {
		super(message); // ✅ sets the message
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
