package com.capacitybuilding.enrollment.model;


import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.util.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enrollments")
@NamedQueries({
        @NamedQuery(name = "Enrollment.findAll", query = "select e from Enrollment e"),
})
public class Enrollment extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainee_id", referencedColumnName = "id")
    @JsonManagedReference
    private User trainee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    @JsonManagedReference
    private Training training;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    @Transient
    private Long counts;

    @OneToMany(mappedBy = "enrollment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Assessment> assessments;

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

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
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
