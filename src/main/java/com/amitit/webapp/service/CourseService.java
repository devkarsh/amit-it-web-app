package com.amitit.webapp.service;

import java.util.List;

import com.amitit.webapp.entity.dto.CourseDto;

public interface CourseService {
	public void addCourse(CourseDto dto);
	public CourseDto getCourse(int id);
	public void deleteCourse(int id);
	public List<CourseDto>getAllCourse();

}
