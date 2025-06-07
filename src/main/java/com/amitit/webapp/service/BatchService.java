package com.amitit.webapp.service;

import com.amitit.webapp.dto.BatchDto;
import com.amitit.webapp.entity.Batch;

public interface BatchService {

	public Batch createBatch(BatchDto dto);

	public void deleteBatch(int id);
}