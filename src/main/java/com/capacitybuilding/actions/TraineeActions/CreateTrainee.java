package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

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
import java.util.List;

@WebServlet("/addTrainee")
public class CreateTrainee extends HttpServlet {
    private List<User> trainees;

    Connection connection;
    ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        res.sendRedirect("./trainee/addTrainee.jsp");
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = new User();

        try {
            BeanUtils.populate(user, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (StringUtils.isBlank(user.getUsername())) {
            servletContext.setAttribute("addTraineeError", "Email is required");
            res.sendRedirect("./trainee/addTrainee.jsp");
            return;
        }

        if (StringUtils.isBlank(user.getLastName())) {
            servletContext.setAttribute("addTraineeError", "Last name is required");
            res.sendRedirect("./trainee/addTrainee.jsp");
            return;
        }

        if (StringUtils.isBlank(user.getGender())) {
            servletContext.setAttribute("addTraineeError", "Gender is required");
            res.sendRedirect("./trainee/addTrainee.jsp");
            return;
        }

        try {
            IMySQLDB<User, Connection> traineeConnectionIMySQLDB = new MySQLDB<>(user, connection);
            traineeConnectionIMySQLDB.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("./main/adminDashboard.jsp");

    }
}
