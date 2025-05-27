package com.amitit.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitit.webapp.entity.Course;

public interface CourseRepository  extends JpaRepository<Course, Long>{

}
