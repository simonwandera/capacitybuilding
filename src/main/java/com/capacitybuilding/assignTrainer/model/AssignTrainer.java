package com.capacitybuilding.assignTrainer.model;

import com.capacitybuilding.util.model.BaseEntity;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "assignTrainers")
public class AssignTrainer extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private User trainer;

    @Enumerated(EnumType.STRING)
    private AssignStatus status;

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

    public AssignStatus getStatus() {
        return status;
    }

    public void setStatus(AssignStatus status) {
        this.status = status;
    }
}
