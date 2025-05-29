package com.amitit.webapp.exception;

public class EmailServiceException extends RuntimeException {

	public EmailServiceException(String message) {
		super(message);
	}

	public EmailServiceException(String message, Throwable couse) {
		super(message, couse);
	}

}
