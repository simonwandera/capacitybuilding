package com.capacitybuilding.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Course implements Serializable {
    private int Id;
    private String title;
    private String description;
    private String duration;
    private LocalDate startDate;
    private LocalDate dateAdded;
    private List<Login> trainees;
    private List<Login> trainers;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Login> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Login> trainees) {
        this.trainees = trainees;
    }

    public List<Login> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Login> trainers) {
        this.trainers = trainers;
    }
}

