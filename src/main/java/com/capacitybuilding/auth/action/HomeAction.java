package com.capacitybuilding.auth.action;

import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeAction extends HttpServlet {

    @EJB
    UserBeanI userBean;

    List<User> trainees;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{


        res.sendRedirect("./main/adminDashboard.jsp");
    }

}
