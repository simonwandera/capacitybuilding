package com.capacitybuilding.controllers;

import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Remote
@Named("assignTrainerBean")
public class AssignTrainerBean implements AssignTrainerBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() {

        return new ArrayList<>();

    }
    public List<AssignTrainer> generateList(ResultSet resultSet) {

        return new ArrayList<>();
    }

    public List<AssignTrainer> getTrainers(Training training) {

        List<AssignTrainer> trainers = entityManager.createQuery("FROM AssigTrainer a WHERE a.training=:traningId ", AssignTrainer.class)
                .setParameter("traningId", training.getId())
                .getResultList();

        return trainers;

    }

    public List<Training> getTrainings(User trainer){


        List<Training> trainingList = new ArrayList<>();


        return new ArrayList<>();
    }

}
