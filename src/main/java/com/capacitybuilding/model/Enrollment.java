package com.capacitybuilding.model;


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

    @Column(name = "status")
    private String Status;

    public User getTrainee() {
        return trainee;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
