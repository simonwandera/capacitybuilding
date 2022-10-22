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

public class LoginController implements Serializable {
    public void add(Connection connection, User login){
        if(login == null || StringUtils.isBlank(login.getLastName()) || StringUtils.isBlank(login.getFirstName()) || StringUtils.isBlank(login.getUsername()) || StringUtils.isBlank(login.getGender()) )
            return;

        try {
            IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(login, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(User login) {


    }

    public void delete(User login) {

    }

    public List<User> list(Connection connection, User login) throws SQLException {

        IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(login, connection);
        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();

        String deleteQuery = traineeConnectionIMySQLDB.createDeleteQuery();

        System.out.println("\n\n Delete Query\n\n");

        System.out.println(deleteQuery);


        return login.generateList(resultSet);
    }
}
