package com.capacitybuilding.assignTrainer.bean;

import com.capacitybuilding.assignTrainer.model.AssignStatus;
import com.capacitybuilding.assignTrainer.model.AssignTrainer;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Remote
@Named("assignTrainerBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AssignTrainerBean implements AssignTrainerBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public AssignTrainer assign(AssignTrainer assignTrainer) throws Exception {
        if (StringUtils.isBlank(assignTrainer.getTrainer().getId().toString()))
            throw new Exception("The trainer you tried assigning is not recognized");
        if (StringUtils.isBlank(assignTrainer.getTraining().getId().toString()))
            throw new Exception("The training you entered for assignment is invalid");
        assignTrainer.setStatus(AssignStatus.APPROVED);

        return entityManager.merge(assignTrainer);

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() {

        return new ArrayList<>();

    }

    public List<AssignTrainer> getTrainers(Training training) {

        List<AssignTrainer> trainers = entityManager.createQuery("FROM AssignTrainer a WHERE a.training.id=:traningId ", AssignTrainer.class)
                .setParameter("traningId", training.getId())
                .getResultList();

        return trainers;

    }

    public User getTrainer(Training training) {
        User trainer = new User();
       for(AssignTrainer assignTrainer : this.getTrainers(training)){
           trainer = assignTrainer.getTrainer();
       }
       return trainer;
    }

    public List<Training> getTrainings(User trainer){


        List<Training> trainingList = new ArrayList<>();

        return new ArrayList<>();
    }

}
