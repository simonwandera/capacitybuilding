package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
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
@Named("trainingController")
public class TrainingBean implements TrainingBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public Training add(Training training) throws Exception {

        if (StringUtils.isBlank(training.getTitle()))
            throw new Exception("Title is required");
        if(StringUtils.isBlank(training.getDescription()))
            throw new Exception("Description is required");
        if(StringUtils.isBlank(training.getStatus()))
            throw new Exception("Status is required");
        if (StringUtils.isBlank(Integer.toString(training.getDuration())))
            throw new Exception("Gender is required");
        if (StringUtils.isBlank(training.getStartDate().toString()))
            throw new Exception("Gender is required");

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

    public Training getTraining(int id) {
        Training training = entityManager.createQuery("FROM Training t WHERE t.id=:id", Training.class)
                .setParameter("id", id)
                .getResultList().get(0);
        return training;
    }

    public List<Training> generateList() {

      return new ArrayList<>();
    }

}