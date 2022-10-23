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
import java.util.List;

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
        return this.generateList(resultSet);
    }
    public List<AssignTrainer> generateList(ResultSet resultSet, Connection connection) throws SQLException {

        IMySQLDB<User, Connection> userConnectionIMySQLDB = new MySQLDB<>(new User(), connection);
        IMySQLDB<Training, Connection> trainingConnectionIMySQLDB = new MySQLDB<>(new Training(), connection);

        List<AssignTrainer> assignTrainerList = new ArrayList<>();

        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();

            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.setStatus(resultSet.getString("status"));
            assignTrainer.setDateAssigned(resultSet.getDate("DateAssigned").toLocalDate());

            List<User> trainers = new UserController().generateList(userConnectionIMySQLDB.fetchAll());
            List<Training> trainings = new TrainingController().generateList(trainingConnectionIMySQLDB.fetchAll());

            for (User trainer : trainers){
                if(trainer.getId() == Integer.parseInt(resultSet.getString("TrainerId"))){
                    assignTrainer.setTrainer(trainer);
                }
            }

            for (Training training : trainings){
                if(training.getId() == Integer.parseInt(resultSet.getString("TrainingId"))){
                    assignTrainer.setTraining(training);
                }
            }

            assignTrainerList.add(assignTrainer);
        }

        return new ArrayList<>();
    }
}
