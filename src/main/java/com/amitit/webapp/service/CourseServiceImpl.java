package com.amitit.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.dto.CourseDto;
import com.amitit.webapp.exception.CourseServiceException;
import com.amitit.webapp.repository.CourseServiceRepo;
import com.amitit.webapp.util.Constant;
import com.amitit.webapp.util.LogMessages;

@Service
public class CourseServiceImpl implements CourseService {

	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final CourseServiceRepo serviceRepo;

	public CourseServiceImpl(CourseServiceRepo serviceRepo) {
		this.serviceRepo = serviceRepo;
	}

	@Override
	public void addCourse(CourseDto dto) {
		if (dto.getName() == null || dto.getName().trim().isEmpty() || dto.getDuration() == null
				|| dto.getDuration().trim().isEmpty() || dto.getDiscription() == null
				|| dto.getDiscription().trim().isEmpty()) {
			throw new CourseServiceException(Constant.INVALID_INPUT, HttpStatus.BAD_REQUEST);
		}
		Course course = new Course();
		course.setName(dto.getName());
		course.setDuration(dto.getDuration());
		serviceRepo.save(course);
		logger.info(LogMessages.COURSE_ADDED, dto.getName());
	}

	@Override
	public CourseDto getCourse(int id) {
		Course course = serviceRepo.findById(id).orElseThrow(() -> {
			logger.warn(LogMessages.COURSE_NOT_FOUND, id);
			return new CourseServiceException(Constant.NOT_FOUND, HttpStatus.BAD_REQUEST);
		});

		CourseDto dto = new CourseDto();
		dto.setDiscription(course.getDescription());
		dto.setDuration(course.getDuration());
		dto.setName(course.getName());

		logger.info(LogMessages.COURSE_RETRIEVED, id);
		return dto;
	}

	@Override
	public void deleteCourse(int id) {

		Course course = serviceRepo.findById(id).orElseThrow(() -> {
			throw new CourseServiceException(Constant.NOT_FOUND, HttpStatus.BAD_REQUEST);

		});

		serviceRepo.deleteById(id);
		logger.info(LogMessages.COURSE_DELETED, id);
	}
	@Override
	public List<CourseDto> getAllCourse() {
		List<Course> courses = serviceRepo.findAll();
		List<CourseDto> dtoList = new ArrayList<>();

		for (Course course : courses) {
			CourseDto dto = new CourseDto();
			dto.setName(course.getName());
			dto.setDiscription(course.getDescription());
			dto.setDuration(course.getDuration());
			dtoList.add(dto);
		}

		logger.info(LogMessages.COURSE_RETRIEVAL_INFO, dtoList.size());
		return dtoList;
	}
}
