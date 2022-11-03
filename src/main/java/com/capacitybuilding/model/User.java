package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User extends Entity {

    private int Id;

    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    private String userType = "USER";
    private List<Training> enrolledTrainings;
    private List<Training> assignedTrainings;
    private static final String tableName = "User";

    private final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("Username", "");
        put("Password", "");
        put("FirstName", "");
        put("LastName", "");
        put("Gender", "");
        put("UserType", "");
    }};;


    public User(){
        super(tableName);
        super.setEntitiesMap(entitiesMap);
    }

    public Map<String, Object> getEntities() {
        return this.entitiesMap;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        entitiesMap.put("Id", id);
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        entitiesMap.put("Username", username);
        this.username = username;
    }

    public void setPassword(String password) {
        entitiesMap.put("Password", password);
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        entitiesMap.put("UserType", userType);
        this.userType = userType;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        entitiesMap.put("Gender",gender);
        this.gender = gender;
    }

    public List<Training> getEnrolledTrainings() {
        return enrolledTrainings;
    }

    public void setEnrolledTrainings(List<Training> enrolledTrainings) {
        this.enrolledTrainings = enrolledTrainings;
    }

    public List<Training> getAssignedTrainings() {
        return assignedTrainings;
    }

    public void setAssignedTrainings(List<Training> assignedTrainings) {
        this.assignedTrainings = assignedTrainings;
    }
}
