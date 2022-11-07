package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

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
    public void add(Training training) {

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

    public List<Training> generateList() {

      return new ArrayList<>();
    }

}