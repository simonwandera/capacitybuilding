package com.capacitybuilding.auth.action;

import com.capacitybuilding.mail.bean.MailBeanI;
import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.user.model.Usertype;
import org.apache.commons.codec.digest.DigestUtils;

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

@WebServlet(urlPatterns = "/login")
public class LoginAction extends HttpServlet {

    @EJB
    UserBeanI userBean;

    private ServletContext servletContext;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.getSession().invalidate();
        res.sendRedirect("./auth/login.jsp");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String password = req.getParameter("password");
        String username = req.getParameter("username");

        User user1 = new User();
        user1.setPassword(DigestUtils.md5Hex(password));
        user1.setUsername(username);

        try {
            User user = userBean.login(user1);
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userType", user.getUserType());
            session.setAttribute("activeUser", user);

            if (user.getUserType() == Usertype.ADMIN)
                res.sendRedirect("./main/adminDashboard.jsp");
            else if (user.getUserType() == Usertype.USER)
                res.sendRedirect("./main/traineeDashboard.jsp");
            else if (user.getUserType() == Usertype.TRAINER)
                res.sendRedirect("./main/trainerDashboard.jsp");

        } catch (Exception ex) {
            servletContext.setAttribute("loginError" , ex.getMessage());
            res.sendRedirect("./auth/login.jsp");
        }


    }
}
