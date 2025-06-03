package com.amitit.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitit.webapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
