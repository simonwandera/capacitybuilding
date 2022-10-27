package com.capacitybuilding.controllers;


import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Enrollment;
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

public class EnrollmentController implements Serializable {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    UserController userController;

    public void add(EnrollmentController enrollmentController){

    }
    public void update(EnrollmentController enrollmentController){

    }
    public void delete(EnrollmentController enrollmentController){

    }

    public List<User> getTrainees(Training training) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("trainingId", Integer.toString(training.getId()));
        }};;
        List<User> traineesEnrolled = new ArrayList<>();

        IMySQLDB<Enrollment, Connection> enrollmentConnectionIMySQLDB = new MySQLDB<>(new Enrollment(), dataSource.getConnection());
        ResultSet resultSet = enrollmentConnectionIMySQLDB.executeReadQuery(enrollmentConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainee = userController.getUser(resultSet.getInt("traineeId"));
            traineesEnrolled.add(trainee);
        }

        return traineesEnrolled;
    }

}
