package com.capacitybuilding.training.model;

import com.capacitybuilding.util.model.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "uploads")
public class Upload extends BaseEntity {

    @Column
    private String fileName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
