package com.amitit.webapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amitit.webapp.exception.EmailServiceException;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendEmail(String recepient, String subject, String body) throws EmailServiceException {

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("aniketnarsikar@gmail.com");
			message.setTo(recepient);
			message.setSubject(subject);
			message.setText(body);

			mailSender.send(message);
		} catch (Exception e) {

			throw new EmailServiceException("Failed to send email to: " + recepient, e);
		}
	}
}
