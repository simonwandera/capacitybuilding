package com.capacitybuilding.enrollment.bean;


import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.TrainingStatus;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("enrollmentBean")
public class EnrollmentBean implements EnrollmentBeanI {

    @PersistenceContext
    private EntityManager entityManager;

    public Enrollment enroll(Enrollment enrollment) throws Exception {

        if(this.isEnrolled(enrollment.getTraining(), enrollment.getTrainee()))
            throw new Exception("Enrollment exists");

        if (StringUtils.isBlank(enrollment.getTrainee().getId().toString()))
            throw new Exception("Invalid User to enroll");
        if (StringUtils.isBlank(enrollment.getTraining().getId().toString()))
            throw new Exception("Invalid training");

        return entityManager.merge(enrollment);

    }

    public void update(Enrollment enrollment) throws Exception {
        if (enrollment == null || enrollment.getId() == null)
            throw new Exception("Invalid enrollment details");
        entityManager.merge(enrollment);
    }

    public void delete(Enrollment enrollment) throws Exception {
        if (enrollment == null)
            throw new Exception("Invalid enrollment details");
        entityManager.remove(entityManager.find(Enrollment.class, enrollment.getId()));
    }

    public Enrollment approveEnrollment(Enrollment enrollment) throws Exception{
        if(StringUtils.isBlank(enrollment.getId().toString()))
            throw new Exception("Invalid enrollment");
        if(StringUtils.isBlank(enrollment.getStatus().toString()))
            throw new Exception("Invalid enrollment status");

        Enrollment newEnrollment = entityManager.find(Enrollment.class, enrollment.getId());
        newEnrollment.setStatus(enrollment.getStatus());
        return entityManager.merge(newEnrollment);

    }
    public List<Enrollment> getEnrollments() {

        List<Enrollment> enrollments = entityManager.createQuery("SELECT e FROM Enrollment e ", Enrollment.class)
                .getResultList();
        return enrollments;
    }


    public List<Enrollment> getEnrollmentsByTrainings() {
        List<Enrollment> enrollments = entityManager.createQuery("SELECT new Enrollment(e.training, count(e.training)) FROM Enrollment e group by e.training", Enrollment.class)
                .getResultList();
        return enrollments;
    }

    public List<Enrollment> getEnrollmentsByTrainees() {
        List<Enrollment> enrollments = entityManager.createQuery("SELECT new Enrollment(e.trainee, count(e.trainee)) FROM Enrollment e group by e.trainee", Enrollment.class)
                .getResultList();
        return enrollments;
    }

    public List<Enrollment> getTesting() {

        List<Enrollment> enrollments = entityManager.createQuery("SELECT new Enrollment(count(e.status), e.status, e.trainee) FROM Enrollment e group by e.trainee", Enrollment.class)
                .getResultList();
        return enrollments;
    }

    public List<Enrollment> getTrainees(Training training) {

        List<Enrollment> traineesEnrolled = entityManager.createQuery("FROM Enrollment e WHERE e.training.id=:id", Enrollment.class)
                .setParameter("id", training.getId())
                .getResultList();
        return traineesEnrolled;
    }

    public List<Training> getTrainings(User trainee) {

        List<Training> training = new ArrayList<>();

        TypedQuery<Enrollment> query = entityManager.createQuery("SELECT e FROM Enrollment e INNER JOIN e.trainee WHERE e.trainee.id=:traineeId", Enrollment.class)
                .setParameter("traineeId", trainee.getId());
        List<Enrollment> resultList = query.getResultList();
        resultList.forEach((enrollment) -> training.add(enrollment.getTraining()));
        return training;
    }

    public List<Training> getCompletedTrainings(User trainee) {

        List<Training> training = new ArrayList<>();
        entityManager.createQuery("FROM Enrollment e WHERE  e.trainee.id=:traineeId AND e.training.status=:status", Enrollment.class)
                .setParameter("traineeId", trainee.getId())
                .setParameter("status", TrainingStatus.COMPLETED)
                .getResultList()
                .forEach((enrollment) -> training.add(enrollment.getTraining())
                );

        return training;
    }

    public Boolean isEnrolled(Training training, User trainee) {
        List<Enrollment> enrollmentList = entityManager.createQuery("FROM Enrollment e WHERE e.training.id=:trainingId AND e.trainee.id=:traineeId", Enrollment.class)
                .setParameter("trainingId", training.getId())
                .setParameter("traineeId", trainee.getId())
                .getResultList();
        return enrollmentList.size() > 0;
    }

}
