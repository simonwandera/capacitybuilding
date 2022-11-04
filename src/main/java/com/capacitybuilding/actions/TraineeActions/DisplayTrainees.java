package com.capacitybuilding.actions.TraineeActions;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/trainees")
public class DisplayTrainees extends HttpServlet {
    Connection connection;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

}
