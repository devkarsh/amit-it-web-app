package com.amitit.webapp.service;

import com.amitit.webapp.dto.BatchDTO;
import com.amitit.webapp.dto.CourseDTO;
import com.amitit.webapp.dto.EnrollmentDTO;
import com.amitit.webapp.dto.UserProfileDTO;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.Enrollment;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.repository.UserRepository;
import com.amitit.webapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public UserProfileDTO getUserProfile(int userId) {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		List<EnrollmentDTO> enrollmentDTOs = user.getEnrollments().stream().map(enrollment -> {
			Batch batch = enrollment.getBatch();
			Course course = batch.getCourse();

			CourseDTO courseDTO = new CourseDTO(course.getCid(), course.getName(), course.getDescription());

			BatchDTO batchDTO = new BatchDTO(batch.getBid(), batch.getName(), batch.getName(), courseDTO);

			return new EnrollmentDTO(enrollment.getId(), batchDTO);
		}).collect(Collectors.toList());

		return new UserProfileDTO(user.getUid(), user.getName(), user.getEmail(), user.getContact(),
				user.getAadhaarNo(), user.getPhotoId(), enrollmentDTOs);
	}
}