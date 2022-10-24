package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentController implements Serializable {

    public void add(EnrollmentController enrollmentController){

    }
    public void update(EnrollmentController enrollmentController){

    }
    public void delete(EnrollmentController enrollmentController){

    }
    public List<AssignTrainer> list(ResultSet resultSet) throws SQLException {
        List<AssignTrainer> assignTrainers = new ArrayList<>();
        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();
            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.se
        }
        return assignTrainers;
    }

    public List<User> getTrainer(Training training, Connection connection) throws SQLException {
        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(new AssignTrainer(), connection);
        List<AssignTrainer> assignTrainers = assignTrainerConnectionIMySQLDB.
    }

}
