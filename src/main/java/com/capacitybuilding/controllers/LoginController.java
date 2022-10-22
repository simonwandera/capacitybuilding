package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Login;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginController implements Serializable {
    public void add(Connection connection, Login login){
        if(login == null || StringUtils.isBlank(login.getLastName()) || StringUtils.isBlank(login.getFirstName()) || StringUtils.isBlank(login.getUsername()) || StringUtils.isBlank(login.getGender()) )
            return;

        try {
            IMySQLDB<Login, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(login, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Login login) {


    }

    public void delete(Login login) {

    }

    public List<Login> list(Connection connection, Login login) throws SQLException {

        IMySQLDB<Login, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(login, connection);
        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();

        String deleteQuery = traineeConnectionIMySQLDB.createDeleteQuery();

        System.out.println("\n\n Delete Query\n\n");

        System.out.println(deleteQuery);


        return login.generateList(resultSet);
    }
}
