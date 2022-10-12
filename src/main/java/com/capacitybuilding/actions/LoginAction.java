package com.capacitybuilding.actions;

import com.capacitybuilding.Service.IMySQLDB;
import com.capacitybuilding.Service.MySQLDB;
import com.capacitybuilding.model.Login;
import com.mysql.cj.log.Log;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    ServletContext servletContext;
    Connection connection;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
        connection = (Connection) servletContext.getAttribute("dbConnection");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.loginPage(null));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter wr = res.getWriter();
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (email == null || email.equalsIgnoreCase("")){
            wr.print(this.loginPage("Email is required<br/>"));
            return;
        }

        if (password == null || password.equalsIgnoreCase("")) {
            wr.print(this.loginPage("Password is required<br/>"));
            return;
        }

        Map<String, String> criteria = new HashMap<>(){{
            put("Username", email);
            put("Password", DigestUtils.md5Hex(password));
        }};;

        Login login = this.login(criteria);

        if (login == null || login.getId() < 1) {
            wr.print(this.loginPage("Invalid username & password combination<br/>"));
            return;
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("username", login.getUsername());
        session.setAttribute("userType", login.getUserType());

        RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        dispatcher.forward(req, res);
    }

    public Login login(Map<String, String> criteria) {

        Login login = new Login();

        try {

            IMySQLDB<Login, Connection> loginMysqlDb = new MySQLDB<>(login, connection);

            String queryStatement = loginMysqlDb.createSelectWithWhereClauseQuery(criteria);
            ResultSet resultSet = loginMysqlDb.executeReadQuery(queryStatement);

            while (resultSet.next()) {
                login = new Login();
                login.setId(resultSet.getInt("id"));
                login.setUsername(resultSet.getString("userName"));
                login.setUserType(resultSet.getString("userType"));
            }

        }catch (Exception ex) {
            System.out.println("Log In Error: " + ex.getMessage());
        }

        return login;

    }


    public String loginPage(String actionError){
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
