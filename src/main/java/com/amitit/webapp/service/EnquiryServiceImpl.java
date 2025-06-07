package com.amitit.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.Repository.EnquiryRepository;
import com.amitit.webapp.Service.EnquiryService;
import com.amitit.webapp.entity.Enquiry;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class EnquiryServiceImpl  implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepo;

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) throws Exception {
        log.info("Saving enquiry: {}", enquiry);
        return enquiryRepo.save(enquiry); 
    }

	@Override
	public List<Enquiry> getAllEnquiries()  throws Exception {
        log.info("Fetching all enquiries");
		return enquiryRepo.findAll();
	}

	@Override
	public void deleteEnquiryById(int id) throws Exception {
        log.info("Deleting enquiry with id: {}", id);
		enquiryRepo.deleteById(id);

	}
}
