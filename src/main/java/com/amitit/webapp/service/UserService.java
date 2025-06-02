package com.amitit.webapp.service;

import java.util.List;
import java.util.Optional;

import com.amitit.webapp.dto.UserProfileDTO;
import com.amitit.webapp.entity.User;

public interface UserService {
	User registerUser(User user);

	List<User> getAllUsers();

	Optional<User> findByEmail(String email);

	UserProfileDTO getUserProfile(int userId);

}
