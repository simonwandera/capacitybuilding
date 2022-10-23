package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.util.HashMap;
import java.util.Map;

public class AssignTrainer extends Entity {
    private int Id;

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
}
