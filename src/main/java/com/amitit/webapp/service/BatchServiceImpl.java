package com.amitit.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constant.BatchConstant;
import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.exception.BatchServiceException;
import com.amitit.webapp.repository.BatchRepository;
import com.amitit.webapp.repository.CourseRepository;

@Service
public class BatchServiceImpl implements BatchService {

	private static final Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

	@Autowired
	private BatchRepository batchRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Batch createBatch(BatchDto dto) {

		logger.info(BatchConstant.CREATING_BATCH, dto.getCourseId());
		try {
			Course course = courseRepo.findById(dto.getCourseId())
					.orElseThrow(() -> new BatchServiceException(BatchConstant.COURSE_NOT_FOUND + dto.getCourseId()));

			Batch batch = new Batch();
			batch.setName(dto.getName());
			batch.setStartDate(dto.getStartDate());
			batch.setEndDate(dto.getEndDate());
			batch.setTime(dto.getTime());
			batch.setFees(dto.getFees());
			batch.setSeats(dto.getSeats());
			batch.setCourse(course);
			Batch saved = batchRepo.save(batch);
			logger.info(BatchConstant.BATCH_CREATED_LOG, saved.getBid());
			return saved;
		} catch (Exception e) {
			logger.error(BatchConstant.BATCH_CREATION_FAILED + e.getMessage(), e);
			throw new BatchServiceException(BatchConstant.BATCH_CREATION_FAILED + e.getMessage());
		}

	}

	@Override
	public void deleteBatch(int id) {
		logger.info(BatchConstant.DELETING_BATCH, id);

		try {
			Batch batch = batchRepo.findById(id)
					.orElseThrow(() -> new BatchServiceException(BatchConstant.BATCH_NOT_FOUND + id));
			batchRepo.delete(batch);
			logger.info(BatchConstant.BATCH_DELETED_LOG, id);
		} catch (Exception e) {
			logger.error(BatchConstant.BATCH_DELETION_FAILED + e.getMessage(), e);
			throw new BatchServiceException(BatchConstant.BATCH_DELETION_FAILED);
		}
	}
}