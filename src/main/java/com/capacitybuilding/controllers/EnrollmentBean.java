package com.capacitybuilding.controllers;


import com.capacitybuilding.model.Enrollment;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("enrollmentController")
public class EnrollmentBean implements EnrollmentBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public Enrollment enroll(Enrollment enrollment) throws Exception {
        if (StringUtils.isBlank(enrollment.getTrainee().getId().toString()))
            throw new Exception("Invalid User to enroll");
        if(StringUtils.isBlank(enrollment.getTraining().getId().toString()))
            throw new Exception("Invalid training");

        return entityManager.merge(enrollment);

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
