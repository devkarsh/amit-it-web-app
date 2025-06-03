package com.amitit.webapp.constants;

public class EmailServiceConstants {

	// EmailService
	public static final String EMAIL_PREPARE = "Preparing to send email to: {}";
	public static final String EMAIL_SENT_SUCCESS = "Email sent successfully to: {}";
	public static final String EMAIL_SEND_FAILED = "Failed to send email to{}: {}";

	// EmailServiceImpl
	public static final String SENDING_REG_EMAIL = "Sending registration email to user id: {}";
	public static final String FETCHING_USER = "Fetching user with ID: {}";
	public static final String USER_NOT_FOUND = "User not found with id: {}";
	public static final String EMAIL_SUBJECT = "Email Subject: {}";
	public static final String EMAIL_BODY = "Email Body: {}";
	public static final String SENDING_EMAIL_TO = "Sending Email to: {}";
	public static final String EMAIL_SENT_TO = "Email sent to: {}";

	// EmailController
	public static final String CONTROLER_REQUEST = "Request to send registration email to: {}";
	public static final String CONTROLLER_SUCCESS = "Regitration Email sent successfully to user with id: {}";
	public static final String CONTROLLER_REG_EMAIL = "Registration email send to: ";

	// Exception Constants
	public static final String EXCEPTION_USER_NOT_FOUND = "user not found :";
	public static final String EXCEPTION_EMAIL_SEND_FAILED = "Failed to send email to: ";

	private EmailServiceConstants() {
	}
}
