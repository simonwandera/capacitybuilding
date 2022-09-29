package com.sys.capacitybuilding;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class Index extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Hello here");
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
        pw.print("<link rel=\"stylesheet\" href=\"./assets/css/style.css\">");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<h2>Welcome to Capacity Building System</h2>");
        pw.print("<div class=\"container\" id=\"container\">");
        pw.print("<div class=\"form-container sign-up-container\">");
        pw.print("<form action=\"#\">");
        pw.print("<h1>Create Account</h1>");
        pw.print("<div class=\"social-container\">");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>");
        pw.print("</div>");
        pw.print("<span>or use your email for registration</span>");
        pw.print("<input type=\"text\" placeholder=\"Name\" />");
        pw.print("<input type=\"email\" placeholder=\"Email\" />");
        pw.print("<input type=\"password\" placeholder=\"Password\" />");
        pw.print("<button>Sign Up</button>");
        pw.print("</form>");
        pw.print("</div>");
        pw.print("<div class=\"form-container sign-in-container\">");
        pw.print("<form action=\"#\">");
        pw.print("<h1>Sign in</h1>");
        pw.print("<div class=\"social-container\">");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>");
        pw.print("<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>");
        pw.print("</div>");
        pw.print("<span>or use your account</span>");
        pw.print("<input type=\"email\" placeholder=\"Email\" />");
        pw.print("<input type=\"password\" placeholder=\"Password\" />");
        pw.print("<a href=\"#\">Forgot your password?</a>");
        pw.print("<button>Sign In</button>");
        pw.print("</form>");
        pw.print("</div>");
        pw.print("<div class=\"overlay-container\">");
        pw.print("<div class=\"overlay\">");
        pw.print("<div class=\"overlay-panel overlay-left\">");
        pw.print("<h1>Welcome Back!</h1>");
        pw.print("<p>To keep connected with us, login and track your training</p>");
        pw.print("<button class=\"ghost\" id=\"signIn\">Sign In</button>");
        pw.print("</div>");
        pw.print("<div class=\"overlay-panel overlay-right\">");
        pw.print("<h1>Hello, Friend!</h1>");
        pw.print("<p>Enter your personal details and start the empowerment journey with us</p>");
        pw.print("<button class=\"ghost\" id=\"signUp\" name=\"signUp\">Sign Up</button>");
        pw.print("</div>");
        pw.print("</div>");
        pw.print("</div>");
        pw.print("</div>");
        pw.print("<footer>");
        pw.print("<p> Like a battery, the human mind and body must be fully discharged to stretch their capacity. </p>");
        pw.print("</footer>");
        pw.print("<script src=\"./assets/js/index.js\"></script>");
        pw.print("</body>");
        pw.print("</html>");

    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
