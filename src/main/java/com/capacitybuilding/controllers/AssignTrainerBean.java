package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
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

    @Inject
    IMySQLDB<AssignTrainer> assignTrainerConnectionIMySQLDB;

    public void add(AssignTrainer assignTrainer){

    }
    public void update(AssignTrainer assignTrainer){

    }
    public void delete(AssignTrainer assignTrainer){

    }

    public List<AssignTrainer> list() throws SQLException {

        ResultSet resultSet = assignTrainerConnectionIMySQLDB.fetchAll();
        return this.generateList(resultSet);
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
        List<User> trainers = new ArrayList<>();

        assignTrainerConnectionIMySQLDB.setEntity(new AssignTrainer());
        ResultSet resultSet = assignTrainerConnectionIMySQLDB.executeReadQuery(assignTrainerConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));

        while (resultSet.next()){
            User trainer = helperController.getUser(resultSet.getInt("trainerId"));
            trainers.add(trainer);
        }
        return trainers;
    }

    public List<Training> getTrainings(User trainer) throws SQLException{
        Map<String, String> criteria = new HashMap<>(){{
            put("TrainerId", Integer.toString(trainer.getId()));
        }};;

        List<Training> trainingList = new ArrayList<>();

        ResultSet resultSet = assignTrainerConnectionIMySQLDB.executeReadQuery(assignTrainerConnectionIMySQLDB.createSelectWithWhereClauseQuery(criteria));
        while (resultSet.next()){
            Training training = helperController.getTraining(resultSet.getInt("TrainingId"));
            trainingList.add(training);
        }
        return new ArrayList<>();
    }

}