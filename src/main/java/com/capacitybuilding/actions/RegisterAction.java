package com.capacitybuilding.actions;

import com.capacitybuilding.model.User;
import org.apache.commons.codec.digest.DigestUtils;

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

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");

        if (email == null || email.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Email is required");
            res.sendRedirect("./auth/register.jsp");
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Password is required!");
            res.sendRedirect("./auth/register.jsp");
            return;
        }

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Confirm password is required!");
            res.sendRedirect("./auth/register.jsp");
            return;
        }

        if (firstName == null || firstName.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "FirstName is required!");
            res.sendRedirect("./auth/register.jsp");
            return;
        }

        if (lastName == null || lastName.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "LastName is required!");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        if (!password.equals(confirmPassword)){
            servletContext.setAttribute("signupError", "Password mismatch!");
            res.sendRedirect("./auth/register.jsp");
            return;
        }

        if (gender == null || gender.equalsIgnoreCase("")) {
            servletContext.setAttribute("signupError", "Gender is required");
            res.sendRedirect("./web/register.jsp");
            return;
        }

        User login = new User();

        login.setFirstName(firstName);
        login.setLastName(lastName);
        login.setGender(gender);
        login.setUsername(email);
        login.setPassword(DigestUtils.md5Hex(password));
        login.setUserType("USER");

        res.sendRedirect("./auth/login.jsp");
    }

}
