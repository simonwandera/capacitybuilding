package com.capacitybuilding.controllers;


import com.capacitybuilding.model.AssignTrainer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentController implements Serializable {

    public void add(EnrollmentController enrollmentController){

    }
    public void update(EnrollmentController enrollmentController){

    }
    public void delete(EnrollmentController enrollmentController){

    }
    public List<AssignTrainer> list(ResultSet resultSet, Connection connection) throws SQLException {
        List<AssignTrainer> assignTrainers = new ArrayList<>();
        while (resultSet.next()){
            AssignTrainer assignTrainer = new AssignTrainer();
            assignTrainer.setId(resultSet.getInt("id"));
            assignTrainer.setDateAssigned(resultSet.getDate("dateAssigned").toLocalDate());
            assignTrainer.setStatus(resultSet.getString("status"));
            assignTrainer.setTrainer(new UserController().getUser(resultSet.getInt("trainerId"), connection));
            assignTrainer.setTraining(new  TrainingController().getTraining(resultSet.getInt("trainingId "), connection));
            assignTrainers.add(assignTrainer);
        }
        return assignTrainers;
    }
}
