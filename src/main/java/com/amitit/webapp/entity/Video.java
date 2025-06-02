package com.amitit.webapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vid;
	
	private String name;
	private LocalDate date;
	private Long size;
	private String duration;
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "batch_id")
	private Batch batch;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

}
