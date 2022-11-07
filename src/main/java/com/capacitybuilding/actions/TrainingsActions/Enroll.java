package com.capacitybuilding.actions.TrainingsActions;

import com.capacitybuilding.controllers.TrainingBeanI;
import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.Enrollment;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateTraining")
public class Enroll extends HttpServlet {

    @EJB
    UserBeanI userBean;

    @EJB
    TrainingBeanI trainingBean;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {

        String title = req.getParameter("title");
        String trainingId = req.getParameter("trainingId");
        String traineeId = req.getParameter("traineeId");

        Enrollment enrollment = new Enrollment();
        enrollment.setStatus("PENDING");
        enrollment.setTrainee();
        enrollment.setTraining();

    }
}
