package com.amitit.webapp.Dto;

import java.util.List;
import lombok.Data;


public class CourseResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String duration;

    private SyllabusDTO syllabus;
    private List<BatchDTO> batches;
   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public SyllabusDTO getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(SyllabusDTO syllabus) {
		this.syllabus = syllabus;
	}
	public List<BatchDTO> getBatches() {
		return batches;
	}
	public void setBatches(List<BatchDTO> batches) {
		this.batches = batches;
	}
	
    
    
    
}
