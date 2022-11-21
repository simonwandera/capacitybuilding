package com.capacitybuilding.user.action;

import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.user.model.Usertype;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("createUser")
public class CreateUser extends HttpServlet {

    @EJB
    UserBeanI userBean;

    ServletContext servletContext;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        User user = new User();

        try {
            BeanUtils.populate(user, req.getParameterMap());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        user.setUserType(Usertype.USER);
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setConfirmPassword(DigestUtils.md5Hex(user.getConfirmPassword()));
        
        try {
            userBean.add(user);
            res.sendRedirect("./admin/users.jsp");
        } catch (Exception ex) {
            servletContext.setAttribute("registerError", ex.getMessage());
            res.sendRedirect("./addUser.jsp");
        }

    }

}
