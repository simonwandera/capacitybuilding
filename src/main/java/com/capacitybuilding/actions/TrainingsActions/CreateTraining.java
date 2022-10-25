package com.capacitybuilding.actions.TrainingsActions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Training;
import com.capacitybuilding.model.User;
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
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/addTraining")
public class CreateTraining extends HttpServlet {
    Connection connection;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.sendRedirect("./training/createTrainee.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String title = req.getParameter("title");
        int duration = Integer.parseInt(req.getParameter("duration"));
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        String description = req.getParameter("description");
        LocalDate dateAdded = LocalDate.now();

        if(title == null || title.equalsIgnoreCase("")){
            servletContext.setAttribute("trainingError", "Title is required");
            res.sendRedirect("./training/addTraining.jsp");
            return;
        }

        if(duration < 1 ){
            servletContext.setAttribute("trainingError", "Please enter a valid duration");
            res.sendRedirect("./training/addTraining.jsp");
            return;
        }

        if(dateAdded.toString().isEmpty()){
            servletContext.setAttribute("trainingError", "Date added id required");
            res.sendRedirect("./training/addTraining.jsp");
            return;
        }

        try {
            Connection connection = (Connection) servletContext.getAttribute("dbConnection");
            Training training = new Training();

            training.setTitle(title);
            training.setDescription(description);
            training.setDuration(duration);

            training.setStatus("UPCOMING");
            training.setStartDate(startDate);
            training.setDateAdded(dateAdded);

            IMySQLDB<Training, Connection> trainingConnectionMySQLDB = new MySQLDB<>(training, connection);
            trainingConnectionMySQLDB.save();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./training/displayTrainings.jsp");




    }
 }
