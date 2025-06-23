package com.amitit.webapp.service;

import com.amitit.webapp.constant.UserProfileConstants;
import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.dto.CourseDto;
import com.amitit.webapp.dto.EnrollmentDto;
import com.amitit.webapp.dto.UserProfileDto;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.exception.UserServiceException;
import com.amitit.webapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import static com.amitit.webapp.UserProfileConstants;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User user) {
		log.info(UserProfileConstants.USER_REGISTRATION_ATTEMPT, user.getEmail());
		if (userRepo.findByEmail(user.getEmail()).isPresent()) {
			log.warn(UserProfileConstants.USER_EMAIL_ALREADY_EXISTS, user.getEmail());
			throw new UserServiceException(UserProfileConstants.USER_EMAIL_ALREADY_EXISTS_MSG);
		}
		User savedUser = userRepo.save(user);
		log.info(UserProfileConstants.USER_REGISTRATION_SUCCESS, savedUser.getUid());
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		log.info(UserProfileConstants.USER_FETCH_ALL);
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		log.info(UserProfileConstants.USER_FIND_BY_EMAIL, email);
		return userRepo.findByEmail(email);
	}

	@Override
	public UserProfileDto getUserProfile(int userId) {
		log.info(UserProfileConstants.USER_PROFILE_FETCH, userId);

		User user = userRepo.findById(userId)
				.orElseThrow(() -> new UserServiceException(UserProfileConstants.USER_NOT_FOUND_BY_ID + userId));

		List<EnrollmentDto> enrollmentDtos = user.getEnrollments().stream().map(enrollment -> {
			Batch batch = enrollment.getBatch();
			Course course = batch.getCourse();
			CourseDto courseDto = new CourseDto();
			BatchDto batchDto = new BatchDto(batch.getBid(), batch.getName(), batch.getName(), courseDto);

			return new EnrollmentDto(enrollment.getId(), batchDto);
		}).collect(Collectors.toList());

		log.info(UserProfileConstants.USER_PROFILE_FETCH_SUCCESS, userId);
		return new UserProfileDto(user.getUid(), user.getName(), user.getEmail(), user.getContact(),
				user.getAadhaarNo(), user.getPhotoId(), enrollmentDtos);
	}
}