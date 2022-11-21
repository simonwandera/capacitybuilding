package com.capacitybuilding.training.bean;

import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.TrainingStatus;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
@Remote
@Named("trainingBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainingBean implements TrainingBeanI {
    @PersistenceContext
    EntityManager entityManager;

    public Training add(Training training) throws Exception {

        if (StringUtils.isBlank(training.getTitle()))
            throw new Exception("Title is required");
        if(StringUtils.isBlank(training.getDescription()))
            throw new Exception("Description is required");
        if(StringUtils.isBlank(training.getStatus().toString()))
            throw new Exception("Status is required");
        if (training.getDuration() == 0)
            throw new Exception("Duration is required");
        if (StringUtils.isBlank(training.getStartDate().toString()))
            throw new Exception("Start date is required");
        if (training.getDescription().length() > 250)
            throw new Exception("Description too long");
        if (StringUtils.isBlank(training.getStatus().toString()))
            throw new Exception("Status is required");
        if (training.getStartDate().isBefore(LocalDate.now()))
            throw new Exception("Start date cannot be before today ");
        return entityManager.merge(training);

    }
    public Training update(Training training) throws Exception {
        if (StringUtils.isBlank(training.getTitle()))
            throw new Exception("Title is required");
        if(StringUtils.isBlank(training.getDescription()))
            throw new Exception("Description is required");
        if (training.getDuration() == 0)
            throw new Exception("Duration is required");
        if (StringUtils.isBlank(training.getStartDate().toString()))
            throw new Exception("Start date is required");
        if (training.getDescription().length() > 250)
            throw new Exception("Description too long");

        Training newTraining = entityManager.find(Training.class, training.getId());
        newTraining.setDuration(training.getDuration());
        newTraining.setDescription(training.getDescription());
        newTraining.setTitle(training.getTitle());
        newTraining.setStartDate(training.getStartDate());

        return entityManager.merge(newTraining);
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

    public List<Assessment> getCompletedTrainings(User trainee) {
        List<Assessment> assessmentList = entityManager.createQuery("SELECT new Assessment(a.enrollment, AVG(a.score)) FROM Assessment a WHERE a.enrollment.trainee.id=:traineeId AND a.enrollment.training.status=:trainingStatus GROUP BY a.enrollment.training.id")
                .setParameter("traineeId", trainee.getId())
                .setParameter("trainingStatus", TrainingStatus.COMPLETED)
                .getResultList();
        return assessmentList;
    }

}