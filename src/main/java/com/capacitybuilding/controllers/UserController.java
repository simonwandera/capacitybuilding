package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
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
import java.util.List;
import java.util.Map;

public class UserController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    HelperController helperController;

    @Inject
    AssignTrainerController assignTrainerController;

    @Inject
    EnrollmentController enrollmentController;

    @Inject
    IMySQLDB<User> userIMySQLDB;



    public void add(User user){
        if(user == null || StringUtils.isBlank(user.getLastName()) || StringUtils.isBlank(user.getFirstName()) || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getGender()) )
            return;

        userIMySQLDB.save();
    }

    public void update(User user) {


    }

    public void delete(User user) {

    }

    public User login(Map<String, String> criteria) throws SQLException {

        User login = new User();
        userIMySQLDB.setEntity(login);

        try {
            String queryStatement = userIMySQLDB.createSelectWithWhereClauseQuery(criteria);
            ResultSet resultSet = userIMySQLDB.executeReadQuery(queryStatement);

            while (resultSet.next()){
                login = helperController.getUser(resultSet.getInt("id"));
            }

    }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return login;
    }

    public List<User> list() throws SQLException {
        ResultSet resultSet = userIMySQLDB.fetchAll();
        return this.generateList(resultSet);
    }

    public List<User> generateList(ResultSet resultSet) throws SQLException {

        List<User> userList = new ArrayList<>();
        while (resultSet.next()){
            User user = helperController.getUser(resultSet.getInt("id"));
            user.setEnrolledTrainings(enrollmentController.getTrainings(user));
            user.setAssignedTrainings(assignTrainerController.getTrainings(user));

            userList.add(user);
        }
        return userList;
    }
}
