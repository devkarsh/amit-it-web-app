package com.amitit.webapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constant.EnrollmentConstant;
import com.amitit.webapp.dto.EnrollmentRequestDTO;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Enrollment;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.exception.EnrollServiceException;
import com.amitit.webapp.repository.BatchRepository;
import com.amitit.webapp.repository.EnrollmentRepository;
import com.amitit.webapp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BatchRepository batchRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public String enrollUser(EnrollmentRequestDTO requestDTO) {

		log.info("Starting enrollment process for userId: {}, batchId: {}", requestDTO.getUserId(),
				requestDTO.getBatchId());

		User user = userRepository.findById(requestDTO.getUserId())
				.orElseThrow(() -> new EnrollServiceException(EnrollmentConstant.USER_NOT_FOUND));

		Batch batch = batchRepository.findById(requestDTO.getBatchId())
				.orElseThrow(() -> new EnrollServiceException(EnrollmentConstant.BATCH_NOT_FOUND));

		if (enrollmentRepository.existsByUserAndBatch(user, batch)) {
			log.warn("User {} already enrolled in batch {}", user.getUid(), batch.getBid());
			throw new EnrollServiceException(EnrollmentConstant.USER_ALREADY_ENROLLED);
		}

		int enrolledCount = enrollmentRepository.countByBatch(batch);
		if (enrolledCount >= batch.getSeats()) {
			log.warn("Batch {} is full. Seats: {}", batch.getBid(), batch.getSeats());
			throw new EnrollServiceException(EnrollmentConstant.BATCH_FULL);
		}

		Enrollment enrollment = new Enrollment();
		enrollment.setUser(user);
		enrollment.setBatch(batch);
		enrollment.setEnrollmentDate(LocalDate.now());
		enrollment.setStatus(EnrollmentConstant.STATUS_ACTIVE);

		enrollmentRepository.save(enrollment);

		log.info("User {} successfully enrolled in Batch {} on {}", user.getUid(), batch.getBid(),
				enrollment.getEnrollmentDate());
		return EnrollmentConstant.ENROLLED;
	}

}
