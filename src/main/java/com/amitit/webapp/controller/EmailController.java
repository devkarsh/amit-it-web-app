package com.amitit.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.exception.EmailServiceException;
import com.amitit.webapp.service.MessageService;

@RestController
@RequestMapping("email")
public class EmailController {

	@Autowired
	private MessageService messageService;

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	@PostMapping("/register/{uid}")
	public ResponseEntity sendRegistrationEmail(@PathVariable int uid) throws EmailServiceException {

		logger.info("Request to send registration email to: ", uid);

		messageService.sendRegistrationEmail(uid);

		logger.info("Registration email sent sucessfully to user with id: ", uid);

		return new ResponseEntity<>("Registration email send to: " + uid, HttpStatus.OK);
	}
}
