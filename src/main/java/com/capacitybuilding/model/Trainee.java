package com.capacitybuilding.model;

import java.io.Serializable;

public class Trainee implements Serializable {
    static int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;

    public Trainee() {
        id = id + 1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
