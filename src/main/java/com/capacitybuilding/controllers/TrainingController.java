package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingController implements Serializable {

    public void add(Training training, Connection connection) throws SQLException {

        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(training, connection);
        trainingConnectionMySQLDB.save();
    }
    public void update(Training training, Connection connection) throws SQLException {

        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(training, connection);
        trainingConnectionMySQLDB.update();

    }
    public void delete(TrainingController trainingController){

    }

    public List<Training> list(Connection connection) throws SQLException {
        IMySQLDB<Training, Connection> trainingConnectionIMySQLDB = new MySQLDB<>(new Training(), connection);
        ResultSet resultSet = trainingConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet, connection);
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

            training.setTrainers(new AssignTrainerController().getTrainers(training, connection));
            trainingList.add(training);
        }
        return trainingList;
    }

    public Training getTraining(int id, Connection connection) throws SQLException {
        Training training = new Training();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;
        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(new Training(), connection);

        ResultSet resultSet = trainingConnectionMySQLDB.executeReadQuery(new MySQLDB<>(new Training(), connection).createSelectWithWhereClauseQuery(criteria));
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
