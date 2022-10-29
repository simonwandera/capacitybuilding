package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    AssignTrainerController assignTrainerController;

    @Inject
    EnrollmentController enrollmentController;

    @Inject
    HelperController helperController;

    public void add(Training training) throws SQLException {

        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(training, dataSource.getConnection());
        trainingConnectionMySQLDB.save();
    }
    public void update(Training training) throws SQLException {

        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(training, dataSource.getConnection());
        trainingConnectionMySQLDB.update();

    }
    public void delete(TrainingController trainingController){

    }

    public List<Training> list() throws SQLException {
        IMySQLDB<Training, Connection> connectionIMySQLDB = new MySQLDB<>(new Training(), dataSource.getConnection());
        ResultSet resultSet = connectionIMySQLDB.fetchAll();
        return this.generateList(resultSet);
    }

    public List<Training> generateList(ResultSet resultSet) throws SQLException {

        List<Training> trainingList = new ArrayList<>();
        while (resultSet.next()){

            Training training = helperController.getTraining(resultSet.getInt("id"));
            training.setAssignedTrainers(assignTrainerController.getTrainers(training));
            training.setEnrolledTrainees(enrollmentController.getTrainees(training));
            trainingList.add(training);
        }
        return trainingList;
    }
}
