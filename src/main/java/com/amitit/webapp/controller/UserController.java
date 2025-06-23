package com.amitit.webapp.controller;

import com.amitit.webapp.constant.UserProfileConstants;
import com.amitit.webapp.dto.UserProfileDto;
import com.amitit.webapp.entity.User;
import com.amitit.webapp.exception.UserServiceException;
import com.amitit.webapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//import static com.amitit.webapp.util.UserProfileConstants;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		log.info(UserProfileConstants.USER_REGISTRATION_ATTEMPT, user.getEmail());
		try {
			User registeredUser = userService.registerUser(user);
			log.info(UserProfileConstants.USER_REGISTRATION_SUCCESS, registeredUser.getUid());
			return ResponseEntity.ok(registeredUser);
		} catch (UserServiceException ex) {
			log.warn(UserProfileConstants.USER_SERVICE_EXCEPTION, ex.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		log.info(UserProfileConstants.USER_FETCH_ALL);
		return ResponseEntity.ok(userService.getAllUsers());
	}

	@GetMapping("/profile/{userId}")
	public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable int userId) {
		log.info(UserProfileConstants.USER_PROFILE_FETCH, userId);
		try {
			UserProfileDto profile = userService.getUserProfile(userId);
			log.info(UserProfileConstants.USER_PROFILE_FETCH_SUCCESS, userId);
			return ResponseEntity.ok(profile);
		} catch (UserServiceException ex) {
			log.warn(UserProfileConstants.USER_SERVICE_EXCEPTION, ex.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
}