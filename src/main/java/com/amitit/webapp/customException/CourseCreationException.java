package com.amitit.webapp.customException;

public class CourseCreationException extends RuntimeException {
	
	private  String message;

	public CourseCreationException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
	
	

}
