package com.capacitybuilding.training.action;

import com.capacitybuilding.training.bean.TrainingBeanI;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.TrainingStatus;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addTraining")
public class CreateTraining extends HttpServlet {
    ServletContext servletContext;

    @EJB
    TrainingBeanI trainingBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        res.sendRedirect("./training/createTrainee.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String id = req.getParameter("id");
        String status = req.getParameter("status");
        String title = req.getParameter("title");
        int duration = req.getParameter("duration").isEmpty() ? 0 : Integer.parseInt(req.getParameter("duration"));
        LocalDate startDate = req.getParameter("startDate").isEmpty() ? LocalDate.of(0, 1, 1) : LocalDate.parse(req.getParameter("startDate"));
        String description = req.getParameter("description");

        Training training = new Training();

        if (!StringUtils.isBlank(id)) {
            training.setId(Long.valueOf(id));
            training.setStatus(TrainingStatus.valueOf(status));
        }else {
            training.setStatus(TrainingStatus.ONGOING);
        }

        training.setTitle(title);
        training.setTimeCreated(LocalDate.now());
        training.setDuration(duration);
        training.setStartDate(startDate);
        training.setDescription(description);

        try {
            trainingBean.add(training);
            res.sendRedirect("./training/e.jsp");
        } catch (Exception ex) {
            servletContext.setAttribute("trainingError" , ex.getMessage());
            res.sendRedirect("./training/addTraining.jsp");
        }
    }
 }
