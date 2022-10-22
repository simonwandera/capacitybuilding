package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    static ResultSet resultSet;
    private static final String tableName = "User";

    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("Username", "");
        put("Password", "");
        put("FirstName", "");
        put("LastName", "");
        put("Gender", "");
        put("UserType", "");
    }};;

    public User(){
        super(entitiesMap, tableName);
    }
    public static Map<String, Object> getEntities() {
        return entitiesMap;
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

    public List<User> generateList(ResultSet resultSet) throws SQLException {
        List<User> loginList = new ArrayList<>();
        while (resultSet.next()){
            User login = new User();
            login.setId(resultSet.getInt("id"));

            login.setFirstName(resultSet.getString("firstname"));
            login.setLastName(resultSet.getString("lastname"));
            login.setGender(resultSet.getString("gender"));

            login.setUsername(resultSet.getString("username"));
            login.setPassword(resultSet.getString("password"));
            login.setUserType(resultSet.getString("userType"));
            loginList.add(login);
        }
        return loginList;
    }

    @Override
    public String toString() {
        return "Login{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}