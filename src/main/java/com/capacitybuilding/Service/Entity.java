package com.capacitybuilding.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Entity {
    private String tableName;
    private Map<String, Object> entitiesMap;

    public Map<String, Object> getEntitiesMap() {
        return entitiesMap;
    }

    public IMySQLDB<Entity> getMySqlDB() throws SQLException {
        return new MySQLDB<>(new Entity(this.entitiesMap, this.tableName));
    }

    public String getTableName() {
        return tableName;
    }

    public Entity(Map<String, Object> entitiesMap, String tableName) {
        this.tableName = tableName;
        this.entitiesMap = entitiesMap;
    }

    public ResultSet getAll() throws SQLException {
        return this.getMySqlDB().fetchAll();
    }

    public ResultSet getOne() throws SQLException {
        return this.getMySqlDB().fetchOne();
    }

}
