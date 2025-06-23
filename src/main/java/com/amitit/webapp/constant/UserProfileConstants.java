package com.amitit.webapp.constant;

public class UserProfileConstants {
	// Log Messages
	public static final String USER_REGISTRATION_ATTEMPT = "Attempting to register user with email: {}";
	public static final String USER_EMAIL_ALREADY_EXISTS = "Registration failed: Email {} already exists";
	public static final String USER_REGISTRATION_SUCCESS = "User registered successfully with ID: {}";
	public static final String USER_FETCH_ALL = "Fetching all users from the database";
	public static final String USER_FIND_BY_EMAIL = "Searching for user with email: {}";
	public static final String USER_PROFILE_FETCH = "Fetching profile for user ID: {}";
	public static final String USER_PROFILE_FETCH_SUCCESS = "Successfully fetched profile for user ID: {}";
	public static final String USER_SERVICE_EXCEPTION = "UserService exception: {}";
	public static final String RESOURCE_NOT_FOUND = "Resource not found: {}";
	public static final String UNHANDLED_EXCEPTION = "Unhandled exception: {}";

	// Exception Messages
	public static final String USER_EMAIL_ALREADY_EXISTS_MSG = "Email is already registered";
	public static final String USER_NOT_FOUND_BY_ID = "User not found with ID: ";
	public static final String USER_NOT_FOUND_BY_EMAIL = "User not found with email: ";
	public static final String UNEXPECTED_ERROR = "An unexpected error occurred.";

}
