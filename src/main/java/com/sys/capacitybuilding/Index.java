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

        pw.print("<html lang=\"en\">");
        pw.print("<head>");
        pw.print("<meta charset=\"UTF-8\">");
        pw.print("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        pw.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        pw.print("<title>Document</title>");
        pw.print("<link rel=\"stylesheet\" href=\"style.css\">");
        pw.print("</head>");


        pw.print("<head>");
        pw.print("<title>Capacity building System</title>");
        pw.print("<link rel=\"stylesheet\" href=\"style.css\">");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<p>Do me a favour and please compile please</p>");
        pw.print("</body>");
        pw.print("</html>");

    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
