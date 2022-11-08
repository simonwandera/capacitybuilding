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
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("enrollmentBean")
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
    public void update(Enrollment enrollment) throws Exception{

        if (enrollment == null || enrollment.getId() == null)
            throw new Exception("Invalid enrollment details");
        entityManager.merge(enrollment);



    }
    public void delete(Enrollment enrollment) throws Exception{
        if (enrollment == null)
            throw new Exception("Invalid enrollment details");

        entityManager.remove(entityManager.find(Enrollment.class, enrollment.getId()));

    }

    public List<Enrollment> getTrainees(Training training) {

        List<Enrollment> traineesEnrolled = entityManager.createQuery("FROM Enrollment e WHERE e.training.id=:id", Enrollment.class)
                .setParameter("id", training.getId())
                .getResultList();

        return traineesEnrolled;
    }

    public List<Enrollment> getTrainings(User trainee){

        List <Enrollment> trainingsEnrolled = entityManager.createQuery("FROM Enrollment e WHERE  e.trainee.id=:traineeId", Enrollment.class)
                .setParameter("traineeId", trainee.getId())
                .getResultList();
        return trainingsEnrolled;
    }


}
