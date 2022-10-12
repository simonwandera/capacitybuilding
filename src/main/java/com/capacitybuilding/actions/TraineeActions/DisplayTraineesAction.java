package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.actions.Common;
import com.capacitybuilding.model.Trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/trainees")
public class DisplayTraineesAction  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            res.getWriter().print(this.DisplayTrainees((String) session.getAttribute("email"), req.getSession()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session == null || session.getId() == null)
            res.sendRedirect("./");

        try {
            res.getWriter().print(this.DisplayTrainees((String) session.getAttribute("email"), req.getSession()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String DisplayTrainees(String email, HttpSession session) throws SQLException {

        Trainee trainee = new Trainee();
        List<Trainee> traineesList = trainee.display();

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
                Common.TopNav(email) +
                "<div class=\"main-panel\">\n" +
                "                <div class=\"content-wrapper pb-0\">\n" +
                "                    <div class=\"page-header flex-wrap\">\n" +
                "                        <h3 class=\"mb-0\"> All Trainees </h3>\n" +
                "                        <div class=\"d-flex\">\n" +
                "                            <a class=\"btn btn-sm ml-3 btn-success\" href=\"./addTrainee\"> Add Trainee </a>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "               \n" +
                "                <div class=\"col-lg-12 grid-margin stretch-card\">\n" +
                "                    <div class=\"card\">\n" +
                "                      <div class=\"card-body\">\n" +
                "                        <h4 class=\"card-title\">All Registered Trainees</h4>\n" +
                "                        <p class=\"card-description\"> Updated </p>\n" +
                "                        <div class=\"table-responsive\">\n" +
                                            traineeGrid((traineesList) +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "    </div>"+
                Common.Footer();
    }

    public String traineeGrid(List<Trainee> trainees) {

        String traineeGrid = "<table class=\"table table-striped\">\n" +
                "<thead>\n" +
                "  <tr>\n" +
                "    <th>User</th>\n" +
                "    <th>First name</th>\n" +
                "    <th>Last Name</th>\n" +
                "    <th>Email</th>\n" +
                "    <th>Gender</th>\n" +
                "    <th>Date</th>\n" +
                "    <th>Action</th>\n" +
                "  </tr>\n" +
                "</thead>\n" +
                "<tbody>\n" ;

        for (Trainee trainee : trainees)
            traineeGrid += "<tr>" +
                "<td class=\"py-1\">\n" +
                "<img src=\"./assets/images/faces-clipart/pic-1.png\" alt=\"image\" />\n" +
                "</td>\n" +
                "<td>" + trainee.getFirstName() + "</td>\n" +
                "<td>" +trainee.getLastName() + "</td>\n" +
                "<td>" +trainee.getEmail() + "</td>\n" +
                "<td>"+trainee.getGender()+"</td>\n" +
                "<td>" + new Date() + "</td>\n" +
                "<td>\n" +
                "<a href=\"./updateTrainee?id="+ trainee.getId() +"\"><i class=\"mdi mdi-border-color mdi-24px\"></i></a>\n" +
                "<a href=\"./deleteTrainee?id="+ trainee.getId() +"\"><i class=\"mdi mdi-delete md-24 mdi-24px text-danger\"></i></a>\n" +
                "</td>\n" +
                "</tr>\n";

        traineeGrid += "</tbody>\n" +
                "</table>\n";


        return traineeGrid;

    }
}
