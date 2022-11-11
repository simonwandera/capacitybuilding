package com.capacitybuilding.actions.TrainingsActions;

import com.capacitybuilding.controllers.AssignTrainerBeanI;
import com.capacitybuilding.controllers.TrainingBeanI;
import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.AssignTrainer;

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

@WebServlet("/assignTrainer")
public class AssignTrainers extends HttpServlet {

    @EJB
    UserBeanI userBean;
    @EJB
    TrainingBeanI trainingBean;

    @EJB
    AssignTrainerBeanI assignTrainerBean;

    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession session = req.getSession();

        String trainingId = req.getParameter("trainingId");
        String trainerId = req.getParameter("trainerId");

        AssignTrainer assignTrainer = new AssignTrainer();
        assignTrainer.setTrainer(userBean.getUser(Long.parseLong(trainerId)));
        assignTrainer.setStatus("APPROVED");
        assignTrainer.setTraining(trainingBean.getTraining(Long.parseLong(trainingId)));

        try {
            assignTrainerBean.assign(assignTrainer);
            res.sendRedirect("./training/displayTrainings.jsp");
        } catch (Exception e) {
            servletContext.setAttribute("assignmentError" , e.getMessage());
            res.sendRedirect("/home");
        }

    }
}
