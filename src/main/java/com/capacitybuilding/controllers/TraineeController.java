package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Trainee;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TraineeController implements Serializable {

    public void add(Connection connection, Trainee trainee){
        if(trainee == null || StringUtils.isBlank(trainee.getLastName()) || StringUtils.isBlank(trainee.getFirstName()) || StringUtils.isBlank(trainee.getEmail()) || StringUtils.isBlank(trainee.getGender()) )
            return;

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
