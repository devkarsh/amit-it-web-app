package com.amitit.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.dto.EnrollmentRequestDTO;
import com.amitit.webapp.service.EnrollmentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/enrollments")
@Validated
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	@PostMapping
	public ResponseEntity<String> enrollUser(@Valid @RequestBody EnrollmentRequestDTO requestDTO) {
		log.debug("Received enrollment request: {}", requestDTO);
		String result = enrollmentService.enrollUser(requestDTO);
		log.debug("Enrollment result: {}", result);
		return ResponseEntity.ok(result);
	}

}
