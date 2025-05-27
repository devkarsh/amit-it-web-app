package com.amitit.webapp.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amitit.webapp.customException.CheckCourse;
import com.amitit.webapp.customException.CourseCreationException;
import com.amitit.webapp.customException.CourseDelectionException;

@ControllerAdvice
public class Gobal {

	@ExceptionHandler(CourseCreationException.class)
	public ResponseEntity addCourseException(CourseCreationException exception)
	{
		return new ResponseEntity(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CourseDelectionException.class)
	public ResponseEntity deleteCours(CourseDelectionException delection)
	{
		return new ResponseEntity(delection.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CheckCourse.class)
	public ResponseEntity check(CheckCourse check)
	{
		return new ResponseEntity(check.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
