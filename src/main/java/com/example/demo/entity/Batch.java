package com.example.demo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Batch {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "time")
    private String time;

    @Column(name = "fees")
    private double fees;

    @Column(name = "seats")
    private int seats;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
  
    private Course course;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
   
    private List<User> users;

    public Batch() {}

    public Batch(String name, LocalDate startDate, LocalDate endDate, String time, Double fees, Integer seats) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.time = time;
        this.fees = fees;
        this.seats = seats;
    }

  
}
