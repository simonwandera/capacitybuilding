package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;
import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends Entity {

    private int Id;
    private String username;
    private String password;
    private String userType;

    static ResultSet resultSet;
    private static final String tableName = "Login";

    private static final Map<String, Object> entitiesMap = new HashMap<>(){{
        put("Id", null);
        put("Username", "");
        put("Password", "");
        put("UserType", "");
    }};;

    public Login() throws SQLException {
        super(entitiesMap, tableName);
    }

    public static IMySQLDB<Login> getLoginDB() throws SQLException {
        return new MySQLDB<>(new Login());
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

    public String getPassword() {
        return password;
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

    public static List<Login> displayAll() throws SQLException {
        List<Login> studentList = new ArrayList<>();
        resultSet = getLoginDB().fetchAll();
        while (resultSet.next()){
            Login login = new Login();
            login.setId(resultSet.getInt("id"));
            login.setUsername(resultSet.getString("username"));
            login.setPassword(resultSet.getString("password"));
            login.setUserType(resultSet.getString("userType"));
            studentList.add(login);
        }
        return studentList;
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