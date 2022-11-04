package com.capacitybuilding.controllers;

import com.capacitybuilding.model.AssignTrainer;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Stateless
@Remote
@Named("assignTrainerController")
public class AssignTrainerBean implements Serializable {

    @EJB
    HelperBean helperController;

    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() throws SQLException {

        return new ArrayList<>();

    }
    public List<AssignTrainer> generateList(ResultSet resultSet) throws SQLException {

        List<AssignTrainer> assignTrainerList = new ArrayList<>();
        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();

            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.setStatus(resultSet.getString("status"));
            assignTrainer.setDateAssigned(resultSet.getDate("DateAssigned").toLocalDate());
            assignTrainer.setTrainer(helperController.getUser(resultSet.getInt("trainerId")));
            assignTrainer.setTraining(helperController.getTraining(resultSet.getInt("trainingId ")));
            assignTrainerList.add(assignTrainer);
        }

        return assignTrainerList;
    }

    public List<User> getTrainers(Training training) throws SQLException {
        Map<String, String> criteria = new HashMap<>(){{
            put("TrainingId", Integer.toString(training.getId()));
        }};;
       return new ArrayList<>();

    }

    public List<Training> getTrainings(User trainer) throws SQLException{
        Map<String, String> criteria = new HashMap<>(){{
            put("TrainerId", Integer.toString(trainer.getId()));
        }};;

        List<Training> trainingList = new ArrayList<>();


        return new ArrayList<>();
    }

}
