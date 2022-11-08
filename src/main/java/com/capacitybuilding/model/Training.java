package com.capacitybuilding.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "trainings")
public class Training extends BaseEntity {

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int duration;
    @Column
    private LocalDate startDate;
    @Column
    @Enumerated(EnumType.STRING)
    private TrainingStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public TrainingStatus getStatus() {
        return status;
    }

    public void setStatus(TrainingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Training{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", startDate=" + startDate +
                ", status='" + status + '\'' +
                '}';
    }
}

