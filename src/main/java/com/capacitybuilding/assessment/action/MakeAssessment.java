package com.capacitybuilding.assessment.action;

import com.capacitybuilding.assessment.bean.AssessmentBeanI;
import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.enrollment.bean.EnrollmentBeanI;
import com.capacitybuilding.enrollment.model.Enrollment;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/makeAssessment")
public class MakeAssessment extends HttpServlet {

    ServletContext servletContext;

    @EJB
    EnrollmentBeanI enrollmentBean;

    @EJB
    AssessmentBeanI assessmentBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String id = req.getParameter("id");
        String score = req.getParameter("score");
        String remarks = req.getParameter("remarks");

        Enrollment enrollment = enrollmentBean.getEnrollment(Long.parseLong(id));

        Assessment assessment = new Assessment();
        assessment.setScore(Integer.parseInt(score));
        assessment.setRemarks(remarks);
        assessment.setEnrollment(enrollment);

        try {
            assessmentBean.add(assessment);
            res.sendRedirect("./enrollment/singleEnrollments.jsp?trainingId="+enrollment.getTraining().getId());
        } catch (Exception e) {
            servletContext.setAttribute("assessmentError" , e.getMessage());
            res.sendRedirect("/home");
        }

    }

}
