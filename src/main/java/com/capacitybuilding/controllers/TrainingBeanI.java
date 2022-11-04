package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;

import java.util.List;

public interface TrainingBeanI {

    void add(Training training);
    void update(Training training);
    void delete(TrainingBean trainingController);
    List<Training> getList();
    List<Training> generateList();
}
