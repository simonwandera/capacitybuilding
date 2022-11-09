package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

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
        if(StringUtils.isBlank(user.getFirstName()))
            throw new Exception("First name is required");
        if(StringUtils.isBlank(user.getLastName()))
            throw new Exception("Last name is required");
        if (StringUtils.isBlank(user.getUsername()))
            throw new Exception("Email is required");
        if (StringUtils.isBlank(user.getGender()))
            throw new Exception("Gender is required");

        if (StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getConfirmPassword())
                || !user.getPassword().equals(user.getConfirmPassword()))
            throw new Exception("Password & confirm password is required and must match");
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));

        return entityManager.merge(user);

    }

    public void update(User user) {


    }

    public void delete(User user) {

    }

    public User getUser(Long id) {
        User user = entityManager.createQuery("FROM User a WHERE a.id=:id" , User.class)
                .setParameter("id", id)
                .getResultList().get(0);

        return user;
    }


    public List<User> list() {
        List<User> users = entityManager.createQuery("FROM User a " , User.class)
                .getResultList();
        return users;
    }

    @Override
    public User login(User user) throws Exception {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
            throw new Exception("Enter username and password to login");

        List<User> users = entityManager.createQuery("FROM User a WHERE a.username=:usrName " +
                        "and a.password=:pwd", User.class)

                .setParameter("usrName", user.getUsername())
                .setParameter("pwd", user.getPassword())
                .getResultList();

        if (users == null || users.isEmpty() || users.get(0) == null)
            throw new Exception("Invalid username or password");

        return users.get(0);
    }


}
