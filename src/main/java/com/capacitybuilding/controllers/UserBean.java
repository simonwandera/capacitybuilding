package com.capacitybuilding.controllers;

import com.capacitybuilding.Service.IMySQLDB;
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
import java.util.Map;

@Stateless
@Remote
public class UserBean {

    @EJB
    HelperBean helperBean;

    @EJB
    AssignTrainerBean assignTrainerBean;

    @EJB
    EnrollmentBean enrollmentBean;

    @Inject
    IMySQLDB<User> userIMySQLDB;


    public void add(User user) {
        if (user == null || StringUtils.isBlank(user.getLastName()) || StringUtils.isBlank(user.getFirstName()) || StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getGender()))
            return;

        userIMySQLDB.save();
    }

    public void update(User user) {


    }

    public void delete(User user) {

    }

    public User login(Map<String, String> criteria) throws SQLException {

        User login = new User();
        userIMySQLDB.setEntity(login);

        try {
            String queryStatement = userIMySQLDB.createSelectWithWhereClauseQuery(criteria);
            ResultSet resultSet = userIMySQLDB.executeReadQuery(queryStatement);

            while (resultSet.next()) {
                login = helperBean.getUser(resultSet.getInt("id"));
            }

        } catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return login;
    }

    public List<User> list() throws SQLException {
        ResultSet resultSet = userIMySQLDB.fetchAll();
        return this.generateList(resultSet);
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
