package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.util.HashMap;
import java.util.Map;

public class AssignTrainer extends Entity {

    private static final String tableName = "Training";

    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("Title", "");
        put("Description", "");
        put("Duration", null);
        put("StartDate", null);
        put("DateAdded", null);
    }};;
    public AssignTrainer() {
        super(entitiesMap, tableName);
    }
}
