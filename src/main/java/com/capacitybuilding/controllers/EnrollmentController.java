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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentController implements Serializable {

    @Inject
    HelperController helperController;

    @Inject
    IMySQLDB<Enrollment> enrollmentIMySQLDB;

    public void enroll(User trainee, Training training) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setStatus("PENDING");
        enrollment.setDateEnrolled(LocalDate.now());
        enrollment.setTrainee(trainee);
        enrollment.setTraining(training);
        enrollmentIMySQLDB.save();
    }
    public void update(EnrollmentController enrollmentController){

    }
    public void delete(EnrollmentController enrollmentController){

    }

    public List<User> getTrainees(Training training) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("TrainingId", Integer.toString(training.getId()));
        }};;
        List<User> traineesEnrolled = new ArrayList<>();

        enrollmentIMySQLDB.setEntity(new Enrollment());
        ResultSet resultSet = enrollmentIMySQLDB.executeReadQuery(enrollmentIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainee = helperController.getUser(resultSet.getInt("traineeId"));
            traineesEnrolled.add(trainee);
        }
        return traineesEnrolled;
    }

    public List<Training> getTrainings(User user) throws SQLException{
        Map<String, String> criteria = new HashMap<>(){{
            put("TraineeId", Integer.toString(user.getId()));
        }};;
        List<Training> trainingList = new ArrayList<>();
        ResultSet resultSet = enrollmentIMySQLDB.executeReadQuery(enrollmentIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            Training training = helperController.getTraining(resultSet.getInt("trainingId"));
            trainingList.add(training);
        }
        return trainingList;
    }

}
