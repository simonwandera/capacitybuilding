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

public class TrainingController implements Serializable {

    public void add(TrainingController trainingController){

    }
    public void update(TrainingController trainingController){

    }
    public void delete(TrainingController trainingController){

    }
    public List<Training> list(Connection connection, Training tr) throws SQLException {
        IMySQLDB<Training, Connection> trainingConnectionIMySQLDB = new MySQLDB<>(tr, connection);

        IMySQLDB<User, Connection> userConnectionIMySQLDB = new MySQLDB<>(new User(), connection);
        IMySQLDB<AssignTrainer, Connection> assignTrainerConnectionIMySQLDB = new MySQLDB<>(new AssignTrainer(), connection);

        ResultSet resultSet = trainingConnectionIMySQLDB.fetchAll();

        List<Training> trainingList = new ArrayList<>();
        while (resultSet.next()){
            Training training = new Training();

            AssignTrainerController assignTrainerController = new AssignTrainerController();
            UserController userController = new UserController();

            training.setId(resultSet.getInt("id"));
            training.setTitle(resultSet.getString("title"));
            training.setDescription(resultSet.getString("description"));
            training.setDuration(resultSet.getInt("duration"));
            training.setDateAdded(resultSet.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet.getDate("startDate").toLocalDate());

            Map<String, String> criteria = new HashMap<>(){{
                put("TrainingId", String.valueOf(training.getId()));
            }};;

            String query = assignTrainerConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria);

            ResultSet resultSet1 = assignTrainerConnectionIMySQLDB.executeReadQuery(query);
            List<AssignTrainer> assignTrainers = assignTrainerController.list(resultSet1);

            trainingList.add(training);
        }
        return trainingList;
    }
}
