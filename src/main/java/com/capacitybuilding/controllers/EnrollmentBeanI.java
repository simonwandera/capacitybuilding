package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import java.util.List;

public interface EnrollmentBeanI {
    void enroll(User trainee, Training training);
    void update(EnrollmentBean enrollmentController);
    void delete(EnrollmentBean enrollmentController);
    List<User> getTrainees(Training training);
    List<Training> getTrainings(User user);
}
