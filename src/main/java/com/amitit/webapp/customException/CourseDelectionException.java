package com.amitit.webapp.customException;

public class CourseDelectionException extends RuntimeException {

	private String message;

	public CourseDelectionException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
}
