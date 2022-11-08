package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Enrollment;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import java.util.List;

public interface EnrollmentBeanI {
    Enrollment enroll(Enrollment enrollment) throws Exception;
    void update(EnrollmentBean enrollmentController);
    void delete(EnrollmentBean enrollmentController);
    List<Enrollment> getTrainees(Training training);
    List<Training> getTrainings(User user);
    Boolean isEnrolled(Training training, User trainee);
}
