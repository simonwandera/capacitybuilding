package com.capacitybuilding.assessment.model;

import com.capacitybuilding.util.model.BaseEntity;
import com.capacitybuilding.enrollment.model.Enrollment;

import javax.persistence.*;

@Entity
@Table(name = "assessment")
@NamedQueries({
        @NamedQuery(name = Assessment.FIND_ALL, query = "select a from Assessment a")
})
public class Assessment extends BaseEntity {

    public static final String FIND_ALL = "Assessment.findAll";

    @Column(name = "score")
    private int score;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enrollment_id", referencedColumnName = "id")
    private Enrollment enrollment;

    public int getScore() {
        return score;
    }

    public void setScore(int marks) {
        this.score = marks;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
