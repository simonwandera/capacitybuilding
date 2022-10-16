package com.capacitybuilding.actions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Login;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterAction extends HttpServlet {

    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        if (email == null || email.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Email is required");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Password is required!");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Confirm password is required!");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        if (firstName == null || firstName.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "FirstName is required!");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        if (lastName == null || lastName.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "LastName is required!");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        try {
            Connection connection = (Connection) servletContext.getAttribute("dbConnection");
            Login login = new Login();

            login.setUsername(email);
            login.setPassword(DigestUtils.md5Hex(password));
            login.setUserType("USER");

            IMySQLDB<Login, Connection> loginCommonIMySQLDB = new MySQLDB<>(login, connection);
            loginCommonIMySQLDB.save();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("./web/login.jsp");

    }

}
