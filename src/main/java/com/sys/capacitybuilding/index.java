package com.sys.capacitybuilding;

import javax.servlet.*;
import java.io.IOException;

public class index implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
