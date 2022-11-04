package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.util.Map;


@Stateless
@Remote
public class AuthBean implements AuthBeanI{

    @EJB
    HelperBean helperBean;

    @PostConstruct
    public void init(){
        System.out.println("Bean has bean created we can ..do stuff..");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Bean is about to be destroyed....release resource.. close connection");
    }

    public User login(Map<String, String> criteria) {

        User login = new User();

        return login;
    }
}
