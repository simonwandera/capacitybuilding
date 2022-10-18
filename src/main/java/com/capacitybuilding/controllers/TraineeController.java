package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Trainee;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TraineeController implements Serializable {

    public void add(Connection connection, Trainee trainee){
        if(trainee == null || StringUtils.isBlank(trainee.getLastName()) || StringUtils.isBlank(trainee.getFirstName()) || StringUtils.isBlank(trainee.getEmail()) || StringUtils.isBlank(trainee.getGender()) )
            return;

        try {
            IMySQLDB<Trainee, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(trainee, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Trainee trainee) {


    }

    public void delete(Trainee trainee) {

    }

    public List<Trainee> list(Connection connection, Trainee trainee) throws SQLException {

        IMySQLDB<Trainee, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(trainee, connection);
        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();

        String deleteQuery = traineeConnectionIMySQLDB.createDeleteQuery();

        System.out.println("\n\n Delete Query\n\n");

        System.out.println(deleteQuery);


        return trainee.generateList(resultSet);
    }

}

