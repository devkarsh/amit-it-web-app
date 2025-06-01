package com.amitit.webapp.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.Repository.EnquiryRepository;
import com.amitit.webapp.Service.EnquiryService;
import com.amitit.webapp.entity.Enquiry;

@Service
public class EnquaryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepo;

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
		return enquiryRepo.save(enquiry);
	}

	@Override
	public List<Enquiry> getAllEnquiries() {
		return enquiryRepo.findAll();
	}

	@Override
	public void deleteEnquiryById(int id) {
		enquiryRepo.deleteById(id);

	}
}
