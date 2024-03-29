package com.capacitybuilding.assessment.bean;

import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.assignTrainer.bean.AssignTrainerBeanI;
import com.capacitybuilding.mail.bean.MailBeanI;
import com.capacitybuilding.mail.model.MailWrapper;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless
@Remote
@Named("assessmentBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AssessmentBean implements AssessmentBeanI{

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    private AssignTrainerBeanI assignTrainerBean;

    @EJB
    private MailBeanI mailBean;

    public Assessment add(Assessment assessment) throws Exception {
        if(StringUtils.isBlank(assessment.getRemarks()))
            throw new Exception("Remarks cannot be null");
        if(assessment.getScore() < 1)
            throw new Exception("Invalid score");
        if(assessment.getEnrollment().getId() == null)
            throw new Exception("Invalid enrollment");

        MailWrapper mail = new MailWrapper();
        mail.setTo(assessment.getEnrollment().getTrainee().getUsername());
        mail.setSubject("Capacity Building | Assessment updates");
        mail.setMessage("New assessment results for " + assessment.getEnrollment().getTraining().getTitle()
        + " have been released. Please login to check your score. \n Thank you.");
        mailBean.sendMail(mail);

        return entityManager.merge(assessment);

    }

    public void update(Assessment assessment) {

    }

    public void delete(Assessment assessment) {

    }

    public User getAssessment(Long id) {
        return null;
    }

    public List<Assessment> list() {
        return entityManager.createNamedQuery(Assessment.FIND_ALL, Assessment.class)
                .getResultList();
    }

    public List<Assessment> listByTrainings(Training training) {
        return entityManager.createQuery("FROM Assessment a WHERE a.enrollment.training.id=:id", Assessment.class)
                .setParameter("id", training.getId())
                .getResultList();
    }

    public List<Assessment> getAssessments(User trainee) {
        List<Assessment> assessmentList = entityManager.createQuery("FROM Assessment a WHERE a.enrollment.trainee.id=:traineeId ORDER BY a.enrollment.training.id", Assessment.class)
                .setParameter("traineeId", trainee.getId())
                .getResultList();
        return assessmentList;
    }

    public List<Assessment> getAvgAssessmentsByUser(Training training) {
        List<Assessment> assessmentList = entityManager.createQuery("SELECT new Assessment(a.enrollment, AVG(a.score)) FROM Assessment a WHERE a.enrollment.training.id=:trainingId GROUP BY a.enrollment.trainee.id", Assessment.class)
                .setParameter("trainingId", training.getId())
                .getResultList();
        return assessmentList;
    }

    public List<Assessment> getAvgAssessmentsByTraining(Training training) {
        List<Assessment> assessmentList = entityManager.createQuery("SELECT new Assessment(a.enrollment, AVG(a.score)) FROM Assessment a WHERE a.enrollment.training.id=:trainingId GROUP BY a.enrollment.training.id", Assessment.class)
                .setParameter("trainingId", training.getId())
                .getResultList();
        return assessmentList;
    }


    public List<Assessment> getAvgAssessmentsByTraining() {
        List<Assessment> assessmentList = entityManager.createQuery("SELECT new Assessment(a.enrollment, AVG(a.score)) FROM Assessment a GROUP BY a.enrollment.training.id", Assessment.class)
                .getResultList();
        return assessmentList;
    }

    public List<Assessment> getAvgAssessmentsByUser() {
        List<Assessment> assessmentList = entityManager.createQuery("SELECT new Assessment(a.enrollment, AVG(a.score)) FROM Assessment a GROUP BY a.enrollment.trainee.id", Assessment.class)
                .getResultList();
        return assessmentList;
    }

    public List<Assessment> trainerAvgAssessmentsByTraining(User trainer) {

        List<Assessment> trainerAssessment = new ArrayList<>();
        for (Training training : assignTrainerBean.getTrainings(trainer)){
            List<Assessment> assessments = this.getAvgAssessmentsByTraining(training);
            trainerAssessment.addAll(assessments);
        }
        return trainerAssessment;
    }

    public List<Assessment> trainerAvgAssessmentsByUser(User trainer) {

        List<Assessment> trainerAssessment = new ArrayList<>();
        for (Training training : assignTrainerBean.getTrainings(trainer)){
            List<Assessment> assessments = this.getAvgAssessmentsByUser(training);
            trainerAssessment.addAll(assessments);
        }
        return  trainerAssessment;
    }

    public  List<Assessment> trainerGetAssessments(User trainer){

        List<Assessment> trainerAssessment = new ArrayList<>();
        for (Training training : assignTrainerBean.getTrainings(trainer)){
            List<Assessment> assessments = this.listByTrainings(training);
            trainerAssessment.addAll(assessments);
        }
        return trainerAssessment;
    }

}
