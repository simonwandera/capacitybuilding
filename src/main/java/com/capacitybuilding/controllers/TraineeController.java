package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Trainee;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TraineeController implements Serializable {

    public void add(Connection connection, Trainee trainee){

    }

    public void update(Trainee trainee) {

    }

    public void delete(Trainee trainee) {

    }

    public List<Trainee> list(Connection connection, Trainee trainee){
        List<Trainee> trainees = new ArrayList<>();
        return trainees;
    }

}
