package com.amitit.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amitit.webapp.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

}
