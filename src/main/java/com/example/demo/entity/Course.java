package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

    @Column(name = "name", nullable = false) // "name" column; cannot be null
    private String name;

    @Column(name = "duration") 
    private String duration;

    @Column(name = "description") // 
    private String description;

    // One-to-Many relationship with batches: One course can have many batches
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Batch> batches;

    // Many-to-Many with User (students enrolled in this course)
    @ManyToMany(mappedBy = "courses")
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "syllabus_id") 
    private Syllabus syllabus;

    
}

