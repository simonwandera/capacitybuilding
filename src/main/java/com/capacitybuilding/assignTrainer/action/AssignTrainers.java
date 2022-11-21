package com.capacitybuilding.assignTrainer.action;

import com.capacitybuilding.assignTrainer.bean.AssignTrainerBeanI;
import com.capacitybuilding.training.bean.TrainingBeanI;
import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.assignTrainer.model.AssignTrainer;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String trainingId = req.getParameter("trainingId");
        String trainerId = req.getParameter("trainerId");

        AssignTrainer assignTrainer = new AssignTrainer();

        assignTrainer.setTrainer(userBean.getUser(Long.parseLong(trainerId)));
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
