package com.sys.capacitybuilding;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Auth extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("action");
        PrintWriter wr = res.getWriter();
        wr.print(this.auth());
    }

    private String auth(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Capacity building</title>\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/css/style.css\">\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<h2>Welcome to capacity buiding system</h2>\n" +
                "<div class=\"container\" id=\"container\">\n" +
                "\t<div class=\"form-container sign-up-container\">\n" +
                "\t\t<form action=\"#\">\n" +
                "\t\t\t<h1>Create Account</h1>\n" +
                "\t\t\t<div class=\"social-container\">\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<span>or use your email for registration</span>\n" +
                "\t\t\t<input type=\"text\" placeholder=\"Name\" />\n" +
                "\t\t\t<input type=\"email\" placeholder=\"Email\" />\n" +
                "\t\t\t<input type=\"password\" placeholder=\"Password\" />\n" +
                "\t\t\t<button>Sign Up</button>\n" +
                "\t\t</form>\n" +
                "\t</div>\n" +
                "\t<div class=\"form-container sign-in-container\">\n" +
                "\t\t<form action=\"#\">\n" +
                "\t\t\t<h1>Sign in</h1>\n" +
                "\t\t\t<div class=\"social-container\">\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-facebook-f\"></i></a>\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-google-plus-g\"></i></a>\n" +
                "\t\t\t\t<a href=\"#\" class=\"social\"><i class=\"fab fa-linkedin-in\"></i></a>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<span>or use your account</span>\n" +
                "\t\t\t<input type=\"email\" placeholder=\"Email\" />\n" +
                "\t\t\t<input type=\"password\" placeholder=\"Password\" />\n" +
                "\t\t\t<a href=\"#\">Forgot your password?</a>\n" +
                "\t\t\t<button>Sign In</button>\n" +
                "\t\t</form>\n" +
                "\t</div>\n" +
                "\t<div class=\"overlay-container\">\n" +
                "\t\t<div class=\"overlay\">\n" +
                "\t\t\t<div class=\"overlay-panel overlay-left\">\n" +
                "\t\t\t\t<h1>Welcome Back!</h1>\n" +
                "\t\t\t\t<p>To keep connected with us, login and track your training</p>\n" +
                "\t\t\t\t<button class=\"ghost\" id=\"signIn\">Sign In</button>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div class=\"overlay-panel overlay-right\">\n" +
                "\t\t\t\t<h1>Hello, Friend!</h1>\n" +
                "\t\t\t\t<p>Enter your personal details and start the empowerment journey with us</p>\n" +
                "\t\t\t\t<button class=\"ghost\" id=\"signUp\" name=\"signUp\">Sign Up</button>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "\n" +
                "<footer>\n" +
                "\t<p>\n" +
                "        Like a battery, the human mind and body must be fully discharged to stretch their capacity.\n" +
                "    </p>\n" +
                "</footer>\n" +
                "\n" +
                "<script type=\"text/javascript\" src=\"./assets/js/index.js\"></script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
