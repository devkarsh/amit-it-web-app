package com.amitit.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constants.EmailLoggerMessages;
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
		log.debug(EmailLoggerMessages.SENDING_REG_EMAIL, uid);
		User user = getUser(uid);

		String subject = "Welcome to AMIT IT!";
		String body = bodyBuilder(user);
		log.debug(EmailLoggerMessages.EMAIL_SUBJECT, subject);
		log.debug(EmailLoggerMessages.EMAIL_BODY, body);

		send(user.getEmail(), subject, body);
		log.info(EmailLoggerMessages.EMAIL_SENT_TO, user.getEmail());
	}

	private String bodyBuilder(User user) throws EmailServiceException {
		return "Dear, " + user.getName()
				+ ",\n\nWelcome to AMIT IT!\n\nWe are excited to have you,\n\nRegards,\nAMIT IT";
	}

	private User getUser(int uid) throws EmailServiceException {

		log.debug(EmailLoggerMessages.FETCHING_USER, uid);
		return userRepository.findById(uid).orElseThrow(() -> {
			log.warn(EmailLoggerMessages.USER_NOT_FOUND, uid);
			return new EmailServiceException("user not found :" + uid);
		});
	}

	private void send(String recepient, String subject, String body) throws EmailServiceException {
		log.debug(EmailLoggerMessages.SENDING_EMAIL_TO, recepient);
		emailService.sendEmail(recepient, subject, body);
	}
}
