package com.amitit.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.dto.CourseDto;
import com.amitit.webapp.exception.CourseNotFoundException;
import com.amitit.webapp.repository.CourseServiceRepo;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final CourseServiceRepo serviceRepo;

    public CourseServiceImpl(CourseServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public void addCourse(CourseDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDuration(dto.getDuration());
        serviceRepo.save(course);
        logger.info("Course added: {}", dto.getName());
    }

    @Override
    public CourseDto getCourse(int id) {
        Course course = serviceRepo.findById(id)
            .orElseThrow(() -> {
                logger.warn("Course not found with id: {}", id);
                return new CourseNotFoundException("Course not found with id: " + id);
            });

        CourseDto dto = new CourseDto();
        dto.setDiscription(course.getDescription());
        dto.setDuration(course.getDuration());
        dto.setName(course.getName());

        logger.info("Course retrieved with id: {}", id);
        return dto;
    }

    @Override
    public void deleteCourse(int id) {
        Optional<Course> optional = serviceRepo.findById(id);
        if (optional.isEmpty()) {
        	logger.error("No course exists with the given ID for deletion: {}", id);            
        	throw new CourseNotFoundException("Course not found with id: " + id);
        }
        serviceRepo.deleteById(id);
        logger.info("Course deleted with id: {}", id);
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

        logger.info("Retrieved all courses. Total: {}", dtoList.size());
        return dtoList;
    }
}
