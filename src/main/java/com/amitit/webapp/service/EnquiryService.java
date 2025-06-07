package com.amitit.webapp.service;

import java.util.List;

import com.amitit.webapp.entity.Enquiry;

public interface EnquiryService {
	Enquiry saveEnquiry(Enquiry enquiry) throws Exception;

	List<Enquiry> getAllEnquiries( ) throws Exception;

	void deleteEnquiryById(int id) throws Exception ;

}
