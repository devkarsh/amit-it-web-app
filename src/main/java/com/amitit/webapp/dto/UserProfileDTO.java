package com.amitit.webapp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
	private int uid;
	private String name;
	private String email;
	private String contact;
	private String aadhaarNo;
	private String photoId;
	private List<EnrollmentDTO> enrollments;

}
