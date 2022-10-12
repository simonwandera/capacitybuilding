package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainee extends Entity implements Serializable {
    static int maxId = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    static ResultSet resultSet;

    private static final String tableName = "Trainee";

    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("FirstName", "");
        put("LastName", "");
        put("Gender", "");
        put("Email", "");
    }};;


    public Trainee() {
        super(entitiesMap, tableName);
    }

    public static Map<String, Object> getEntities() {
        return entitiesMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        entitiesMap.put("Id", id);
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        entitiesMap.put("FirstName", firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        entitiesMap.put("LastName", lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        entitiesMap.put("Email", email);
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        entitiesMap.put("Gender", gender);
        this.gender = gender;
    }

    public List<Trainee> generateList(ResultSet resultSet) throws SQLException {
        List<Trainee> traineeList = new ArrayList<>();
        while (resultSet.next()){
            Trainee trainee = new Trainee();
            trainee.setId(resultSet.getInt("id"));
            trainee.setGender(resultSet.getString("gender"));
            trainee.setEmail(resultSet.getString("email"));
            trainee.setFirstName(resultSet.getString("firstName"));
            trainee.setLastName(resultSet.getString("lastName"));
            traineeList.add(trainee);
        }
        return traineeList;
    }

    public List<Trainee> display() throws SQLException {
        resultSet = this.getAll();
        return generateList(resultSet);
    }
}
