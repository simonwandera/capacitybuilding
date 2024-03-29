package com.capacitybuilding.enrollment.bean;


import com.capacitybuilding.assessment.bean.AssessmentBeanI;
import com.capacitybuilding.assignTrainer.bean.AssignTrainerBeanI;
import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.enrollment.model.EnrollmentStatus;
import com.capacitybuilding.mail.bean.MailBeanI;
import com.capacitybuilding.mail.model.MailWrapper;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.TrainingStatus;
import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("enrollmentBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EnrollmentBean implements EnrollmentBeanI {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private AssignTrainerBeanI assignTrainerBean;

    @EJB
    private MailBeanI mailBean;

    @EJB
    private UserBeanI userBean;

    public Enrollment enroll(Enrollment enrollment) throws Exception {

        if(this.isEnrolled(enrollment.getTraining(), enrollment.getTrainee()))
            throw new Exception("Enrollment exists");

        if (StringUtils.isBlank(enrollment.getTrainee().getId().toString()))
            throw new Exception("Invalid User to enroll");
        if (StringUtils.isBlank(enrollment.getTraining().getId().toString()))
            throw new Exception("Invalid training");

        User trainer = assignTrainerBean.getTrainer(enrollment.getTraining());

        User admin = userBean.getAdmin();
        MailWrapper mail = new MailWrapper();

        mail.setSubject("Enrollment for | " + enrollment.getTraining().getTitle());
        mail.setMessage("You have a new Enrollment for " + enrollment.getTraining().getTitle() + " From "
                + enrollment.getTrainee().getFirstName() + " " + enrollment.getTrainee().getLastName() + " Please check the " +
                "enrollment and approve.");
        mail.setTo(admin.getUsername());

        mailBean.sendMail(mail);

        mail.setMessage("You have a new Enrollment for " + enrollment.getTraining().getTitle() + " From "
                + enrollment.getTrainee().getFirstName() + " " + enrollment.getTrainee().getLastName() + " Please check the " +
                "enrollment.");

        mail.setTo(trainer.getUsername());
        mailBean.sendMail(mail);

        return entityManager.merge(enrollment);

    }

    public void update(Enrollment enrollment) throws Exception {
        if (enrollment == null || enrollment.getId() == null)
            throw new Exception("Invalid enrollment details");
        entityManager.merge(enrollment);
    }

    public void delete(Enrollment enrollment) throws Exception {
        if (enrollment == null || enrollment.getId() == null)
            throw new Exception("Invalid enrollment details");
        entityManager.remove(entityManager.find(Enrollment.class, enrollment.getId()));
    }
    public Enrollment getEnrollment(Long id){
        return entityManager.find(Enrollment.class, id);
    }

    public Enrollment approveEnrollment(Enrollment enrollment) throws Exception{
        if(StringUtils.isBlank(enrollment.getId().toString()))
            throw new Exception("Invalid enrollment");
        if(StringUtils.isBlank(enrollment.getStatus().toString()))
            throw new Exception("Invalid enrollment status");

        Enrollment newEnrollment = entityManager.find(Enrollment.class, enrollment.getId());
        newEnrollment.setStatus(enrollment.getStatus());

        MailWrapper mail = new MailWrapper();
        mail.setSubject("Capacity Building | Enrollment approval");

        mail.setTo(newEnrollment.getTrainee().getUsername());
        mail.setMessage("Your Enrollment for " + newEnrollment.getTraining().getTitle() + " has " +
                "been accepted, You can now access the training resources.");
        mailBean.sendMail(mail);

        return entityManager.merge(newEnrollment);

    }
    public List<Enrollment> getEnrollments() {

        return entityManager.createQuery("SELECT e FROM Enrollment e ", Enrollment.class)
                .getResultList();
    }

    public List<Enrollment> getApprovedEnrollments() {

        return entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.status=:status", Enrollment.class)
                .setParameter("status", EnrollmentStatus.APPROVED)
                .getResultList();
    }

    public List<Enrollment> getEnrollments(Training training) {

        return entityManager.createQuery("SELECT e FROM Enrollment e WHERE e.training.id=:id ", Enrollment.class)
                .setParameter("id", training.getId())
                .getResultList();
    }


    public List<Enrollment> getEnrollmentsByTrainings() {
        return entityManager.createQuery("SELECT new Enrollment(e.training, count(e.training)) FROM Enrollment e group by e.training", Enrollment.class)
                .getResultList();
    }

    public List<Enrollment> getEnrollmentsByTrainees() {
        return entityManager.createQuery("SELECT new Enrollment(e.trainee, count(e.trainee)) FROM Enrollment e group by e.trainee", Enrollment.class)
                .getResultList();
    }


    public List<Enrollment> getTrainees(Training training) {
        return entityManager.createQuery("FROM Enrollment e WHERE e.training.id=:id", Enrollment.class)
                .setParameter("id", training.getId())
                .getResultList();
    }

    public List<Training> getTrainings(User trainee) {

        List<Training> training = new ArrayList<>();

        TypedQuery<Enrollment> query = entityManager.createQuery("SELECT e FROM Enrollment e INNER JOIN e.trainee WHERE e.trainee.id=:traineeId", Enrollment.class)
                .setParameter("traineeId", trainee.getId());
        List<Enrollment> resultList = query.getResultList();
        resultList.forEach((enrollment) -> training.add(enrollment.getTraining()));
        return training;
    }

    public List<Training> getCompletedTrainings(User trainee) {

        List<Training> training = new ArrayList<>();
        entityManager.createQuery("FROM Enrollment e WHERE  e.trainee.id=:traineeId AND e.training.status=:status", Enrollment.class)
                .setParameter("traineeId", trainee.getId())
                .setParameter("status", TrainingStatus.COMPLETED)
                .getResultList()
                .forEach((enrollment) -> training.add(enrollment.getTraining())
                );

        return training;
    }

    public Boolean isEnrolled(Training training, User trainee) {
        List<Enrollment> enrollmentList = entityManager.createQuery("FROM Enrollment e WHERE e.training.id=:trainingId AND e.trainee.id=:traineeId", Enrollment.class)
                .setParameter("trainingId", training.getId())
                .setParameter("traineeId", trainee.getId())
                .getResultList();
        return enrollmentList.size() > 0;
    }

    public List<Enrollment> getEnrollments(User trainee){
        return entityManager.createQuery("FROM Enrollment e WHERE e.trainee.id=:userId", Enrollment.class)
                .setParameter("userId", trainee.getId())
                .getResultList();
    }

    public List<Enrollment> getEnrollmentsForTrainer(User trainer){

        List<Enrollment> trainerEnrollments = new ArrayList<>();
        for (Training training : assignTrainerBean.getTrainings(trainer)){
            List<Enrollment> enrollments = this.getEnrollments(training);
            trainerEnrollments.addAll(enrollments);
        }
        return trainerEnrollments;
    }
}