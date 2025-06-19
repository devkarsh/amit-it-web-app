package com.amitit.webapp.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = SyllabusServiceException.class)
	public ResponseEntity handleSyllabusServiceException(SyllabusServiceException syllabusServiceException) {
		return new ResponseEntity(syllabusServiceException.getExMessage(), syllabusServiceException.getHttpStatus());
	}

	@ExceptionHandler(EnrollServiceException.class)
	public ResponseEntity<?> handleEnrollServiceException(EnrollServiceException ex) {
		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("status", ex.getHttpStatus().value());
		errorDetails.put("error", ex.getHttpStatus().getReasonPhrase());
		errorDetails.put("message", ex.getMessage()); // ✅ shows real error message
		errorDetails.put("path", "/enrollments"); // Optional: set dynamically

		return new ResponseEntity<>(errorDetails, ex.getHttpStatus());
	}

}
