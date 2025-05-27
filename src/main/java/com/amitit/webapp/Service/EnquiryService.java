package com.amitit.webapp.Service;

import java.util.List;

import com.amitit.webapp.entity.Enquiry;

public interface EnquiryService {
	  Enquiry saveEnquiry(Enquiry enquiry);
	    List<Enquiry> getAllEnquiries();
	    void deleteEnquiryById(int id);
	    

}
