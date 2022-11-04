package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
@Remote
public class AuthBean implements AuthBeanI{

    public User login(Map<String, String> criteria) {

        User login = new User();

        return login;
    }
}
