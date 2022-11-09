package com.capacitybuilding.model;

import javax.persistence.*;

@Entity
@Table(name = "assignTrainers")
public class AssignTrainer extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private User trainer;

    @Column(name = "status")
    private String Status;

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {

        this.training = training;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
