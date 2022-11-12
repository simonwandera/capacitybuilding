package com.capacitybuilding.actions.UserActions;

import com.capacitybuilding.controllers.UserBeanI;
import com.capacitybuilding.model.User;
import com.capacitybuilding.model.Usertype;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
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

        if(req.getParameter("gender").equals("--Select Gender--")) {
            servletContext.setAttribute("updateError", "Select a valid gender");
            res.sendRedirect("./admin/updateUser.jsp");
        }
        
        try {
            BeanUtils.populate(user, req.getParameterMap());
            user.setId(Long.valueOf(req.getParameter("id")));
            user.setUserType(Usertype.valueOf(req.getParameter("userType")));
        }catch (Exception ex){
            servletContext.setAttribute("updateError" , ex.getMessage());
            res.sendRedirect("./admin/updateUser.jsp");
        }

        try {
            userBean.update(user);
            res.sendRedirect("./admin/users.jsp");
        } catch (Exception ex) {
            servletContext.setAttribute("updateError" , ex.getMessage());
            res.sendRedirect("./admin/updateUsers.jsp");
        }
    }
}
