package com.amitit.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitit.webapp.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {

}