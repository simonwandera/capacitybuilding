package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AssignTrainer extends Entity {
    private int Id;
    Training training;
    User trainer;
    private LocalDate DateAssigned;
    private String Status;


    private static final String tableName = "AssignTrainer";
    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("TrainingId", null);
        put("TrainerId", null);
        put("DateAssigned", null);
        put("Status", "");
    }};;
    public AssignTrainer() {
        super(entitiesMap, tableName);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        entitiesMap.put("Id", id);
        Id = id;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        entitiesMap.put("TrainingId", training.getId());
        this.training = training;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        entitiesMap.put("TrainerId", trainer.getId());
        this.trainer = trainer;
    }

    public LocalDate getDateAssigned() {
        return DateAssigned;
    }

    public void setDateAssigned(LocalDate dateAssigned) {
        entitiesMap.put("DateAssigned", dateAssigned);
        DateAssigned = dateAssigned;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        entitiesMap.put("Status", status);
        Status = status;
    }
}
