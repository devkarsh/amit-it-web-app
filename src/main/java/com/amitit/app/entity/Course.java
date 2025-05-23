package com.amitit.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String duration;
	private String description;

	@ManyToMany(mappedBy = "courses")
	private List<User> users;
	@OneToOne(mappedBy = "course_id", cascade = CascadeType.ALL)
	@JsonIgnore
	private Syllabus syllabus;

    // One-to-Many relationship with batches: One course can have many batches
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Batch> batches;

}
