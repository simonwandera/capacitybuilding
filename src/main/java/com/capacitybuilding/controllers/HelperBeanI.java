package com.capacitybuilding.controllers;

import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;

public interface HelperBeanI {

    Training getTraining(int id);
    User getUser(int id);
}
