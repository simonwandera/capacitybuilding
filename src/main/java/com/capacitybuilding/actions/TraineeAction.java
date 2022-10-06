package com.capacitybuilding.actions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trainees")
public class TraineeAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.getWriter().print(this.addTrainee(null));
    }

    public String addTrainee(String actionError){
        return "<!DOCTYPE html>"
                + "<html> "
                + "<head> "
                + "</head>"
                + "<body>"
                + "<h1>" + getServletContext().getAttribute("applicationLabel") + "</h1>"
                + "<h2> User Login</h2>"
                + "<form action=\"./student\" method=\"post\">"
                + "<table> "
                + "<tr> <td> Student Name: </td> <td> <input type=\"text\" name=\"name\"> </td> </tr> "
                + "<tr> <td> Student Reg No: </td> <td> <input type=\"text\" name=\"regNo\"> </td> </tr> "
                + "<tr> <td> <input type=\"submit\" value=\"Submit\"></tr> "
                + "</table>"
                + "</form>"
                + "<span style=\"color:red\">" + (actionError != null? actionError : "") + "</span><br/>"
                + "Home? <a href='./home'>Register</a><br/>"
                + "</body>"
                + "</html>";
    }
}
