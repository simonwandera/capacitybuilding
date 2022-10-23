package com.capacitybuilding.actions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.controllers.UserController;
import com.capacitybuilding.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/home")
public class HomeAction extends HttpServlet {
    List<User> trainees;
    Connection connection;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        User user = new User();

        try {
            IMySQLDB<User, Connection> traineeMysqlDB = new MySQLDB<>(user, connection);
            ResultSet resultSet = traineeMysqlDB.fetchAll();
            trainees = new UserController().generateList(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("./main/adminDashboard.jsp");
    }

}
