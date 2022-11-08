package com.capacitybuilding.actions.TrainingsActions;

import com.capacitybuilding.controllers.EnrollmentBeanI;
import com.capacitybuilding.controllers.TrainingBeanI;
import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.Enrollment;
import com.capacitybuilding.model.User;
import org.apache.commons.lang3.StringUtils;

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

@WebServlet("/enroll")
public class Enroll extends HttpServlet {

    @EJB
    UserBeanI userBean;
    @EJB
    TrainingBeanI trainingBean;

    @EJB
    EnrollmentBeanI enrollmentBean;

    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        HttpSession session = req.getSession();

        String trainingId = req.getParameter("trainingId");
        User trainee = (User) session.getAttribute("activeUser");

        Enrollment enrollment = new Enrollment();
        enrollment.setStatus("PENDING");
        enrollment.setTrainee(trainee);
        enrollment.setTraining(trainingBean.getTraining(Long.parseLong(trainingId)));

        try {
            enrollmentBean.enroll(enrollment);
            res.sendRedirect("./training/displayTrainings.jsp");
        } catch (Exception e) {
            servletContext.setAttribute("enrollmentError" , e.getMessage());
            res.sendRedirect("/home");
        }

    }
}
