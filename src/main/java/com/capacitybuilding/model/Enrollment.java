package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class Enrollment extends Entity {
    private int Id;
    private LocalDate dateEnrolled;
    private String status;
    private User trainee;
    private Training training;
    private static final String tableName = "Enrollment";

    private final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("TrainingId", null);
        put("TraineeId ", null);
        put("DateEnrolled", null);
        put("Status ", "");
    }};;

    public Enrollment() {
        super(tableName);
        super.setEntitiesMap(entitiesMap);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        entitiesMap.put("Id", id);
        Id = id;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        entitiesMap.put("DateEnrolled", dateEnrolled);
        this.dateEnrolled = dateEnrolled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        entitiesMap.put("Status", status);
        this.status = status;
    }

    public User getTrainee() {
        return trainee;
    }

    public void setTrainee(User trainee) {
        entitiesMap.put("TraineeId", trainee.getId());
        this.trainee = trainee;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        entitiesMap.put("TrainingId", training.getId());
        this.training = training;
    }
}
