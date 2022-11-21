package com.capacitybuilding.user.action;

import com.capacitybuilding.user.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("createUser")
public class CreateUser extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        User user = new User();

        try {
            BeanUtils.populate(user, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(user);

//        try {
//            userBean.register(user);
//            res.sendRedirect("./login.jsp");
//
//        } catch (Exception ex) {
//            servletCtx.setAttribute("registerError" , ex.getMessage());
//            res.sendRedirect("./register.jsp");
//        }

    }




}
