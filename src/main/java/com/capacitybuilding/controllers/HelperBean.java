package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
@Remote
public class HelperBean implements HelperBeanI{

    @PersistenceContext
    EntityManager entityManager;

    public Training getTraining(int id) {
        Training training = entityManager.createQuery("FROM Training t WHERE t.id=:id", Training.class)
                .setParameter("id", id)
                .getResultList().get(0);
        return training;
    }


    public User getUser(int id) {
        User user = entityManager.createQuery("FROM User a WHERE a.id=:id" , User.class)
                .setParameter("id", id)
                .getResultList().get(0);

        return user;
    }
}
