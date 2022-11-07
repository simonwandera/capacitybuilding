package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Trainings {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "time_created")
    private Date timeCreated;
    @Basic
    @Column(name = "dateAdded")
    private Date dateAdded;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "startDate")
    private Date startDate;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "trainingsByTraineeId")
    private Collection<AssignTrainers> assignTrainersById;
    @OneToMany(mappedBy = "trainingsByTrainingId")
    private Collection<Enrollments> enrollmentsById;

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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainings trainings = (Trainings) o;

        if (id != null ? !id.equals(trainings.id) : trainings.id != null) return false;
        if (timeCreated != null ? !timeCreated.equals(trainings.timeCreated) : trainings.timeCreated != null)
            return false;
        if (dateAdded != null ? !dateAdded.equals(trainings.dateAdded) : trainings.dateAdded != null) return false;
        if (description != null ? !description.equals(trainings.description) : trainings.description != null)
            return false;
        if (duration != null ? !duration.equals(trainings.duration) : trainings.duration != null) return false;
        if (startDate != null ? !startDate.equals(trainings.startDate) : trainings.startDate != null) return false;
        if (status != null ? !status.equals(trainings.status) : trainings.status != null) return false;
        if (title != null ? !title.equals(trainings.title) : trainings.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeCreated != null ? timeCreated.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Collection<AssignTrainers> getAssignTrainersById() {
        return assignTrainersById;
    }

    public void setAssignTrainersById(Collection<AssignTrainers> assignTrainersById) {
        this.assignTrainersById = assignTrainersById;
    }

    public Collection<Enrollments> getEnrollmentsById() {
        return enrollmentsById;
    }

    public void setEnrollmentsById(Collection<Enrollments> enrollmentsById) {
        this.enrollmentsById = enrollmentsById;
    }
}
