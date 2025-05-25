package com.amitit.webapp.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	
	private String name;
	private String email;
	private String password;
//	private String address;
	private String contact;
	// This is sample comment
	
//	@Column(name = "aadhaar_no")
	private String aadhaarNo;
	
//	@Column(name = "photo_id")
	private String photoId;
	
	@OneToMany(mappedBy = "user")
	private List<Enrollment> enrollments;

}
