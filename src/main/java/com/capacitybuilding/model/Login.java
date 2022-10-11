package com.capacitybuilding.model;

import com.capacitybuilding.Service.Entity;
import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
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
    public List<Login> generateList(ResultSet resultSet) throws SQLException {
        List<Login> loginList = new ArrayList<>();
        while (resultSet.next()){
            Login login = new Login();
            login.setId(resultSet.getInt("id"));
            login.setUsername(resultSet.getString("username"));
            login.setPassword(resultSet.getString("password"));
            login.setUserType(resultSet.getString("userType"));
            loginList.add(login);
        }
        return loginList;
    }


    public List<Login> display() throws SQLException {

        resultSet = this.getAll();
        return generateList(resultSet);

    }

    public List<Login> login(Map<String, String> criteria) throws SQLException{
        List<Login> loginList = new ArrayList<>();

        String loginQuery = this.getMySqlDB().createSelectWithWhereClauseQuery(criteria);
        ResultSet resultSet1 = this.getMySqlDB().executeReadQuery(loginQuery);
        return generateList(resultSet1);
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
