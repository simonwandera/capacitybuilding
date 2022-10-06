package com.capacitybuilding.actions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/trainees")
public class TraineeAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.getWriter().print(this.addTrainee(null, (String) session.getAttribute("email")));

    }

    public String addTrainee(String actionError, String email){
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
                "                            <button type=\"button\" class=\"btn btn-sm ml-3 btn-success\"> Add Trainee </button>\n" +
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
                "                          <table class=\"table table-striped\">\n" +
                "                            <thead>\n" +
                "                              <tr>\n" +
                "                                <th>User</th>\n" +
                "                                <th>First name</th>\n" +
                "                                <th>Last Name</th>\n" +
                "                                <th>Email</th>\n" +
                "                                <th>Gender</th>\n" +
                "                                <th>Date</th>\n" +
                "                                <th>Action</th>\n" +
                "                              </tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                              <tr>\n" +
                "                                <td class=\"py-1\">\n" +
                "                                  <img src=\"./assets/images/faces-clipart/pic-1.png\" alt=\"image\" />\n" +
                "                                </td>\n" +
                "                                <td>Herman</td>\n" +
                "                                <td>Beck</td>\n" +
                "                                <td>hermanback@gmail.com</td>\n" +
                "                                <td>$ 77.99</td>\n" +
                "                                <td>May 15, 2015</td>\n" +
                "                                <td>\n" +
                "                                    <i class=\"mdi mdi-border-color mdi-24px\"></i>\n" +
                "                                    <i class=\"mdi mdi-delete md-24 mdi-24px\"></i>\n" +
                "                                </td>\n" +
                "                              </tr>\n" +
                "                              <tr>\n" +
                "                                <td class=\"py-1\">\n" +
                "                                  <img src=\"./assets/images/faces-clipart/pic-2.png\" alt=\"image\" />\n" +
                "                                </td>\n" +
                "                                <td>Messsy</td>\n" +
                "                                <td>Adam</td>\n" +
                "                                <td>hermanback@company.com</td>\n" +
                "                                <td>$245.30</td>\n" +
                "                                <td>July 1, 2015</td>\n" +
                "                                <td>\n" +
                "                                    <i class=\"mdi mdi-border-color mdi-24px\"></i>\n" +
                "                                    <i class=\"mdi mdi-delete md-24 mdi-24px\"></i>\n" +
                "                                </td>\n" +
                "                              </tr>\n" +
                "\n" +
                "                              <tr>\n" +
                "                                <td class=\"py-1\">\n" +
                "                                  <img src=\"./assets/images/faces-clipart/pic-3.png\" alt=\"image\" />\n" +
                "                                </td>\n" +
                "                                <td>John </td>\n" +
                "                                <td>Richards</td>\n" +
                "                                <td>kevinmill@gmail.com</td>\n" +
                "                                <td>$138.00</td>\n" +
                "                                <td>Apr 12, 2015</td>\n" +
                "                                <td>\n" +
                "                                    <i class=\"mdi mdi-border-color mdi-24px\"></i>\n" +
                "                                    <i class=\"mdi mdi-delete md-24 mdi-24px\"></i>\n" +
                "                                </td>\n" +
                "                              </tr>\n" +
                "\n" +
                "                              \n" +
                "                            </tbody>\n" +
                "                          </table>\n" +
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
}
