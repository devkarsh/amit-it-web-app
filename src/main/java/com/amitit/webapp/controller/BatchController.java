package com.amitit.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitit.webapp.constant.BatchConstant;
import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.service.BatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);

	@Autowired
	private BatchService batchService;

	@PostMapping
	public ResponseEntity<String> createBatch(@RequestBody BatchDto dto) {
		logger.info(BatchConstant.RECEIVED_CREATE_REQUEST, dto.getName());
		batchService.createBatch(dto);
		return ResponseEntity.ok(BatchConstant.BATCH_CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBatch(@PathVariable Integer id) {
		logger.info(BatchConstant.DELETING_BATCH, id);
		batchService.deleteBatch(id);
		return ResponseEntity.ok(BatchConstant.BATCH_DELETED);
	}
}