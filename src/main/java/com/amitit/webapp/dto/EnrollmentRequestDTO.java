package com.amitit.webapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnrollmentRequestDTO {

	@NotNull(message = "User ID is required")
	private int userId;

	@NotNull(message = "Batch ID is required")
	private int batchId;
}
