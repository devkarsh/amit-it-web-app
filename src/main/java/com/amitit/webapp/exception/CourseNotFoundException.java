package com.amitit.webapp.exception;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException (String message)
	{
		super(message);
	}

}
