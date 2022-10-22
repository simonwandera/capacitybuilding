package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingController implements Serializable {


    public List<Training> generateList(Connection connection, Training tr) throws SQLException {
        IMySQLDB<Training, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(tr, connection);
        IMySQLDB<User, Connection> userConnectionIMySQLDB = new MySQLDB<>(new User(), connection);

        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();

        List<Training> trainingList = new ArrayList<>();
        while (resultSet.next()){
            Training training = new Training();

            training.setId(resultSet.getInt("id"));
            training.setTitle(resultSet.getString("title"));
            training.setDescription(resultSet.getString("description"));
            training.setDuration(resultSet.getInt("duration"));
            training.setDateAdded(resultSet.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet.getDate("startDate").toLocalDate());

            UserController userController = new UserController();
            Map<String, String> criteria = new HashMap<>(){{
                put("Id", String.valueOf(training.getId()));
            }};;

            String query = userConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria);
            List<User> Trainees = userController.generateList(userConnectionIMySQLDB.executeReadQuery(query));

            trainingList.add(training);
        }
        return trainingList;
    }
}
