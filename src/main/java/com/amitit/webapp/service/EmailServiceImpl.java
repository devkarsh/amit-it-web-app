package com.amitit.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constants.EmailServiceConstants;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.exception.EmailServiceException;
import com.amitit.webapp.repository.UserRepository;
import com.amitit.webapp.util.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailServiceImpl implements MessageService {

	@Autowired
	EmailService emailService;

	@Autowired
	UserRepository userRepository;

	@Override
	public void sendRegistrationEmail(int uid) throws EmailServiceException {
		log.debug(EmailServiceConstants.SENDING_REG_EMAIL, uid);
		User user = getUser(uid);

		String subject = "Welcome to AMIT IT!";
		String body = bodyBuilder(user);
		log.debug(EmailServiceConstants.EMAIL_SUBJECT, subject);
		log.debug(EmailServiceConstants.EMAIL_BODY, body);
		send(user.getEmail(), subject, body);
		log.info(EmailServiceConstants.EMAIL_SENT_TO, user.getEmail());
	}

	private String bodyBuilder(User user) throws EmailServiceException {
		return "Dear, " + user.getName()
				+ ",\n\nWelcome to AMIT IT!\n\nWe are excited to have you,\n\nRegards,\nAMIT IT";
	}

	private User getUser(int uid) throws EmailServiceException {

		log.debug(EmailServiceConstants.FETCHING_USER, uid);
		return userRepository.findById(uid).orElseThrow(() -> {
			log.warn(EmailServiceConstants.USER_NOT_FOUND, uid);
			return new EmailServiceException(EmailServiceConstants.EXCEPTION_USER_NOT_FOUND + uid);
		});
	}

	private void send(String recepient, String subject, String body) throws EmailServiceException {
		log.debug(EmailServiceConstants.SENDING_EMAIL_TO, recepient);
		emailService.sendEmail(recepient, subject, body);
	}
}
