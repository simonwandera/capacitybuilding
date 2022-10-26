package com.capacitybuilding.Service;
import java.util.Map;

public class Entity {
    private String tableName;
    private Map<String, Object> entitiesMap;

    public Map<String, Object> getEntitiesMap() {
        return entitiesMap;
    }

    public String getTableName() {
        return tableName;
    }
    public void setEntitiesMap(Map<String, Object> entitiesMap){
        this.entitiesMap = entitiesMap;
    }

    public Entity( String tableName) {
        this.tableName = tableName;
        this.entitiesMap = entitiesMap;
    }
}
