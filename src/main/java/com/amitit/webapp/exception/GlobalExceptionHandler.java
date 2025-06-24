package com.amitit.webapp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amitit.webapp.constant.UserProfileConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SyllabusServiceException.class)
    public ResponseEntity<?> handleSyllabusServiceException(SyllabusServiceException syllabusServiceException) {
        return new ResponseEntity<>(syllabusServiceException.getExMessage(), syllabusServiceException.getHttpStatus());
    }

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<String> handleUserServiceException(UserServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(UserProfileConstants.UNEXPECTED_ERROR);
    }

    @ExceptionHandler(EnrollServiceException.class)
    public ResponseEntity<?> handleEnrollServiceException(EnrollServiceException ex) {
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("status", ex.getHttpStatus().value());
        errorDetails.put("error", ex.getHttpStatus().getReasonPhrase());
        errorDetails.put("message", ex.getMessage());
        errorDetails.put("path", "/enrollments");

        return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
    }
}

