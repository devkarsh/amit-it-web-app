package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String name;
	private String email;
	private String password;
	private String address;
	@Column(name = "contact_number")
	private int contactNumber;
	private String adhar;
	@Column(name = "photo_id")
	private String photoId;

	// Many users to one batch
	@ManyToOne
	@JoinColumn(name = "batch_id") // Foreign key in the User table
	private Batch batch;

	// Many-to-many with Course
	@ManyToMany
	@JoinTable(name = "user_courses", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses;

	
	public User() {}
	
	public User(int uid, String name, String email, String password, String address, int contactNumber, String adhar,
			String photoId, Batch batch, Set<Course> courses) {
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.contactNumber = contactNumber;
		this.adhar = adhar;
		this.photoId = photoId;
		this.batch = batch;
		this.courses = courses;
	}

}
