package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Stateless
@Remote
public class HelperBean {

    @Inject
    private IMySQLDB<Training> trainingIMySQLDB;

    @Inject
    private IMySQLDB<User> userIMySQLDB;

    public Training getTraining(int id) throws SQLException {
        Training training = new Training();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;

        trainingIMySQLDB.setEntity(new Training());
        ResultSet resultSet2 = trainingIMySQLDB.executeReadQuery(trainingIMySQLDB.createSelectWithWhereClauseQuery(criteria));
        while (resultSet2.next()){
            training.setId(resultSet2.getInt("id"));
            training.setTitle(resultSet2.getString("title"));
            training.setDescription(resultSet2.getString("description"));
            training.setDuration(resultSet2.getInt("duration"));
            training.setDateAdded(resultSet2.getDate("dateAdded").toLocalDate());
            training.setStartDate(resultSet2.getDate("startDate").toLocalDate());
            training.setStatus(resultSet2.getString("status"));
        }
        return training;
    }


    public User getUser(int id) throws SQLException {
        User user = new User();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;

        userIMySQLDB.setEntity(new User());
        ResultSet resultSet1 = userIMySQLDB.executeReadQuery(userIMySQLDB.createSelectWithWhereClauseQuery(criteria));
        while (resultSet1.next()){
            user.setId(resultSet1.getInt("id"));
            user.setFirstName(resultSet1.getString("firstname"));
            user.setLastName(resultSet1.getString("lastname"));
            user.setGender(resultSet1.getString("gender"));
            user.setUsername(resultSet1.getString("username"));
            user.setUserType(resultSet1.getString("userType"));
        }
        return user;
    }
}
