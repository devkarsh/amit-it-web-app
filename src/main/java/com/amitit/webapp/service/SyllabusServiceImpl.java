package com.amitit.webapp.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amitit.webapp.entity.Syllabus;
import com.amitit.webapp.exception.SyllabusServiceException;
import com.amitit.webapp.repository.SyllabusRepository;
import com.amitit.webapp.constant.SyllabusConstant;

@Service
public class SyllabusServiceImpl implements SyllabusService {

	private static final Logger logger = LoggerFactory.getLogger(SyllabusServiceImpl.class);

	@Autowired
	private SyllabusRepository syllabusRepository;

	@Override
	public void addSyllabus(Syllabus syllabus) {
		logger.info(SyllabusConstant.LOG_ATTEMPT_ADD, syllabus);
		syllabusRepository.save(syllabus);
		logger.info(SyllabusConstant.LOG_ADD_SUCCESS, syllabus.getSId());
	}

	@Override
	public Syllabus getSyllabus(int sId) {
		logger.info(SyllabusConstant.LOG_ATTEMPT_RETRIEVE, sId);
		Optional<Syllabus> syllabusOptional = syllabusRepository.findById(sId);
		if (syllabusOptional.isPresent()) {
			Syllabus syllabus = syllabusOptional.get();
			logger.info(SyllabusConstant.LOG_RETRIEVE_SUCCESS, sId, syllabus);
			return syllabus;
		} else {
			logger.warn(SyllabusConstant.LOG_NOT_FOUND, sId);
			throw new SyllabusServiceException(SyllabusConstant.ERROR_SYLLABUS_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteSyllabus(int sId) {
		logger.info(SyllabusConstant.LOG_ATTEMPT_DELETE, sId);
		if (!syllabusRepository.existsById(sId)) {
			logger.warn(SyllabusConstant.LOG_DELETE_NON_EXISTENT, sId);
			throw new SyllabusServiceException(SyllabusConstant.ERROR_SYLLABUS_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		syllabusRepository.deleteById(sId);
		logger.info(SyllabusConstant.LOG_DELETE_SUCCESS, sId);
	}
}