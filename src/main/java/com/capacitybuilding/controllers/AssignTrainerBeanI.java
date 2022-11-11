package com.capacitybuilding.controllers;

import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import java.sql.ResultSet;
import java.util.List;

public interface AssignTrainerBeanI {
    AssignTrainer assign(AssignTrainer assignTrainer) throws Exception;
    void update(AssignTrainer assignTrainer);
    void delete(AssignTrainer assignTrainer);
    List<AssignTrainer> list();
    List<AssignTrainer> generateList(ResultSet resultSet);
    List<AssignTrainer> getTrainers(Training training);
    List<Training> getTrainings(User trainer);
}
