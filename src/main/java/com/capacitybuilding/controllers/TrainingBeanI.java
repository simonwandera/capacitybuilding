package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;

import java.util.List;

public interface TrainingBeanI {

    Training add(Training training) throws Exception;
    void update(Training training);
    void delete(TrainingBean trainingController);
    List<Training> getList();
    List<Training> generateList();

    Training getTraining(int id);
}
