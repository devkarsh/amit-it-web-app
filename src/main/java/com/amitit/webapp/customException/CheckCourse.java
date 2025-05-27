package com.amitit.webapp.customException;

public class CheckCourse extends RuntimeException{
	
	private String message;

	public CheckCourse(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	

}
