package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Video {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "name") // Video title or label
	    private String name;

	    @Column(name = "date") // Upload or recording date
	    private String date;

	    @Column(name = "size") // Size in KB/MB
	    private int size;

	    @Column(name = "duration") // Video length, e.g., "12 min"
	    private String duration;

	    @Column(name = "location") // File path to the video
	    private String location;

	  

}
