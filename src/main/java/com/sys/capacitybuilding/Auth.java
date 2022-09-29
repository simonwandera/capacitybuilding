package com.sys.capacitybuilding;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Auth extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("action");
        PrintWriter wr = res.getWriter();
        wr.print(this.home());
    }

    public String home(){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "<h1> Welcome to Capacity Building system</h1>"
                + "</head>"
                + "<body>"
                + " To Register <a href='./welcome?action=register'>Register</a><br/>"
                + " To Loging <a href='./welcome?action=login'>Login</a><br/>"
                + "</body>"
                + "</html>";
    }
}
