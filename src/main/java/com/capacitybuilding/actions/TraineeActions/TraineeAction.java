package com.capacitybuilding.actions.TraineeActions;

import com.capacitybuilding.actions.Common;
import com.capacitybuilding.model.Trainee;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addTrainee")
public class TraineeAction extends HttpServlet {
    private List<Trainee> trainees;

    ServletContext servletContext = getServletConfig().getServletContext();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        res.getWriter().print(this.addTrainee(null, email));
    }

    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter wr = res.getWriter();
        Trainee trainee = new Trainee();
        String email = (String) session.getAttribute("email");

        try {
            BeanUtils.populate(trainee, req.getParameterMap());

        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        if (StringUtils.isBlank(trainee.getEmail())) {
            wr.print(this.addTrainee("Email is required<br/>", email));
            return;
        }

        if (StringUtils.isBlank(trainee.getLastName())) {
            wr.print(this.addTrainee("Last name is required<br/>", email));
            return;
        }

        if (StringUtils.isBlank(trainee.getGender())) {
            wr.print(this.addTrainee("Gender No is required<br/>", email));
            return;
        }

        trainees = (List<Trainee>) session.getAttribute("trainees");

        if (trainees == null)
            trainees = new ArrayList<>();

        trainees.add(trainee);
        session.setAttribute("trainees", trainees);

        RequestDispatcher dispatcher = req.getRequestDispatcher("./trainees");
        dispatcher.forward(req, res);

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
                "                        <h3 class=\"mb-0\"> Trainee Registration </h3>\n" +
                "                        <div class=\"d-flex\">\n" +
                "                            <a class=\"btn btn-sm ml-3 btn-success\" href=\"./trainees\"> All Trainees </a>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "               \n" +
                "                <div class=\"col-md-6 grid-margin stretch-card mx-auto my-3\">\n" +
                "                    <div class=\"card\">\n" +
                "                      <div class=\"card-body\">\n" +
                "                        <h4 class=\"card-title\">New Trainee</h4>\n" +
                "                        <p class=\"card-description\">Basic form layout</p>\n" +
                "                        <form class=\"forms-sample\" method=\"POST\"> \n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputUsername1\">First name</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"firstName\" id=\"exampleInputUsername1\" placeholder=\"John\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputEmail1\">Last Name</label>\n" +
                "                            <input type=\"text\" class=\"form-control\" name=\"lastName\" id=\"exampleInputEmail1\" placeholder=\"Doe\" />\n" +
                "                          </div>\n" +
                "\n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputEmail1\">Email</label>\n" +
                "                            <input type=\"email\" class=\"form-control\" name=\"email\" id=\"exampleInputEmail1\" placeholder=\"johndoe@example.com\" />\n" +
                "                          </div>\n" +
                "\n" +
                "                          <div class=\"form-group\">\n" +
                "                            <label for=\"exampleInputPassword1\">Gender</label>\n" +
                "                            <select class=\"form-control\" name=\"gender\" id=\"exampleSelectGender\">\n" +
                "                                <option>Male</option>\n" +
                "                                <option>Female</option>\n" +
                "                                <option>Other</option>\n" +
                "                            </select>\n" +
                "                          </div>\n" +
                "                          <div class=\"py-1 text-center\">\n" +
                "                               <span class=\"text-danger \">" + (actionError != null? actionError : "") + "</span>\n" +
                "                          </div>\n" +
                "                          <button type=\"submit\" class=\"btn btn-primary mr-2\"> Submit </button>\n" +
                "                        </form>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "    </div>" +
                Common.Footer();
    }
}
