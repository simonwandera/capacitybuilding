package com.capacitybuilding.training.bean;

import com.capacitybuilding.training.model.Training;

import java.util.List;

public interface TrainingBeanI {

    Training add(Training training) throws Exception;
    Training update(Training training) throws Exception;
    void delete(TrainingBean trainingController);
    List<Training> getList();
    Training getTraining(Long id);
}
