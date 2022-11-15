package com.capacitybuilding.user.action;

import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.user.model.Usertype;
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

@WebServlet("changeUsertype")
public class ChangeUsertype extends HttpServlet {

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
        String userType = req.getParameter("userType");

        try {
            user.setId(Long.valueOf(usrId));
            user.setUserType(Usertype.valueOf(userType));
        }catch (Exception ex){
            servletContext.setAttribute("updateError" , ex.getMessage());
            res.sendRedirect("./admin/updateUser.jsp?id="+usrId);
        }

        try {
            userBean.changeUserType(user);
        } catch (Exception ex) {
            servletContext.setAttribute("updateError" , ex.getMessage());
        }finally {
            res.sendRedirect("./admin/users.jsp");
        }
    }
}
