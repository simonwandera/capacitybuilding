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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    ServletContext servletContext;
    Connection connection;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
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

        Login login = this.login(criteria);


        if (login == null || login.getId() < 1) {
            servletContext.setAttribute("loginError" , "Wrong username & password combination<br/>");
            res.sendRedirect("./auth/login.jsp");
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("username", login.getUsername());
        session.setAttribute("userType", login.getUserType());

        if (login.getUserType().equals("ADMIN"))
            res.sendRedirect("./main/adminDashboard.jsp");
        else if (login.getUserType().equals("USER")) {
            res.sendRedirect("./main/adminDashboard.jsp");
        }

    }

    public Login login(Map<String, String> criteria) {

        Login login = new Login();

        try {

            IMySQLDB<Login, Connection> loginMysqlDb = new MySQLDB<>(login, connection);

            String queryStatement = loginMysqlDb.createSelectWithWhereClauseQuery(criteria);
            ResultSet resultSet = loginMysqlDb.executeReadQuery(queryStatement);


            while (resultSet.next()) {
                login = new Login();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("userName"));
                login.setUserType(resultSet.getString("userType"));
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return login;
    }
}
