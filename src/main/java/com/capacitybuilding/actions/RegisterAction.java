package com.capacitybuilding.actions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.register(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter wr = res.getWriter();

        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String email = req.getParameter("email");

        String actionError = "";
        if (email == null || email.equalsIgnoreCase(""))
            actionError = "Email is required<br/>";

        if (password == null || password.equalsIgnoreCase(""))
            actionError += "Password is required<br/>";

        if (confirmPassword == null || confirmPassword.equalsIgnoreCase(""))
            actionError += "Confirm password is required<br/>";

        if (firstName == null || firstName.equalsIgnoreCase(""))
            actionError += "FirstName is required<br/>";

        if (lastName == null || lastName.equalsIgnoreCase(""))
            actionError += "LastName is required<br/>";

        if (dateOfBirth == null || dateOfBirth.equalsIgnoreCase(""))
            actionError += "Date of Birth is required<br/>";

        if (password != null && confirmPassword != null && !password.equals(confirmPassword))
            actionError += "Password & confirm password do not match<br/>";

        if (actionError.equals("")) {

            try {
                Login login = new Login();

                login.setUsername(email);
                login.setPassword(password);
                login.setUserType("USER");

                login.getMySqlDB().save();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            res.sendRedirect("./login");
        }


        else
            wr.print(this.register(actionError));
    }

    public String register(String actionError){
        return Common.Header() +
                "<body>\n" +
                "    <div class=\"container-scroller\">\n" +
                "        <div class=\"container-fluid page-body-wrapper\">\n" +
                "            <div class=\"main-panel\">\n" +
                "                <div class=\"content-wrapper\">\n" +
                "                    <div class=\"page-header\">\n" +
                "                        <h3 class=\"page-title m-auto\">" + getServletContext().getAttribute("appName") + "</h3>\n" +
                "                    </div>\n" +
                "                    <div class=\"row\">\n" +
                "                        <div class=\"col-12 grid-margin\">\n" +
                "                            <div class=\"card\">\n" +
                "                                <div class=\"card-body\">\n" +
                "                                    <div>\n" +
                "                                        <h4 class=\"card-title\">Sign Up</h4>\n" +
                "                                    </div>\n" +
                "                                    <form class=\"form-sample\" action=\"./register\" method=\"post\">\n" +
                "                                        <p class=\"card-description\">Personal info</p>\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">First Name</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input type=\"text\" name=\"firstName\" class=\"form-control\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Last Name</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input type=\"text\" name=\"lastName\" class=\"form-control\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"row\">\n" +
                "                                        </div>\n" +
                "                                        <div class=\"row\">\n" +
                "                                        </div>\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Email</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input type=\"email\" name=\"email\" class=\"form-control\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"row\">\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Password</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input type=\"password\" name=\"password\" class=\"form-control\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Confirm password</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input type=\"password\" name=\"confirmPassword\" class=\"form-control\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                        </div>\n" +
                "                                        <div class=\"my-3 py-2 text-center\">\n" +
                "                                            <span class=\"text-danger\">" +(actionError != null? actionError : "")+ "</span>\n" +
                "                                        </div>\n" +
                "                                        <button type=\"submit\" class=\"btn btn-primary mr-2\"> Register </button>\n" +
                "                                        <a href=\"./login\">Login</a>\n" +
                "                                    </form>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                Common.Footer();
    }
}
