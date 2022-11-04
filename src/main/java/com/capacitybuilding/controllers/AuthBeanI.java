package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;

import java.util.Map;

public interface AuthBeanI {

    User login(Map<String, String> criteria);
}
