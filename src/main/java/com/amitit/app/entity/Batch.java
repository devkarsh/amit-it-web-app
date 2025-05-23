package com.amitit.app.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
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

	public Batch() {
	}

	public Batch(String name, LocalDate startDate, LocalDate endDate, LocalTime time, Double fees, Integer seats) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.time = time;
		this.fees = fees;
		this.seats = seats;
	}

}
