package com.amitit.webapp.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class BatchDto {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String time;
    private double fees;
    private int seats;
    private int courseId;
}
