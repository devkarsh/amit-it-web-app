package com.amitit.webapp.controller;

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

import com.amitit.webapp.entity.Syllabus;
import com.amitit.webapp.service.SyllabusService;

@RestController
@RequestMapping("/syllabus")
public class SyllabusController {

	@Autowired
	private SyllabusService syllabusService;

	@PostMapping
	public ResponseEntity<Syllabus> addSyllabus(@RequestBody Syllabus syllabus) {
		Syllabus savedSyllabus = syllabusService.addSyllabus(syllabus);
		return new ResponseEntity<>(savedSyllabus, HttpStatus.CREATED);
	}

	@GetMapping("/{sId}")
	public ResponseEntity<Syllabus> getSyllabus(@PathVariable Integer sId) {
		Syllabus syllabus = syllabusService.getSyllabus(sId);
		return new ResponseEntity<>(syllabus, HttpStatus.OK);
	}

	@DeleteMapping("/{sId}")
	public ResponseEntity<Void> deleteSyllabus(@PathVariable Integer sId) {
		syllabusService.deleteSyllabus(sId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}