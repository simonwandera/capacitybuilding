package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Training extends Entity {
    private int Id;
    private String title;
    private String description;
    private int duration;
    private LocalDate startDate;
    private LocalDate dateAdded;
    private List<User> trainees;
    private List<User> trainers;
    private static final String tableName = "Training";

    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("Title", "");
        put("Description", "");
        put("Duration", null);
        put("StartDate", null);
        put("DateAdded", null);
    }};;

    public Training() {
        super(entitiesMap, tableName);
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

    public List<User> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<User> trainees) {
        this.trainees = trainees;
    }

    public List<User> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<User> trainers) {
        this.trainers = trainers;
    }

}

