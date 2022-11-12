package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserBeanI {

    User add(User user) throws Exception;
    void update(User user) throws Exception;
    void delete(User user);
    List<User> list();
    User getUser(Long id);
    User login(User user) throws Exception;
}
