package com.amitit.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amitit.webapp.constant.BatchConstant;
import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.exception.BatchServiceException;
import com.amitit.webapp.repository.BatchRepository;
import com.amitit.webapp.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository batchRepo;

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Batch createBatch(BatchDto dto) {
		log.info(BatchConstant.CREATING_BATCH, dto.getCourseId());

		Course course = courseRepo.findById(dto.getCourseId())
				.orElseThrow(() -> new BatchServiceException(BatchConstant.COURSE_NOT_FOUND + dto.getCourseId(),
						HttpStatus.NOT_FOUND));

		Batch batch = new Batch();
		batch.setName(dto.getName());
		batch.setStartDate(dto.getStartDate());
		batch.setEndDate(dto.getEndDate());
		batch.setTime(dto.getTime());
		batch.setFees(dto.getFees());
		batch.setSeats(dto.getSeats());
		batch.setCourse(course);

		Batch saved = batchRepo.save(batch);
		log.info(BatchConstant.BATCH_CREATED_LOG, saved.getBid());
		return saved;
	}

	@Override
	public void deleteBatch(int id) {
		log.info(BatchConstant.DELETING_BATCH, id);

		Batch batch = batchRepo.findById(id).orElseThrow(
				() -> new BatchServiceException(BatchConstant.BATCH_NOT_FOUND.formatted(id), HttpStatus.NOT_FOUND));

		batchRepo.delete(batch);
		log.info(BatchConstant.BATCH_DELETED_LOG, id);
	}

}
