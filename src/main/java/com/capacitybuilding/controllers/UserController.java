package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

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

public class UserController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    HelperController helperController;

    public void add(Connection connection, User user){
        if(user == null || StringUtils.isBlank(user.getLastName()) || StringUtils.isBlank(user.getFirstName()) || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getGender()) )
            return;

        try {
            IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(user, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {


    }

    public void delete(User user) {

    }

    public User login(Map<String, String> criteria) {
        User login = new User();
        try {

            IMySQLDB<User, Connection> loginMysqlDb = new MySQLDB<>(login, dataSource.getConnection());
            String queryStatement = loginMysqlDb.createSelectWithWhereClauseQuery(criteria);
            ResultSet resultSet = loginMysqlDb.executeReadQuery(queryStatement);

            while (resultSet.next()) {
                login = new User();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("userName"));
                login.setUserType(resultSet.getString("userType"));
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return login;
    }

    public List<User> list(User user, Connection connection) throws SQLException {

        IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(user, connection);
        ResultSet resultSet = traineeConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet);
    }

    public List<User> generateList(ResultSet resultSet) throws SQLException {

        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));

            user.setFirstName(resultSet.getString("firstname"));
            user.setLastName(resultSet.getString("lastname"));
            user.setGender(resultSet.getString("gender"));

            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setUserType(resultSet.getString("userType"));
            userList.add(user);
        }
        return userList;
    }


    public List<Training> getEnrolledTrainings(User trainee, Connection connection) throws SQLException {

        IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(new Training(), connection);

        Map<String, String> criteria = new HashMap<>(){{
            put("TraineeId", Integer.toString(trainee.getId()));
        }};;

        List<Training> enrolledTrainings = new ArrayList<>();
        ResultSet resultSet = trainingConnectionMySQLDB.executeReadQuery(trainingConnectionMySQLDB.createSelectWithWhereClauseQuery(criteria));
        while (resultSet.next()){

            Training training = helperController.getTraining(resultSet.getInt("id"));

            enrolledTrainings.add(training);
        }
        return enrolledTrainings;
    }

    public List<Training> getAssignedTrainings(User trainer){

        Map<String, String> criteria = new HashMap<>(){{
            put("TraineeId", Integer.toString(trainer.getId()));
        }};;
        return new ArrayList<>();
    }
}
