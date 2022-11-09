package com.capacitybuilding.actions;

import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.User;
import com.capacitybuilding.model.Usertype;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class RegisterAction extends HttpServlet {


    ServletContext servletContext;

    @EJB
    UserBeanI userBean;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        User user = new User();

        if(req.getParameter("id").isEmpty() || req.getParameter("id") == ""){

            try {
                BeanUtils.populate(user, req.getParameterMap());
                user.setUserType(Usertype.USER);
                user.setPassword(DigestUtils.md5Hex(req.getParameter("password")));
                user.setConfirmPassword(DigestUtils.md5Hex(req.getParameter("confirmPassword")));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }

        }else {
            try {
                BeanUtils.populate(user, req.getParameterMap());
                user.setId(Long.valueOf(req.getParameter("id")));
                user.setPassword(DigestUtils.md5Hex(req.getParameter("password")));
                user.setConfirmPassword(DigestUtils.md5Hex(user.getPassword()));
                user.setUserType(Usertype.valueOf(req.getParameter("userType")));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        try {
            userBean.add(user);
            res.sendRedirect("./auth/login.jsp");
        } catch (Exception ex) {
            servletContext.setAttribute("registerError" , ex.getMessage());
            res.sendRedirect("./auth/register.jsp");
        }
    }

}
