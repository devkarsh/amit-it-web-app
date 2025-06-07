package com.amitit.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {
	private Long batchId;
	private String batchName;
	private String time;
	private CourseDto course;

}