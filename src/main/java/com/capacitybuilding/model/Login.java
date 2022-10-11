package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.sql.ResultSet;
import java.util.Map;

public class Login extends Entity {

    private int Id;
    private String UserName;
    private String Password;
    private String UserType;

    static ResultSet resultSet;
    private static final String tableName = "student";

    public Login(Map<String, Object> entitiesMap, String tableName) {
        super(entitiesMap, tableName);
    }
}
