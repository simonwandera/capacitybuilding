package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserController implements Serializable {
    public void add(Connection connection, User user){
        if(user == null || StringUtils.isBlank(user.getLastName()) || StringUtils.isBlank(user.getFirstName()) || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getGender()) )
            return;

        try {
            IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(user, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(User user) {


    }

    public void delete(User user) {

    }

    public List<User> list(Connection connection, User user) throws SQLException {

        IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(user, connection);
        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();
        return user.generateList(resultSet);
    }
}
