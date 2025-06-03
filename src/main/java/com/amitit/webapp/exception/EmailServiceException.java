package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;

public class EmailServiceException extends RuntimeException {

	private HttpStatus status;

	public EmailServiceException(String message) {
		super(message);
	}

	public EmailServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {

		return status;
	}

}
