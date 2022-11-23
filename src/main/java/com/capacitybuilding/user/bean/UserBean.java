package com.capacitybuilding.user.bean;

import com.capacitybuilding.mail.bean.MailBeanI;
import com.capacitybuilding.mail.model.MailWrapper;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.user.model.Usertype;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.*;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Remote
@Named("userBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserBean implements UserBeanI {

    @PersistenceContext
    EntityManager entityManager;

    @EJB
    MailBeanI mailBean;

    public User add(User user) throws Exception {
        if(StringUtils.isBlank(user.getFirstName()))
            throw new Exception("First name is required");
        if(StringUtils.isBlank(user.getLastName()))
            throw new Exception("Last name is required");
        if (StringUtils.isBlank(user.getUsername()))
            throw new Exception("Email is required");
        if (StringUtils.isBlank(user.getGender()) || user.getGender().equals("--Select Gender--"))
            throw new Exception("Gender is required");

        if (StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getConfirmPassword())
                || !user.getPassword().equals(user.getConfirmPassword()))
            throw new Exception("Password & confirm password is required and must match");

        MailWrapper mail = new MailWrapper();
        mail.setSubject("Capacity Building | New User registration");
        mail.setTo("simonwandera12@gmail.com");

        String msg = "Hello, \n A new user has been registered to the system \n" +
                "Name: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                "Email: " + user.getUsername() + "\n" +
                "Thank you!";
        mail.setMessage(msg);

        mailBean.sendMail(mail);

        return entityManager.merge(user);

    }

    public User update(User user) throws Exception {

        User findUser = entityManager.find(User.class, user.getId());
        user.setPassword(findUser.getPassword());
        user.setConfirmPassword(findUser.getPassword());

        user.setUserType(findUser.getUserType());
        user.setTimeCreated(findUser.getTimeCreated());

        if(StringUtils.isBlank(user.getFirstName()))
            throw new Exception("First name is required");
        if(StringUtils.isBlank(user.getLastName()))
            throw new Exception("Last name is required");
        if (StringUtils.isBlank(user.getUsername()))
            throw new Exception("Email is required");
        if (StringUtils.isBlank(user.getGender()) || user.getGender().equals("--Select gender--"))
            throw new Exception("Gender is required");

        return entityManager.merge(user);

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
        List<User> users = entityManager.createQuery("FROM User a ORDER BY a.userType" , User.class)
                .getResultList();
        return users;
    }

    public List<User> getTrainers() {
        List<User> users = entityManager.createQuery("FROM User a WHERE a.userType=:userType" , User.class)
                .setParameter("userType", Usertype.TRAINER)
                .getResultList();
        return users;
    }

    public List<User> getTrainees() {
        List<User> users = entityManager.createQuery("FROM User a WHERE a.userType=:userType" , User.class)
                .setParameter("userType", Usertype.USER)
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

        users.get(0).setBearerToken(DigestUtils.md5Hex(user.getUsername() + user.getPassword()));

        return users.get(0);
    }

    public User changeUserType(User user) throws Exception {
        if(StringUtils.isBlank(user.getUserType().toString()))
            throw new Exception("Invalid usertype");
        if(StringUtils.isBlank(user.getId().toString()))
            throw new Exception("Invalid user");

        User newUser = entityManager.find(User.class, user.getId());
        newUser.setUserType(user.getUserType());
        return entityManager.merge(newUser);
    }

    public User getAdmin() {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.userType=:userType", User.class)
                .setParameter("userType", Usertype.ADMIN)
                .getSingleResult();
    }

    public boolean authMd5(String md5Hash) {
        if(md5Hash == null)
            return false;

        List<User> users = entityManager.createQuery("FROM User u", User.class)
                .getResultList();

        if (users == null || users.isEmpty())
            return false;

        boolean isAuthenticated = false;
        for (User user: users){
            if (DigestUtils.md5Hex(user.getUsername() + user.getPassword()).equals(md5Hash)) {
                isAuthenticated = true;
                break;
            }
        }
        return isAuthenticated;
    }


}
