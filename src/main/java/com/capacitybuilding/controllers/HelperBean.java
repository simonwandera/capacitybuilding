package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

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



    public Training getTraining(int id) throws SQLException {
        Training training = new Training();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;

        return training;
    }


    public User getUser(int id) throws SQLException {
        User user = new User();
        Map<String, String> criteria = new HashMap<>(){{
            put("Id", Integer.toString(id));
        }};;


        return user;
    }
}
