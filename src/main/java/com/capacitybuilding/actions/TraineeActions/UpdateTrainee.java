package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.controllers.UserController;
import com.capacitybuilding.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/updateTrainee")
public class UpdateTrainee extends HttpServlet {
    private String sessionEmail;
    private User user = null;
    private List<User> users;
    Connection connection;
    ServletContext servletContext;

    @Inject
    IMySQLDB<User> userIMySQLDB;

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
        UserController userController = new UserController();

        try {
            userIMySQLDB.setEntity(myUser);
            ResultSet resultSet = userIMySQLDB.fetchAll();

            users = userController.generateList(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int id = Integer.parseInt(req.getParameter("id"));

        for (User tr: users){
            if(tr.getId() == id) {
                user = tr;
                System.out.println("*****************Trainee found********************");
            }
        }

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

        for (User tr: users){
            if(tr.getId() == user.getId()) {
                tr.setId(user.getId());
                tr.setUsername(user.getUsername());
                tr.setFirstName(user.getFirstName());
                tr.setLastName(user.getLastName());
                tr.setGender(user.getGender());

                userIMySQLDB.setEntity(tr);
                userIMySQLDB.update();
                userIMySQLDB.update();
                break;
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("./trainees");
        dispatcher.forward(req, res);
    }

}
