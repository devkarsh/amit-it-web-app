package com.amitit.webapp.dto;

import lombok.Data;

@Data
public class CourseDto {
	private Long cid;

	private String name;
	private String description;
	private String duration;

}
