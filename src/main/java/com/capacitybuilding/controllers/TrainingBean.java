package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("trainingController")
public class TrainingBean implements TrainingBeanI {


    public void add(Training training) {

    }
    public void update(Training training) {

    }
    public void delete(TrainingBean trainingController){

    }

    public List<Training> getList() {
        return new ArrayList<>();
    }

    public List<Training> generateList() {

      return new ArrayList<>();
    }

}