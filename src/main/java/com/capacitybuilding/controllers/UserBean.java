package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class UserBean implements UserBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public void add(User user) throws Exception {

        if (user == null)
            throw new Exception("Invalid details");

        if (user.getUsername() == null)
            throw new Exception("Email is required");

    }

    public void update(User user) {


    }

    public void delete(User user) {

    }


    public List<User> list() {
       return new ArrayList<>();
    }

    public List<User> generateList(ResultSet resultSet) {


        return new ArrayList<>();
    }
}
