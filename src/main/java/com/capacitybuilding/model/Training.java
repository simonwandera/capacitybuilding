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
    private String status;
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
        put("Status", "");
    }};;

    @Override
    protected void finalize()
    {
        Map<String, Object> entitiesMap = new HashMap<>(){{
            put("Id", null);
            put("Title", "");
            put("Description", "");
            put("Duration", null);
            put("StartDate", null);
            put("DateAdded", null);
            put("Status", "");
        }};;
    }

    public Training() {
        super(entitiesMap, tableName);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        entitiesMap.put("Id", id);
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        entitiesMap.put("Title", title);
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        entitiesMap.put("Description", description);
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        entitiesMap.put("Duration", duration);
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        entitiesMap.put("StartDate", startDate);
        this.startDate = startDate;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        entitiesMap.put("DateAdded", dateAdded);
        this.dateAdded = dateAdded;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        entitiesMap.put("Status",status);
        this.status = status;
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

