package com.amitit.webapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.Service.EnquiryService;
import com.amitit.webapp.entity.Enquiry;

@RestController
@RequestMapping("/api") 

public class EnquiryController {
	
	 private final EnquiryService enquiryService;

	    @Autowired
	    public  EnquiryController(EnquiryService enquiryService) {
	        this.enquiryService = enquiryService;
	    }

	   
	    @PostMapping("enquiries")
	    public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry enquiry) {
	    	return new ResponseEntity<>(enquiryService.saveEnquiry(enquiry), HttpStatus.CREATED);
	    }

	    @GetMapping("enquiries")
	    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
	    	return new ResponseEntity<>(enquiryService.getAllEnquiries(), HttpStatus.OK);
	        
	        
	    }
	    @DeleteMapping("enquiry/{id}")
	    public ResponseEntity<String> deleteEnquiry(@PathVariable  int id) {
	        enquiryService.deleteEnquiryById(id);
	        return  new ResponseEntity<>("Enquiry deleted successfully!",HttpStatus.OK);
	    }


}