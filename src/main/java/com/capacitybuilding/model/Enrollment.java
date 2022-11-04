package com.capacitybuilding.model;


import java.time.LocalDate;

public class Enrollment extends BaseEntity {
    private LocalDate dateEnrolled;
    private String status;
    private User trainee;
    private Training training;

}
