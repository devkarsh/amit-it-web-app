package com.amitit.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.constants.EmailServiceConstants;
import com.amitit.webapp.exception.EmailServiceException;
import com.amitit.webapp.service.MessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("email")
public class EmailController {

	@Autowired
	MessageService messageService;

	@PostMapping("/register/{uid}")
	public ResponseEntity sendRegistrationEmail(@PathVariable int uid) throws EmailServiceException {

		log.info(EmailServiceConstants.CONTROLER_REQUEST, uid);
		messageService.sendRegistrationEmail(uid);

		log.info(EmailServiceConstants.CONTROLLER_SUCCESS, uid);
		return new ResponseEntity<>(EmailServiceConstants.CONTROLLER_REG_EMAIL + uid, HttpStatus.OK);
	}
}
