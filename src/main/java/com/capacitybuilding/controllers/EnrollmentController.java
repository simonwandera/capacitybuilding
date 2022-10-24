package com.capacitybuilding.controllers;


import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Enrollment;
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

public class EnrollmentController implements Serializable {

    public void add(EnrollmentController enrollmentController){

    }
    public void update(EnrollmentController enrollmentController){

    }
    public void delete(EnrollmentController enrollmentController){

    }

    public List<User> getTrainees(Training training, Connection connection) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("trainingId", Integer.toString(training.getId()));
        }};;
        List<User> traineesEnrolled = new ArrayList<>();

        IMySQLDB<Enrollment, Connection> enrollmentConnectionIMySQLDB = new MySQLDB<>(new Enrollment(), connection);
        ResultSet resultSet = enrollmentConnectionIMySQLDB.executeReadQuery(enrollmentConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainee = new UserController().getUser(resultSet.getInt("traineeId"), connection);
            traineesEnrolled.add(trainee);
        }

        return traineesEnrolled;
    }

}
