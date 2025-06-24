package com.amitit.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Enrollment;
import com.amitit.webapp.entity.User;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

	boolean existsByUserAndBatch(User user, Batch batch);
	int countByBatch(Batch batch);
}
