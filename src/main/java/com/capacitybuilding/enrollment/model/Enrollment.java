package com.capacitybuilding.enrollment.model;


import com.capacitybuilding.util.model.BaseEntity;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "trainee_id", referencedColumnName = "id")
    private User trainee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    @Transient
    private Long counts;

    public User getTrainee() {
        return trainee;
    }

    public Enrollment() {
    }

    public Enrollment(Long counts, EnrollmentStatus status, User trainee) {
        this.trainee = trainee;
        this.status = status;
        this.counts = counts;
    }

    public Enrollment(User trainee, Long counts) {
        this.trainee = trainee;
        this.counts = counts;
    }

    public Enrollment(Training training, Long counts) {
        this.training = training;
        this.counts = counts;
    }

    public void setTrainee(User trainee) {
        this.trainee = trainee;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus enrollmentStatus) {
        this.status = enrollmentStatus;
    }

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }
}
