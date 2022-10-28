package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class HelperController {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    public Training getTraining(int id) throws SQLException {
        Training training = new Training();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;
        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(new Training(), dataSource.getConnection());

        ResultSet resultSet = trainingConnectionMySQLDB.executeReadQuery(new MySQLDB<>(new Training(), dataSource.getConnection()).createSelectWithWhereClauseQuery(criteria));
        while (resultSet.next()){
            training.setId(resultSet.getInt("id"));
            training.setTitle(resultSet.getString("title"));
            training.setDescription(resultSet.getString("description"));
            training.setDuration(resultSet.getInt("duration"));
            training.setDateAdded(resultSet.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet.getDate("startDate").toLocalDate());
            training.setStatus(resultSet.getString("status"));
        }
        return training;
    }


    public User getUser(int id) throws SQLException {
        User user = new User();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;
        IMySQLDB<User, Connection> userConnectionIMySQLDB = new MySQLDB<>(new User(), dataSource.getConnection());
        ResultSet resultSet = userConnectionIMySQLDB.executeReadQuery(new MySQLDB<>(new User(), dataSource.getConnection()).createSelectWithWhereClauseQuery(criteria));
        while (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("firstname"));
            user.setLastName(resultSet.getString("lastname"));
            user.setGender(resultSet.getString("gender"));
            user.setUsername(resultSet.getString("username"));
            user.setUserType(resultSet.getString("userType"));
        }
        return user;
    }
}
