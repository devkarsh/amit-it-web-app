package com.amitit.webapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constant.EmailServiceConstants;
import com.amitit.webapp.exception.EmailServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(String recepient, String subject, String body) throws EmailServiceException {

		try {
			log.debug(EmailServiceConstants.EMAIL_PREPARE, recepient);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("aniketnarsikar@gmail.com");
			message.setTo(recepient);
			message.setSubject(subject);
			message.setText(body);

			mailSender.send(message);

			log.info(EmailServiceConstants.EMAIL_SENT_SUCCESS, recepient);
		} catch (Exception e) {

			log.error(EmailServiceConstants.EMAIL_SEND_FAILED, recepient, e.getMessage(), e);
			throw new EmailServiceException(EmailServiceConstants.EXCEPTION_EMAIL_SEND_FAILED + recepient);
		}
	}
}
