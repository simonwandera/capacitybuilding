package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.AssignTrainer;
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

public class AssignTrainerController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    TrainingController trainingController;

    @Inject
    UserController userController;

    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list(AssignTrainer assignTrainer) throws SQLException {

        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(assignTrainer, dataSource.getConnection());
        ResultSet resultSet = assignTrainerConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet);
    }
    public List<AssignTrainer> generateList(ResultSet resultSet) throws SQLException {

        List<AssignTrainer> assignTrainerList = new ArrayList<>();

        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();

            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.setStatus(resultSet.getString("status"));
            assignTrainer.setDateAssigned(resultSet.getDate("DateAssigned").toLocalDate());

            assignTrainer.setTrainer(new UserController().getUser(resultSet.getInt("trainerId")));
            assignTrainer.setTraining(new  TrainingController().getTraining(resultSet.getInt("trainingId ")));

            assignTrainerList.add(assignTrainer);
        }

        return assignTrainerList;
    }

    public List<User> getTrainers(Training training) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("trainingId", Integer.toString(training.getId()));
        }};;
        List<User> trainers = new ArrayList<>();

        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(new AssignTrainer(), dataSource.getConnection());
        ResultSet resultSet = assignTrainerConnectionIMySQLDB.executeReadQuery(assignTrainerConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainer = new UserController().getUser(resultSet.getInt("trainerId"));
            trainers.add(trainer);
        }

        return trainers;
    }

}
