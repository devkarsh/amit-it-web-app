package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "bid")
	private Batch batch;
	
//	private LocalDate enrollmentDate;
//	private String status;
	

}
