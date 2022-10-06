package com.capacitybuilding.actions;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.login(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
        String action = req.getParameter("action");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");

        String actionError = "";

        System.out.println("\n\n");
        System.out.println("Action:" + action);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        if (email == null || email.equalsIgnoreCase("")){
            wr.print(this.login("Email is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("Password is required<br/>"));
            return;
        }

        if (password != null && !password.equals("password")){
            wr.print(this.login("Incorrect password<br/>"));
            return;
        }

        HttpSession session = req.getSession(true);

        List<String> studentNames  = new ArrayList<String>();
        studentNames.add("Bonnie");
        studentNames.add("Simon");
        studentNames.add("James");
        studentNames.add("Mercy");
        studentNames.add("George");

        session.setAttribute("students", studentNames);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("./home");
        requestDispatcher.forward(req, res);
    }


    public String login(String actionError){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\" />\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "  <title>Login</title>\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/mdi/css/materialdesignicons.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/flag-icon-css/css/flag-icon.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/css/vendor.bundle.base.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/select2/select2.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/css/style.css\" />\n" +
                "  <link rel=\"shortcut icon\" href=\"./assets/images/favicon.png\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"container-scroller\">\n" +
                "    <div class=\"container-fluid page-body-wrapper\">\n" +
                "      <div class=\"main-panel\">\n" +
                "        <div class=\"content-wrapper\">\n" +
                "          <div class=\"page-header\">\n" +
                "            <h3 class=\"page-title m-auto\">" +getServletContext().getInitParameter("appName")+ "</h3>\n" +
                "          </div>\n" +
                "          <div class=\"row\">\n" +
                "            <div class=\"col-md-6 grid-margin stretch-card m-auto\">\n" +
                "              <div class=\"card\">\n" +
                "                <div class=\"card-body\">\n" +
                "                  <div class=\"mb-5\">\n" +
                "                    <h4 class=\"card-title\">LogIn</h4>\n" +
                "                  </div>\n" +
                "                  <form action=\"./login\" class=\"forms-sample\" method=\"post\">\n" +
                "                    <div class=\"form-group\">\n" +
                "                      <label for=\"exampleInputEmail1\">Email address</label>\n" +
                "                      <input type=\"email\" class=\"form-control\" name=\"email\" id=\"exampleInputEmail1\" placeholder=\"Email\" />\n" +
                "                    </div>\n" +
                "                    <div class=\"form-group\">\n" +
                "                      <label for=\"exampleInputPassword1\">Password</label>\n" +
                "                      <input type=\"password\" class=\"form-control\" name=\"password\" id=\"exampleInputPassword1\" placeholder=\"Password\" />\n" +
                "                    </div>\n" +
                "                    <div class=\"form-check form-check-flat form-check-primary\">\n" +
                "                      <label class=\"form-check-label\">\n" +
                "                        <input type=\"checkbox\" class=\"form-check-input\" /> Remember me </label>\n" +
                "                    </div>\n" +
                "                    <div class=\"my-3 py-2 text-center\">\n" +
                "                      <span class=\"text-danger \">" + (actionError != null? actionError : "") + "</span>\n" +
                "                    </div>\n" +
                "                    <button type=\"submit\" class=\"btn btn-primary mr-2\"> Login </button>\n" +
                "                    <a href=\"./register\">Register</a>\n"+
                "                  </form>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <script src=\"./assets/vendors/js/vendor.bundle.base.js\"></script>\n" +
                "  <script src=\"./assets/vendors/select2/select2.min.js\"></script>\n" +
                "  <script src=\"./assets/vendors/typeahead.js/typeahead.bundle.min.js\"></script>\n" +
                "  <script src=\"./assets/js/off-canvas.js\"></script>\n" +
                "  <script src=\"./assets/js/hoverable-collapse.js\"></script>\n" +
                "  <script src=\"./assets/js/misc.js\"></script>\n" +
                "  <script src=\"./assets/js/file-upload.js\"></script>\n" +
                "  <script src=\"./assets/js/typeahead.js\"></script>\n" +
                "  <script src=\"./assets/js/select2.js\"></script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
