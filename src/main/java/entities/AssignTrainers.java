package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class AssignTrainers {
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
    @Column(name = "trainer_id")
    private Long trainerId;
    @Basic
    @Column(name = "trainee_id")
    private Long traineeId;

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

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignTrainers that = (AssignTrainers) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timeCreated != null ? !timeCreated.equals(that.timeCreated) : that.timeCreated != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (trainerId != null ? !trainerId.equals(that.trainerId) : that.trainerId != null) return false;
        if (traineeId != null ? !traineeId.equals(that.traineeId) : that.traineeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeCreated != null ? timeCreated.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (trainerId != null ? trainerId.hashCode() : 0);
        result = 31 * result + (traineeId != null ? traineeId.hashCode() : 0);
        return result;
    }
}
