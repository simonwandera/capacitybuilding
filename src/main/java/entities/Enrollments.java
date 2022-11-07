package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Enrollments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "time_created")
    private Date timeCreated;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "trainee_id")
    private Long traineeId;
    @Basic
    @Column(name = "training_id")
    private Long trainingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrollments that = (Enrollments) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timeCreated != null ? !timeCreated.equals(that.timeCreated) : that.timeCreated != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (traineeId != null ? !traineeId.equals(that.traineeId) : that.traineeId != null) return false;
        if (trainingId != null ? !trainingId.equals(that.trainingId) : that.trainingId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeCreated != null ? timeCreated.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (traineeId != null ? traineeId.hashCode() : 0);
        result = 31 * result + (trainingId != null ? trainingId.hashCode() : 0);
        return result;
    }
}
