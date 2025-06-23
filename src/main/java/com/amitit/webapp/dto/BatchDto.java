package com.amitit.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
	private Long batchId;
	private String batchName;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime time;
	private double fees;
	private int seats;
	private int courseId;
	private CourseDto course;
}
