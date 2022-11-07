package entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "time_created")
    private Date timeCreated;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "lastName")
    private String lastName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "userType")
    private String userType;
    @Basic
    @Column(name = "username")
    private String username;
    @OneToMany(mappedBy = "usersByTrainerId")
    private Collection<AssignTrainers> assignTrainersById;
    @OneToMany(mappedBy = "usersByTraineeId")
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (timeCreated != null ? !timeCreated.equals(users.timeCreated) : users.timeCreated != null) return false;
        if (firstName != null ? !firstName.equals(users.firstName) : users.firstName != null) return false;
        if (gender != null ? !gender.equals(users.gender) : users.gender != null) return false;
        if (lastName != null ? !lastName.equals(users.lastName) : users.lastName != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (userType != null ? !userType.equals(users.userType) : users.userType != null) return false;
        if (username != null ? !username.equals(users.username) : users.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timeCreated != null ? timeCreated.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
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
