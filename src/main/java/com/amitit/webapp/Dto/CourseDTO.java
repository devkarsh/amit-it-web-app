package com.amitit.webapp.Dto;

import java.util.List;
import lombok.Data;


public class CourseDTO {
    private String name;
    private String description;
    private String duration;

    private SyllabusDTO syllabus;
    private List<BatchDTO> batches;
    private List<VideoDTO> videos; // ✅ This must exist and be imported correctly
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
	public List<VideoDTO> getVideos() {
		return videos;
	}
	public void setVideos(List<VideoDTO> videos) {
		this.videos = videos;
	}
    
    
}
