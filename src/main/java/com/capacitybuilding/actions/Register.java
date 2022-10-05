package com.capacitybuilding.actions;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {

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

        if (actionError.equals(""))
            res.sendRedirect("./login");
        else
            wr.print(this.register(actionError));
    }

    public String register(String actionError){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "    <title>Sign Up</title>\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/mdi/css/materialdesignicons.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/flag-icon-css/css/flag-icon.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/css/vendor.bundle.base.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/select2/select2.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/css/style.css\" />\n" +
                "    <link rel=\"shortcut icon\" href=\"./assets/images/favicon.png\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container-scroller\">\n" +
                "        <div class=\"container-fluid page-body-wrapper\">\n" +
                "            <div class=\"main-panel\">\n" +
                "                <div class=\"content-wrapper\">\n" +
                "                    <div class=\"page-header\">\n" +
                "                        <h3 class=\"page-title m-auto\">" + getServletContext().getInitParameter("appName") + "</h3>\n" +
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
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Gender</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <select class=\"form-control\">\n" +
                "                                                            <option>Male</option>\n" +
                "                                                            <option>Female</option>\n" +
                "                                                        </select>\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
                "                                            <div class=\"col-md-6\">\n" +
                "                                                <div class=\"form-group row\">\n" +
                "                                                    <label class=\"col-sm-3 col-form-label\">Date of Birth</label>\n" +
                "                                                    <div class=\"col-sm-9\">\n" +
                "                                                        <input class=\"form-control\" name=\"dateOfBirth\" placeholder=\"dd/mm/yyyy\" />\n" +
                "                                                    </div>\n" +
                "                                                </div>\n" +
                "                                            </div>\n" +
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
                "                                        <button type=\"submit\" class=\"btn btn-primary mr-2\"> Sign In </button>\n" +
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
                "    <script src=\"./assets/vendors/js/vendor.bundle.base.js\"></script>\n" +
                "    <script src=\"./assets/vendors/select2/select2.min.js\"></script>\n" +
                "    <script src=\"./assets/vendors/typeahead.js/typeahead.bundle.min.js\"></script>\n" +
                "    <script src=\"./assets/js/off-canvas.js\"></script>\n" +
                "    <script src=\"./assets/js/hoverable-collapse.js\"></script>\n" +
                "    <script src=\"./assets/js/misc.js\"></script>\n" +
                "    <script src=\"./assets/js/file-upload.js\"></script>\n" +
                "    <script src=\"./assets/js/typeahead.js\"></script>\n" +
                "    <script src=\"./assets/js/select2.js\"></script>\n" +
                "</body>\n" +
                "</html>";
    }
}
