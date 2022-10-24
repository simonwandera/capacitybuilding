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

        return new ArrayList<>();
    }
}
