package com.capacitybuilding.controllers;

import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import java.sql.ResultSet;
import java.util.List;

public interface AssignTrainerBeanI {
    void add(AssignTrainer assignTrainer);
    void update(AssignTrainer assignTrainer);
    void delete(AssignTrainer assignTrainer);
    List<AssignTrainer> list();
    List<AssignTrainer> generateList(ResultSet resultSet);
    List<User> getTrainers(Training training);
    List<Training> getTrainings(User trainer);
}
