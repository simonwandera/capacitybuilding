package com.capacitybuilding.actions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.controllers.TrainingController;
import com.capacitybuilding.controllers.UserController;
import com.capacitybuilding.model.User;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/home")
public class HomeAction extends HttpServlet {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;

    @Inject
    UserController userController;

    List<User> trainees;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

        try {
            IMySQLDB<User, Connection> traineeMysqlDB = new MySQLDB<>(new User(), dataSource.getConnection());
            ResultSet resultSet = traineeMysqlDB.fetchAll();
            trainees = userController.generateList(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("./main/adminDashboard.jsp");
    }

}
