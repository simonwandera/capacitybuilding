package com.capacitybuilding.actions;

import com.capacitybuilding.model.Trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/deleteTrainee")
public class DeleteTrainee extends HttpServlet {

    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("Deleting trainee  >> " + req.getParameter("id"));

        HttpSession session = req.getSession();
        List<Trainee> trainees = (List<Trainee>) session.getAttribute("trainees");
        res.sendRedirect("./trainees");
    }
}
