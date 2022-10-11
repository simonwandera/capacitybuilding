package com.capacitybuilding.actions;

import com.capacitybuilding.model.Trainee;

import javax.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = "/login", initParams = {
        @WebInitParam(name = "email", value = "simon@skytrix.com"),
        @WebInitParam(name = "password", value = "password")
})
public class LoginAction extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.login(null));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");

        if (email == null || email.equalsIgnoreCase("")){
            wr.print(this.login("Email is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.login("Password is required<br/>"));
            return;
        }

        if (!email.equals(getServletConfig().getInitParameter("username")) && !password.equals(getServletConfig().getInitParameter("password"))) {
            wr.print(this.login("Invalid username & password combination<br/>"));
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("email", email);

        List<Trainee> trainees  = new ArrayList<>();
        session.setAttribute("trainees", trainees);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("./home");
        requestDispatcher.forward(req, res);
    }


    public String login(String actionError){
        return Common.Header() +
                "<body>\n" +
                "  <div class=\"container-scroller\">\n" +
                "    <div class=\"container-fluid page-body-wrapper\">\n" +
                "      <div class=\"main-panel\">\n" +
                "        <div class=\"content-wrapper\">\n" +
                "          <div class=\"page-header\">\n" +
                "            <h3 class=\"page-title m-auto\">" +getServletContext().getAttribute("appName")+ "</h3>\n" +
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
                Common.Footer();
    }
}
