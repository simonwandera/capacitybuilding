package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.model.Training;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
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

    @Inject
    IMySQLDB<Training> trainingIMySQLDB;

    public void add(Training training) throws SQLException {


        trainingIMySQLDB.setEntity(training);
        trainingIMySQLDB.save();
    }
    public void update(Training training) throws SQLException {

        trainingIMySQLDB.setEntity(training);
        trainingIMySQLDB.update();

    }
    public void delete(TrainingBean trainingController){

    }

    public List<Training> getList() throws SQLException {
        trainingIMySQLDB.setEntity(new Training());
        ResultSet resultSet = trainingIMySQLDB.fetchAll();
        return this.generateList(resultSet);
    }

    public List<Training> generateList(ResultSet resultSet) throws SQLException {

        List<Training> trainingList = new ArrayList<>();
        while (resultSet.next()){

            Training training = new Training();
            training.setId(resultSet.getInt("id"));
            training.setTitle(resultSet.getString("title"));
            training.setDescription(resultSet.getString("description"));
            training.setDuration(resultSet.getInt("duration"));
            training.setDateAdded(resultSet.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet.getDate("startDate").toLocalDate());
            training.setStatus(resultSet.getString("status"));

            trainingList.add(training);
        }
        return trainingList;
    }

}