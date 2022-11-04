package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.controllers.UserBean;
import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/updateTrainee")
public class UpdateTrainee extends HttpServlet {
    private String sessionEmail;
    private User user = null;
    Connection connection;
    ServletContext servletContext;

    @EJB
    UserBeanI userBean;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        sessionEmail = (String) session.getAttribute("email");
        User myUser = new User();

        int id = Integer.parseInt(req.getParameter("id"));

        res.sendRedirect("./trainee/updateTrainee.jsp");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (StringUtils.isBlank(user.getFirstName())) {
            servletContext.setAttribute("updateTraineeError", "First name is required");
            res.sendRedirect("./trainee/updateTrainee.jsp");
            return;
        }

        if (StringUtils.isBlank(user.getLastName())) {
            servletContext.setAttribute("updateTraineeError", "Last name is required");
            res.sendRedirect("./trainee/updateTrainee.jsp");
            return;
        }

        if (StringUtils.isBlank(user.getGender())) {
            servletContext.setAttribute("updateTraineeError", "Gender name is required");
            res.sendRedirect("./trainee/updateTrainee.jsp");
            return;
        }

        if (StringUtils.isBlank(user.getUsername())) {
            servletContext.setAttribute("updateTraineeError", "Email name is required");
            res.sendRedirect("./trainee/updateTrainee.jsp");
            return;
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("./trainees");
        dispatcher.forward(req, res);
    }

}
