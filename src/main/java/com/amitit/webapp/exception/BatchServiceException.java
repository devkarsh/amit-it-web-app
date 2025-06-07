package com.amitit.webapp.exception;

import org.springframework.http.HttpStatus;

public class BatchServiceException extends RuntimeException {
    private final HttpStatus status;

    public BatchServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}