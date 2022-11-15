package com.capacitybuilding.user.action;

import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    ServletContext servletContext;

    @EJB
    UserBeanI userBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        User user = new User();
        String usrId = req.getParameter("id");

        if(req.getParameter("gender").equals("--Select gender--")) {
            servletContext.setAttribute("updateError", "Select a valid gender");
            res.sendRedirect("./admin/updateUser.jsp?id="+usrId);
            return;
        }

        try {
            BeanUtils.populate(user, req.getParameterMap());
            user.setId(Long.valueOf(usrId));
        }catch (Exception ex){
            servletContext.setAttribute("updateError" , ex.getMessage());
            res.sendRedirect("./admin/updateUser.jsp?id="+usrId);
        }

        try {
            userBean.update(user);
            res.sendRedirect("./admin/users.jsp");
        } catch (Exception ex) {
            servletContext.setAttribute("updateError" , ex.getMessage());
            res.sendRedirect("./admin/updateUser.jsp?id="+usrId);
        }
    }
}
