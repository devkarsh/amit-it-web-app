package com.amitit.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constant.CourseConstant;
import com.amitit.webapp.dto.CourseDto;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.exception.CourseServiceException;
import com.amitit.webapp.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class CourseServiceImpl implements CourseService {
	private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	private final CourseRepository serviceRepo;

	public CourseServiceImpl(CourseRepository serviceRepo) {
		this.serviceRepo = serviceRepo;
	}

	@Override
	public void addCourse(CourseDto dto) {
		if (dto.getName() == null || dto.getName().trim().isEmpty() || dto.getDuration() == null
				|| dto.getDuration().trim().isEmpty() || dto.getDescription() == null
				|| dto.getDescription().trim().isEmpty()) {
			throw new CourseServiceException(CourseConstant.INVALID_INPUT, HttpStatus.BAD_REQUEST);
		}
		Course course = new Course();
		course.setName(dto.getName());
		course.setDuration(dto.getDuration());
		serviceRepo.save(course);
		log.info(CourseConstant.COURSE_ADDED, dto.getName());
	}

	@Override
	public CourseDto getCourse(int id) {
		Course course = serviceRepo.findById(id).orElseThrow(() -> {
			log.warn(CourseConstant.COURSE_NOT_FOUND, id);
			return new CourseServiceException(CourseConstant.NOT_FOUND, HttpStatus.BAD_REQUEST);
		});

		CourseDto dto = new CourseDto();
		dto.setDescription(course.getDescription());
		dto.setDuration(course.getDuration());
		dto.setName(course.getName());

		log.info(CourseConstant.COURSE_RETRIEVED, id);
		return dto;
	}

	@Override
	public void deleteCourse(int id) {

		Course course = serviceRepo.findById(id).orElseThrow(() -> {
			throw new CourseServiceException(CourseConstant.NOT_FOUND, HttpStatus.BAD_REQUEST);

		});

		serviceRepo.deleteById(id);
		log.info(CourseConstant.COURSE_DELETED, id);
	}

	@Override
	public List<CourseDto> getAllCourse() {
		List<Course> courses = serviceRepo.findAll();
		List<CourseDto> dtoList = new ArrayList<>();

		for (Course course : courses) {
			CourseDto dto = new CourseDto();
			dto.setName(course.getName());
			dto.setDescription(course.getDescription());
			dto.setDuration(course.getDuration());
			dtoList.add(dto);
		}

		log.info(CourseConstant.COURSE_RETRIEVAL_INFO, dtoList.size());
		return dtoList;
	}
}
