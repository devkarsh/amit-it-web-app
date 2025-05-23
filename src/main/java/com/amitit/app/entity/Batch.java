package com.amitit.app.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime time;
	private double fees;
	private int seats;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
	private List<User> users;

	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
	private List<Video> videos;

}
