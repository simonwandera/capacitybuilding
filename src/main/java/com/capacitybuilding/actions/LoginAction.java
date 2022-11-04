package com.capacitybuilding.actions;

import com.capacitybuilding.controllers.UserBean;
import com.capacitybuilding.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    @EJB
    UserBean userBean;
    private ServletContext servletContext;


    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().invalidate();
        res.sendRedirect("./auth/login.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String password = req.getParameter("password");
        String email = req.getParameter("email");


        if (email == null || email.equalsIgnoreCase("")){
            servletContext.setAttribute("loginError" , "Email is required<br/>");
            res.sendRedirect("./auth/login.jsp");
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            servletContext.setAttribute("loginError" , "Password is required<br/>");
            res.sendRedirect("./auth/login.jsp");
            return;
        }

        Map<String, String> criteria = new HashMap<>(){{
            put("Username", email);
            put("Password", DigestUtils.md5Hex(password));
        }};;

        User user = null;
        try {
            user = this.userBean.login(criteria);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (user == null || user.getId() < 1) {
            servletContext.setAttribute("loginError" , "Wrong username & password combination<br/>");
            res.sendRedirect("./auth/login.jsp");
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("username", user.getUsername());
        session.setAttribute("userType", user.getUserType());

        if (user.getUserType().equals("ADMIN"))
            res.sendRedirect("./main/adminDashboard.jsp");
        else if (user.getUserType().equals("USER"))
            res.sendRedirect("./main/traineeDashboard.jsp");
        else if (user.getUserType().equals("TRAINER"))
            res.sendRedirect("./main/trainerDashboard.jsp");
    }
}
