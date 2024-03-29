package com.capacitybuilding.assignTrainer.bean;

import com.capacitybuilding.assignTrainer.model.AssignStatus;
import com.capacitybuilding.assignTrainer.model.AssignTrainer;
import com.capacitybuilding.enrollment.bean.EnrollmentBean;
import com.capacitybuilding.enrollment.bean.EnrollmentBeanI;
import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.mail.bean.MailBeanI;
import com.capacitybuilding.mail.model.MailWrapper;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
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

    @EJB
    private MailBeanI mailBean;


    public AssignTrainer assign(AssignTrainer assignTrainer) throws Exception {
        if (StringUtils.isBlank(assignTrainer.getTrainer().getId().toString()))
            throw new Exception("The trainer you tried assigning is not recognized");
        if (StringUtils.isBlank(assignTrainer.getTraining().getId().toString()))
            throw new Exception("The training you entered for assignment is invalid");
        assignTrainer.setStatus(AssignStatus.APPROVED);

        MailWrapper mail = new MailWrapper();
        mail.setTo(assignTrainer.getTrainer().getUsername());
        mail.setSubject("Capacity building | Training assignment");
        mail.setMessage("Hello " + assignTrainer.getTrainer().getFirstName() + ", \n" +
                "You have been assigned " + assignTrainer.getTraining().getTitle() + " as trainer." +
                " The training starts on " + assignTrainer.getTraining().getStartDate() + ". \n" +
                "Thank you");
        mailBean.sendMail(mail);

        return entityManager.merge(assignTrainer);

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() {

        List<AssignTrainer> trainers = entityManager.createQuery("FROM AssignTrainer a  ", AssignTrainer.class)
                .getResultList();

        return trainers;

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

        List<Training> trainings = new ArrayList<>();

        entityManager.createQuery("FROM AssignTrainer a WHERE a.trainer.id=:trainerId", AssignTrainer.class)
                .setParameter("trainerId", trainer.getId())
                .getResultList()
                .forEach((assignTrainer) -> trainings.add(assignTrainer.getTraining()));
        return trainings;
    }



}
