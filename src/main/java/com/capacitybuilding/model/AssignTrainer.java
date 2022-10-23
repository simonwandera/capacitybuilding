package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignTrainer extends Entity {
    private int Id;
    private int TrainingId;
    private int TrainerId;
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
        Id = id;
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getTrainerId() {
        return TrainerId;
    }

    public void setTrainerId(int trainerId) {
        TrainerId = trainerId;
    }

    public LocalDate getDateAssigned() {
        return DateAssigned;
    }

    public void setDateAssigned(LocalDate dateAssigned) {
        DateAssigned = dateAssigned;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
