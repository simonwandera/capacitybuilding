package com.capacitybuilding.controllers;

import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Remote
public class UserBean {

    @EJB
    HelperBean helperBean;

    @EJB
    AssignTrainerBean assignTrainerBean;

    @EJB
    EnrollmentBean enrollmentBean;


    public void add(User user) {
        if (user == null || StringUtils.isBlank(user.getLastName()) || StringUtils.isBlank(user.getFirstName()) || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getGender()))
            return;

    }

    public void update(User user) {


    }

    public void delete(User user) {

    }


    public List<User> list() throws SQLException {
       return new ArrayList<>();
    }

    public List<User> generateList(ResultSet resultSet) throws SQLException {

        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            User user = helperBean.getUser(resultSet.getInt("id"));
            user.setEnrolledTrainings(enrollmentBean.getTrainings(user));
            user.setAssignedTrainings(assignTrainerBean.getTrainings(user));

            userList.add(user);
        }
        return userList;
    }
}
