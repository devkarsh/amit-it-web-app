package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;

public class UserServiceException extends RuntimeException {
	private HttpStatus status;
	private String message;

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {

		return status;
	}

	public String getMessage() {

		return message;
	}
}