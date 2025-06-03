package com.amitit.webapp.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BatchDto {

	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String time;
	private Double fees;
	private Integer seats;
	private Integer courseId;
}
