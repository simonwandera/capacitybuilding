package com.capacitybuilding.model;

import javax.persistence.*;

@Entity
@Table(name = "assessment")
public class Assessment extends BaseEntity{

    @Column(name = "marks")
    private int marks;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "enrollment_id", referencedColumnName = "id")
    private Enrollment enrollment;

    @Column(name = "remarks")
    private String remarks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
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
