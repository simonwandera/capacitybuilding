package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.TrainingStatus;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("trainingBean")
public class TrainingBean implements TrainingBeanI {
    @PersistenceContext
    EntityManager entityManager;

    public Training add(Training training) throws Exception {

        training.setStatus(TrainingStatus.UPCOMING);

        if (StringUtils.isBlank(training.getTitle()))
            throw new Exception("Title is required");
        if(StringUtils.isBlank(training.getDescription()))
            throw new Exception("Description is required");
        if(StringUtils.isBlank(training.getStatus().toString()))
            throw new Exception("Status is required");
        if (StringUtils.isBlank(Integer.toString(training.getDuration())))
            throw new Exception("Duration is required");
        if (StringUtils.isBlank(training.getStartDate().toString()))
            throw new Exception("Start date is required");
        if (training.getDescription().length() > 250)
            throw new Exception("Description too long");
        return entityManager.merge(training);

    }
    public void update(Training training) {



    }

    public void delete(TrainingBean trainingController){

    }

    public List<Training> getList() {
        List<Training> trainings = entityManager.createQuery("FROM Training a ", Training.class)

                .getResultList();

        return trainings;
    }

    public Training getTraining(Long id) {
        Training training = entityManager.createQuery("FROM Training t WHERE t.id=:id", Training.class)
                .setParameter("id", id)
                .getResultList().get(0);
        return training;
    }

}