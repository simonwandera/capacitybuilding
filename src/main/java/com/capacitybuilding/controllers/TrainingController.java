package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    AssignTrainerController assignTrainerController;

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

    public List<Training> generateList(ResultSet resultSet) throws SQLException {

        List<Training> trainingList = new ArrayList<>();
        while (resultSet.next()){
            Training training = new Training();

            training.setId(resultSet.getInt("id"));
            training.setTitle(resultSet.getString("title"));
            training.setDescription(resultSet.getString("description"));
            training.setDuration(resultSet.getInt("duration"));
            training.setDateAdded(resultSet.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet.getDate("startDate").toLocalDate());
            training.setStatus(resultSet.getString("status"));

            training.setTrainers(assignTrainerController.getTrainers(training));
            trainingList.add(training);
        }
        return trainingList;
    }
}
