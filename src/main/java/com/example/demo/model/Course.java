package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	
	private String name;
	private String description;
	private String duration;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "syllabus_id", referencedColumnName = "sid")
	private Syllabus syllabus;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Batch> batches;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Video> videos;

}
