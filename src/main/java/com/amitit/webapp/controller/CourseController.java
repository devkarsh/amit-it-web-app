package com.amitit.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.constant.CourseConstant;
import com.amitit.webapp.dto.CourseDto;
import com.amitit.webapp.service.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired
	private CourseService service;

	@PostMapping
	public ResponseEntity<String> addCourse(@RequestBody CourseDto dto) {
		service.addCourse(dto);
		return new ResponseEntity(CourseConstant.COURSE_CREATED, HttpStatus.CREATED);
	}

	@GetMapping("{/id}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable("id") int id) {
		CourseDto course = service.getCourse(id);
		return new ResponseEntity(course, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") int id) {
		service.deleteCourse(id);
		return new ResponseEntity<>(CourseConstant.COURSE_DELETED, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses() {
		List<CourseDto> courses = service.getAllCourse();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

}
