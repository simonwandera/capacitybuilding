package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;

import java.sql.ResultSet;
import java.util.List;

public interface UserBeanI {

    User add(User user) throws Exception;
    void update(User user);
    void delete(User user);
    List<User> list();
    List<User> generateList(ResultSet resultSet);

    User login(User user) throws Exception;
}
