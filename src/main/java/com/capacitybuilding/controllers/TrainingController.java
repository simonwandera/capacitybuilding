package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;

import javax.annotation.Resource;
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
        IMySQLDB<Training, Connection> trainingConnectionIMySQLDB = new MySQLDB<>(new Training(), dataSource.getConnection());
        ResultSet resultSet = trainingConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet, dataSource.getConnection());
    }
    public List<Training> generateList(ResultSet resultSet, Connection connection) throws SQLException {

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

            training.setTrainers(new AssignTrainerController().getTrainers(training));
            trainingList.add(training);
        }
        return trainingList;
    }

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
}
