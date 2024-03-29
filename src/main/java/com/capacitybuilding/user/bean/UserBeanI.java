package com.capacitybuilding.user.bean;

import com.capacitybuilding.user.model.User;

import java.util.List;

public interface UserBeanI {

    User add(User user) throws Exception;
    User update(User user) throws Exception;
    void delete(User user);
    List<User> list();
    User getUser(Long id);
    User login(User user) throws Exception;

    User changeUserType(User user) throws Exception;

    List<User> getTrainers();

    List<User> getTrainees();

    boolean authMd5(String md5Hash);

    User getAdmin();
}
