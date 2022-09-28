package com.sys.capacitybuilding;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Index implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");


        PrintWriter pw = res.getWriter();
        pw.print("<html>");
        pw.print("<head>");
        pw.print("<title>HTML 5 Boilerplate</title>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<p>Do me a favour and please compile </p>");
        pw.print("</body>");
        pw.print("</html>");

    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
