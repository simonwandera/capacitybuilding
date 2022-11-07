package com.capacitybuilding.model;

import javax.persistence.*;

@Entity
@Table(name = "assignTrainers")
public class AssignTrainer extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "trainee_id", referencedColumnName = "id")
    private Training training;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private User trainer;

    @Column(name = "status")
    private String Status;

}
