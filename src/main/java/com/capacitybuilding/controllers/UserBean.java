package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class UserBean implements UserBeanI {

    @PersistenceContext
    EntityManager entityManager;

    public User add(User user) throws Exception {

        System.out.println("\n\n\n\n ********* We got here ********* \n\n\n\n\n");
        System.out.println("Usertype: " + user.getUserType());
        System.out.println("First name: " + user.getFirstName());
        System.out.println("Last name: " + user.getLastName());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Username: " + user.getUsername());


        if (user.getUsername() == null)
            throw new Exception("Email is required");
        if (user.getGender() == null)
            throw new Exception("Gender is required");
        if(user.getFirstName() == null)
            throw new Exception("First name is required");

        if (user.getPassword() == null || user.getConfirmPassword() == null
                || !user.getPassword().equals(user.getConfirmPassword()))
            throw new Exception("Password & confirm password is required and must match");

        return entityManager.merge(user);

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
