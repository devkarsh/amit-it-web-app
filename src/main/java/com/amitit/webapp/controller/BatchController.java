package com.amitit.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.amitit.webapp.constant.BatchConstant;
import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.service.BatchService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/batch")
@Slf4j
public class BatchController {

	@Autowired
	private BatchService batchService;

	@PostMapping
	public ResponseEntity<String> createBatch(@RequestBody BatchDto dto) {
		log.info(BatchConstant.RECEIVED_CREATE_REQUEST, dto.getName());
		batchService.createBatch(dto);
		return ResponseEntity.ok(BatchConstant.BATCH_CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBatch(@PathVariable int id) {
		log.info(BatchConstant.RECEIVED_DELETE_REQUEST, id);
		batchService.deleteBatch(id);
		return ResponseEntity.ok(BatchConstant.BATCH_DELETED);
	}
}
