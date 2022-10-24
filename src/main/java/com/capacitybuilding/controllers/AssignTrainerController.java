package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignTrainerController implements Serializable {
    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list(AssignTrainer assignTrainer, Connection connection) throws SQLException {

        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(assignTrainer, connection);
        ResultSet resultSet = assignTrainerConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet, connection);
    }
    public List<AssignTrainer> generateList(ResultSet resultSet, Connection connection) throws SQLException {

        List<AssignTrainer> assignTrainerList = new ArrayList<>();

        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();

            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.setStatus(resultSet.getString("status"));
            assignTrainer.setDateAssigned(resultSet.getDate("DateAssigned").toLocalDate());

            assignTrainer.setTrainer(new UserController().getUser(resultSet.getInt("trainerId"), connection));
            assignTrainer.setTraining(new  TrainingController().getTraining(resultSet.getInt("trainingId "), connection));

            assignTrainerList.add(assignTrainer);
        }

        return assignTrainerList;
    }

    public List<User> getTrainers(Training training, Connection connection) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("trainingId", Integer.toString(training.getId()));
        }};;
        List<User> trainers = new ArrayList<>();

        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(new AssignTrainer(), connection);
        ResultSet resultSet = assignTrainerConnectionIMySQLDB.executeReadQuery(assignTrainerConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainer = new UserController().getUser(resultSet.getInt("trainerId"), connection);
            trainers.add(trainer);
        }

        return trainers;
    }

}
