package com.capacitybuilding.controllers;


import com.capacitybuilding.model.Enrollment;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Remote
@Named("enrollmentController")
public class EnrollmentBean implements EnrollmentBeanI {

    public void enroll(User trainee, Training training) {
        Enrollment enrollment = new Enrollment();

    }
    public void update(EnrollmentBean enrollmentController){

    }
    public void delete(EnrollmentBean enrollmentController){

    }

    public List<User> getTrainees(Training training) {

        List<User> traineesEnrolled = new ArrayList<>();


        return traineesEnrolled;
    }

    public List<Training> getTrainings(User user){

        List<Training> trainingList = new ArrayList<>();

        return trainingList;
    }

}
