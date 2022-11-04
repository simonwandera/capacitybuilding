package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
@Named("trainingController")
public class TrainingBean implements Serializable {


    public void add(Training training) throws SQLException {

    }
    public void update(Training training) throws SQLException {

    }
    public void delete(TrainingBean trainingController){

    }

    public List<Training> getList() throws SQLException {
        return new ArrayList<>();
    }

    public List<Training> generateList(ResultSet resultSet) throws SQLException {

      return new ArrayList<>();
    }

}