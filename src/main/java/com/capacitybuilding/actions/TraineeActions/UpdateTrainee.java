package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.actions.Common;
import com.capacitybuilding.controllers.UserController;
import com.capacitybuilding.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

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
            IMySQLDB<User, Connection> traineeMysqlDB = new MySQLDB<>(myUser, connection);
            ResultSet resultSet = traineeMysqlDB.fetchAll();

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

                try{
                    IMySQLDB<User, Connection> traineeMysqlDB = new MySQLDB<>(tr, connection);
                    traineeMysqlDB.update();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("./trainees");
        dispatcher.forward(req, res);
    }

    public String updateTrainee(String actionError, User user){

        return Common.Header() +
                "  <body>\n" +
                "    <div class=\"container-scroller\">\n" +
                Common.SideNav() +
                "      <div class=\"container-fluid page-body-wrapper\">\n" +
                "        <div id=\"theme-settings\" class=\"settings-panel\">\n" +
                "          <i class=\"settings-close mdi mdi-close\"></i>\n" +
                "          <p class=\"settings-heading\">SIDEBAR SKINS</p>\n" +
                "          <div class=\"sidebar-bg-options selected\" id=\"sidebar-default-theme\">\n" +
                "            <div class=\"img-ss rounded-circle bg-light border mr-3\"></div> Default\n" +
                "          </div>\n" +
                "          <div class=\"sidebar-bg-options\" id=\"sidebar-dark-theme\">\n" +
                "            <div class=\"img-ss rounded-circle bg-dark border mr-3\"></div> Dark\n" +
                "          </div>\n" +
                "          <p class=\"settings-heading mt-2\">HEADER SKINS</p>\n" +
                "          <div class=\"color-tiles mx-0 px-4\">\n" +
                "            <div class=\"tiles light\"></div>\n" +
                "            <div class=\"tiles dark\"></div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                Common.TopNav(sessionEmail) +
                "<div class=\"main-panel\">\n" +
                "                <div class=\"content-wrapper pb-0\">\n" +
                "                    <div class=\"page-header flex-wrap\">\n" +
                "                        <h3 class=\"mb-0\"> Update Trainee </h3>\n" +
                "                        <div class=\"d-flex\">\n" +
                "                            <a class=\"btn btn-sm ml-3 btn-success\" href=\"./trainees\"> All Trainees </a>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "               \n" +
                "                <div class=\"col-md-6 grid-margin stretch-card mx-auto my-3\">\n" +
                "                    <div class=\"card\">\n" +
                "                      <div class=\"card-body\">\n" +
                "                        <h4 class=\"card-title\">Update Trainee</h4>\n" +
                "                        <p class=\"card-description\">Basic form layout</p>\n" +
                "                        <form class=\"forms-sample\" method=\"POST\"> \n" +
                "                          <input type=\"hidden\" name=\"id\" id=\"id\" value=\"" + user.getId() + "\" placeholder=\"John\" />\n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"email\">First name</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"firstName\" id=\"firstName\" value=\"" + user.getFirstName() + "\" placeholder=\"John\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputEmail1\">Last Name</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"lastName\" id=\"lastName\" value=\"" + user.getLastName() + "\" placeholder=\"Doe\" />\n" +
                "                          </div>\n" +

                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputEmail1\">Email</label>\n" +
                "                            <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" value=\"" + user.getUsername() + "\" placeholder=\"johndoe@example.com\" />\n" +
                "                          </div>\n" +
                                            this.SelectGender(user) +
                "                          <div class=\"py-1 text-center\">\n" +
                "                               <span class=\"text-danger \">" + (actionError != null? actionError : "") + "</span>\n" +
                "                          </div>\n" +
                "                          <button type=\"submit\" class=\"btn btn-success mr-2 mt-1\"> Submit </button>\n" +
                "                        </form>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>" +
                Common.Footer();
    }
    public String SelectGender(User user){

        if(user.getGender().equalsIgnoreCase("Male")) {
            return  "<div class=\"form-group\">\n" +
                    "  <label for=\"gender\">Gender</label>\n" +
                    "  <select class=\"form-control\" name=\"gender\" id=\"exampleSelectGender\">\n" +
                    "      <option selected>Male</option>\n" +
                    "      <option>Female</option>\n" +
                    "      <option>Other</option>\n" +
                    "  </select>\n" +
                    "</div>\n" ;

        } else if (user.getGender().equalsIgnoreCase("Female")){
            return  "<div class=\"form-group\">\n" +
                    "  <label for=\"gender\">Gender</label>\n" +
                    "  <select class=\"form-control\" name=\"gender\" id=\"exampleSelectGender\">\n" +
                    "      <option>Male</option>\n" +
                    "      <option selected>Female</option>\n" +
                    "      <option>Other</option>\n" +
                    "  </select>\n" +
                    "</div>\n" ;
        } else if (user.getGender().equalsIgnoreCase("other")){
            return  "<div class=\"form-group\">\n" +
                    "  <label for=\"gender\">Gender</label>\n" +
                    "  <select class=\"form-control\" name=\"gender\" id=\"gender\">\n" +
                    "      <option>Male</option>\n" +
                    "      <option>Female</option>\n" +
                    "      <option selected>Other</option>\n" +
                    "  </select>\n" +
                    "</div>\n" ;
        }else{
            return  "<div class=\"form-group\">\n" +
                    "  <label for=\"gender\">Gender</label>\n" +
                    "  <select class=\"form-control\" name=\"gender\" id=\"exampleSelectGender\">\n" +
                    "      <option>Male</option>\n" +
                    "      <option>Female</option>\n" +
                    "      <option>Other</option>\n" +
                    "  </select>\n" +
                    "</div>\n" ;
        }
        }

}
