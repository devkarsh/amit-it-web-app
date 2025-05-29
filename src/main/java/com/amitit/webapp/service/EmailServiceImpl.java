package com.amitit.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.entity.User;
import com.amitit.webapp.exception.EmailServiceException;
import com.amitit.webapp.repository.UserRepository;
import com.amitit.webapp.util.EmailService;

@Service
public class EmailServiceImpl implements MessageService {

	@Autowired
	EmailService emailService;

	@Autowired
	UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Override
	public void sendRegistrationEmail(int uid) throws EmailServiceException {

		logger.debug("Sending registration email to user id: ", uid);

		User user = getUser(uid);
		String subject = "Welcome to AMIT IT!";
		String body = bodyBuilder(user);

		logger.debug("Email subject: ", subject);
		logger.debug("Email Body: ", body);

		send(user.getEmail(), subject, body);

		logger.info("Registration email sent to :", user.getEmail());
	}

	private String bodyBuilder(User user) throws EmailServiceException {
		return "Dear ;" + user.getName()
				+ ",\n\nWelcome to AMIT IT!\n\nWe are excited to have you,\n\nRegards,\nAMIT IT";
	}

	private User getUser(int uid) throws EmailServiceException {
		logger.debug("Fetching user with ID: {}", uid);
		return userRepository.findById(uid).orElseThrow(() -> {
			logger.warn("User not found with ID: {}", uid);
			return new EmailServiceException("User not found: " + uid);
		});
	}

	private void send(String recepient, String subject, String body) throws EmailServiceException {
		logger.debug("Sending email to: ", recepient);

		emailService.sendEmail(recepient, subject, body);
	}
}
