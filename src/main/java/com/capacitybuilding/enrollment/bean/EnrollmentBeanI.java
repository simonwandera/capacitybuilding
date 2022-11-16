package com.capacitybuilding.enrollment.bean;

import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;

import java.util.List;

public interface EnrollmentBeanI {
    Enrollment enroll(Enrollment enrollment) throws Exception;
    void update(Enrollment enrollment) throws Exception;
    void delete(Enrollment enrollment) throws Exception;

    Enrollment approveEnrollment(Enrollment enrollment) throws Exception;
    List<Enrollment> getTrainees(Training training);
    List<Training> getTrainings(User trainee);
    List<Training> getCompletedTrainings(User trainee);
    List<Enrollment> getEnrollmentsByTrainees();
    List<Enrollment> getEnrollmentsByTrainings();
    List<Enrollment> getEnrollments();
    Boolean isEnrolled(Training training, User trainee);

    List<Enrollment> getTesting();


}
