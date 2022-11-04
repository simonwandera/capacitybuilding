package com.capacitybuilding.controllers;


import com.capacitybuilding.model.Enrollment;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Remote
@Named("enrollmentController")
public class EnrollmentBean implements Serializable {

    @EJB
    HelperBean helperController;

    public void enroll(User trainee, Training training) throws SQLException {
        Enrollment enrollment = new Enrollment();
        enrollment.setStatus("PENDING");
        enrollment.setDateEnrolled(LocalDate.now());
        enrollment.setTrainee(trainee);
        enrollment.setTraining(training);
    }
    public void update(EnrollmentBean enrollmentController){

    }
    public void delete(EnrollmentBean enrollmentController){

    }

    public List<User> getTrainees(Training training) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("TrainingId", Integer.toString(training.getId()));
        }};;
        List<User> traineesEnrolled = new ArrayList<>();


        return traineesEnrolled;
    }

    public List<Training> getTrainings(User user) throws SQLException{
        Map<String, String> criteria = new HashMap<>(){{
            put("TraineeId", Integer.toString(user.getId()));
        }};;
        List<Training> trainingList = new ArrayList<>();

        return trainingList;
    }

}
