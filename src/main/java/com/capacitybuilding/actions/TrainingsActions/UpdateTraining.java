package com.capacitybuilding.actions.TrainingsActions;

import com.capacitybuilding.controllers.TrainingBean;
import com.capacitybuilding.controllers.TrainingBeanI;
import com.capacitybuilding.model.Training;

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
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/updateTraining")
public class UpdateTraining extends HttpServlet {

    Connection connection;
    ServletContext servletContext;

    @EJB
    TrainingBeanI trainingBean;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.sendRedirect("./training/updateTraining.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String title = req.getParameter("title");
        int duration = req.getParameter("duration").isEmpty() ? 0 : Integer.parseInt(req.getParameter("duration"));
        LocalDate startDate = req.getParameter("startDate").isEmpty() ? LocalDate.of(0, 1, 1) : LocalDate.parse(req.getParameter("startDate"));

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

        if(startDate.getYear() == 0){
            servletContext.setAttribute("trainingError", "Start date is required");
            res.sendRedirect("./training/addTraining.jsp");
            return;
        }

        if(startDate.isBefore(LocalDate.now())){
            servletContext.setAttribute("trainingError", "Start date cannot be a past date");
            res.sendRedirect("./training/addTraining.jsp");
            return;
        }

        Connection connection = (Connection) servletContext.getAttribute("dbConnection");
        Training training = new Training();

        training.setTitle(title);
        training.setDescription(description);
        training.setDuration(duration);

        training.setStatus("UPCOMING");
        training.setStartDate(startDate);
        training.setDateAdded(dateAdded);

        trainingBean.update(training);

        res.sendRedirect("./training/displayTrainings.jsp");



    }
}
