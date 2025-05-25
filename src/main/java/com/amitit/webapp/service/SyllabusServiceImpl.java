package com.amitit.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.amitit.webapp.entity.Syllabus;
import com.amitit.webapp.repository.SyllabusRepository;

public class SyllabusServiceImpl implements SyllabusService {

	@Autowired
	SyllabusRepository syllabusRepository;

	@Override
	public void addSyllabus(Syllabus syllabus) {

		syllabusRepository.save(syllabus);
	}

	@Override
	public Syllabus getSyllabus(Long sId) {

		return syllabusRepository.findById(sId).get();
	}

	@Override
	public void deleteSyllabus(Long sId) {

		syllabusRepository.deleteById(sId);
	}

}
