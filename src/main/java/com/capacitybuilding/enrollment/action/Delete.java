package com.capacitybuilding.enrollment.action;

import com.capacitybuilding.enrollment.bean.EnrollmentBeanI;
import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.enrollment.model.EnrollmentStatus;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEnrollment")
public class Delete extends HttpServlet {


    @EJB
    EnrollmentBeanI enrollmentBean;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");

        Enrollment enrollment = new Enrollment();
        enrollment.setId(Long.parseLong(id));
        try {
            enrollmentBean.delete(enrollment);
            res.sendRedirect("./enrollment/allEnrollments.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
