package com.amitit.webapp.service;

import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.dto.CourseDto;
import com.amitit.webapp.dto.EnrollmentDto;
import com.amitit.webapp.dto.UserProfileDto;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.Enrollment;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.repository.UserRepository;
import com.amitit.webapp.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User user) {
		log.info("Attempting to register user with email: {}", user.getEmail());

		if (userRepo.findByEmail(user.getEmail()).isPresent()) {
			log.warn("Registration failed: Email {} already exists", user.getEmail());
			throw new IllegalArgumentException("Email is already registered");
		}

		User savedUser = userRepo.save(user);
		log.info("User registered successfully with ID: {}", savedUser.getUid());
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		log.info("Fetching all users from the database");
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		log.info("Searching for user with email: {}", email);
		return userRepo.findByEmail(email);
	}

	@Override
	public UserProfileDto getUserProfile(int userId) {
		log.info("Fetching profile for user ID: {}", userId);

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

		List<EnrollmentDto> enrollmentDtos = user.getEnrollments().stream().map(enrollment -> {
			Batch batch = enrollment.getBatch();
			Course course = batch.getCourse();

			CourseDto courseDto = new CourseDto();
			BatchDto batchDto = new BatchDto(batch.getBid(), batch.getName(), batch.getDescription(), courseDto);

			return new EnrollmentDto(enrollment.getId(), batchDto);
		}).collect(Collectors.toList());

		log.info("Successfully fetched profile for user ID: {}", userId);
		return new UserProfileDto(user.getUid(), user.getName(), user.getEmail(), user.getContact(),
				user.getAadhaarNo(), user.getPhotoId(), enrollmentDtos);
	}
}