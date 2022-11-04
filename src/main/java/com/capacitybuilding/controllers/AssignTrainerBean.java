package com.capacitybuilding.controllers;

import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Stateless
@Remote
@Named("assignTrainerController")
public class AssignTrainerBean implements AssignTrainerBeanI {


    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() {

        return new ArrayList<>();

    }
    public List<AssignTrainer> generateList(ResultSet resultSet) {

        return new ArrayList<>();
    }

    public List<User> getTrainers(Training training) {

       return new ArrayList<>();

    }

    public List<Training> getTrainings(User trainer){


        List<Training> trainingList = new ArrayList<>();


        return new ArrayList<>();
    }

}
