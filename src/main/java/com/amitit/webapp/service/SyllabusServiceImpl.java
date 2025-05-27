package com.amitit.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.amitit.webapp.entity.Syllabus;
import com.amitit.webapp.repository.SyllabusRepository;

@Service
public class SyllabusServiceImpl implements SyllabusService {

	@Autowired
	private SyllabusRepository syllabusRepository;

	@Override
	public Syllabus addSyllabus(Syllabus syllabus) {
		try {
			return syllabusRepository.save(syllabus);
		} catch (DataAccessException e) {
			System.err.println("Error saving syllabus: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Failed to save syllabus due to a data access issue", e);
		} catch (Exception e) {
			System.err.println("Unexpected error while saving syllabus: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An unexpected error occurred while saving the syllabus", e);
		}
	}

	@Override
	public Syllabus getSyllabus(Integer sId) {
		Optional<Syllabus> syllabusOptional = syllabusRepository.findById(Long.valueOf(sId));
		if (syllabusOptional.isPresent()) {
			return syllabusOptional.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Syllabus with ID " + sId + " not found");
		}
	}

	@Override
	public void deleteSyllabus(Integer sId) {
		try {
			syllabusRepository.deleteById(Long.valueOf(sId));
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Syllabus with ID " + sId + " not found", e);
		} catch (Exception e) {
			System.err.println("Error deleting syllabus with ID " + sId + ": " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"An error occurred while deleting the syllabus", e);
		}
	}

}
