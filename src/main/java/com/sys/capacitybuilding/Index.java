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
//        pw.print("<link rel=\"stylesheet\" href=\"../../../webapp/WEB-INF/assets/css/style.css\">");

         pw.print("<style>");
        pw.print("@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');");

pw.print("* {box-sizing: border-box;}");

        pw.print("body {");
            pw.print("background: #f6f5f7;");
            pw.print("display: flex;");
            pw.print("justify-content: center;");
            pw.print("align-items: center;");
            pw.print("flex-direction: column;");
            pw.print("font-family: 'Montserrat', sans-serif;");
            pw.print("height: 100vh;");
            pw.print("margin: -20px 0 50px;");
        pw.print("}");

        pw.print("h1 {");
            pw.print("font-weight: bold;");
            pw.print("margin: 0;");
        pw.print("}");

        pw.print("h2 {");
            pw.print("text-align: center;");
        pw.print("}");

        pw.print("p {");
            pw.print("font-size: 14px;");
            pw.print("font-weight: 100;");
            pw.print("line-height: 20px;");
            pw.print("letter-spacing: 0.5px;");
            pw.print("margin: 20px 0 30px;");
        pw.print("}");

        pw.print("span {");
            pw.print("font-size: 12px;");
        pw.print("}");

        pw.print("a {");
           pw.print("color: #333;");
            pw.print("font-size: 14px;");
            pw.print("text-decoration: none;");
            pw.print("margin: 15px 0;");
        pw.print("}");

        pw.print("button {");
            pw.print("border-radius: 20px;");
           pw.print("border: 1px solid #FF4B2B;");
            pw.print("background-color: #FF4B2B;");
           pw.print("color: #FFFFFF;");
            pw.print("font-size: 12px;");
            pw.print("font-weight: bold;");
            pw.print("padding: 12px 45px;");
            pw.print("letter-spacing: 1px;");
            pw.print("text-transform: uppercase;");
            pw.print("transition: transform 80ms ease-in;");
        pw.print("}");

        pw.print("button:active {");
            pw.print("transform: scale(0.95);");
        pw.print("}");

        pw.print("button:focus {");
            pw.print("outline: none;");
        pw.print("}");

        pw.print("button.ghost {");
            pw.print("background-color: transparent;");
            pw.print("border-color: #FFFFFF;");
        pw.print("}");

        pw.print("form {");
            pw.print("background-color: #FFFFFF;");
            pw.print("display: flex;");
            pw.print("align-items: center;");
            pw.print("justify-content: center;");
            pw.print("flex-direction: column;");
            pw.print("padding: 0 50px;");
            pw.print("height: 100%;");
            pw.print("text-align: center;");
        pw.print("}");

        pw.print("input {");
            pw.print("background-color: #eee;");
            pw.print("border: none;");
            pw.print("padding: 12px 15px;");
            pw.print("margin: 8px 0;");
            pw.print("width: 100%;");
        pw.print("}");

pw.print(".container {");
            pw.print("background-color: #fff;");
            pw.print("border-radius: 10px;");
            pw.print("box-shadow: 0 14px 28px rgba(0,0,0,0.25),");
            pw.print("0 10px 10px rgba(0,0,0,0.22);");
            pw.print("position: relative;");
            pw.print("overflow: hidden;");
            pw.print("width: 768px;");
            pw.print("max-width: 100%;");
            pw.print("min-height: 480px;");
        pw.print("}");

pw.print(".form-container {");
            pw.print("position: absolute;");
            pw.print("top: 0;");
            pw.print("height: 100%;");
            pw.print("transition: all 0.6s ease-in-out;");
        pw.print("}");

pw.print(".sign-in-container {");
            pw.print("left: 0;");
            pw.print("width: 50%;");
            pw.print("z-index: 2;");
        pw.print("}");

pw.print(".container.right-panel-active .sign-in-container {");
            pw.print("transform: translateX(100%);");
        pw.print("}");

pw.print(".sign-up-container {");
            pw.print("left: 0;");
            pw.print("width: 50%;");
            pw.print("opacity: 0;");
            pw.print("z-index: 1;");
        pw.print("}");

pw.print(".container.right-panel-active .sign-up-container {");
            pw.print("transform: translateX(100%);");
            pw.print("opacity: 1;");
            pw.print("z-index: 5;");
            pw.print("animation: show 0.6s;");
        pw.print("}");

        pw.print("@keyframes show {");
            pw.print("0%, 49.99% {");
                    pw.print("opacity: 0;");
            pw.print("z-index: 1;");
	pw.print("}");

            pw.print("50%, 100% {");
                    pw.print("opacity: 1;");
            pw.print("z-index: 5;");
	pw.print("}");
        pw.print("}");

pw.print(".overlay-container {");
            pw.print("position: absolute;");
            pw.print("top: 0;");
            pw.print("left: 50%;");
            pw.print("width: 50%;");
            pw.print("height: 100%;");
            pw.print("overflow: hidden;");
            pw.print("transition: transform 0.6s ease-in-out;");
            pw.print("z-index: 100;");
        pw.print("}");

pw.print(".container.right-panel-active .overlay-container{");
            pw.print("transform: translateX(-100%);");
        pw.print("}");

pw.print(".overlay {");
            pw.print("background: #FF416C;");
            pw.print("background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C);");
            pw.print("background: linear-gradient(to right, #FF4B2B, #FF416C);");
            pw.print("background-repeat: no-repeat;");
            pw.print("background-size: cover;");
            pw.print("background-position: 0 0;");
            pw.print("color: #FFFFFF;");
            pw.print("position: relative;");
            pw.print("left: -100%;");
            pw.print("height: 100%;");
            pw.print("width: 200%;");
            pw.print("transform: translateX(0);");
            pw.print("transition: transform 0.6s ease-in-out;");
        pw.print("}");

pw.print(".container.right-panel-active .overlay {");
            pw.print("transform: translateX(50%);");
        pw.print("}");

pw.print(".overlay-panel {");
            pw.print("position: absolute;");
            pw.print("display: flex;");
            pw.print("align-items: center;");
            pw.print("justify-content: center;");
            pw.print("flex-direction: column;");
            pw.print("padding: 0 40px;");
            pw.print("text-align: center;");
            pw.print("top: 0;");
            pw.print("height: 100%;");
            pw.print("width: 50%;");
            pw.print("transform: translateX(0);");
            pw.print("transition: transform 0.6s ease-in-out;");
        pw.print("})");

        pw.print(".overlay-left {)");
            pw.print("transform: translateX(-20%);)");
        pw.print("})");
pw.print(")");
pw.print(".container.right-panel-active .overlay-left {)");
            pw.print("transform: translateX(0);)");
        pw.print("})");
pw.print(")");
pw.print(".overlay-right {)");
            pw.print("right: 0;)");
            pw.print("transform: translateX(0);)");
        pw.print("})");
pw.print(")");
pw.print(".container.right-panel-active .overlay-right {)");
            pw.print("transform: translateX(20%);)");
        pw.print("})");
pw.print(")");
pw.print(".social-container {)");
            pw.print("margin: 20px 0;)");
        pw.print("})");

pw.print(".social-container a {");
            pw.print("border: 1px solid #DDDDDD;");
            pw.print("border-radius: 50%;");
            pw.print("display: inline-flex;");
            pw.print("justify-content: center;");
            pw.print("align-items: center;");
            pw.print("margin: 0 5px;");
            pw.print("height: 40px;");
            pw.print("width: 40px;");
        pw.print("}");

        pw.print("footer {");
            pw.print("background-color: #222;");
            pw.print("color: #fff;");
            pw.print("font-size: 14px;");
            pw.print("bottom: 0;");
            pw.print("position: fixed;");
            pw.print("left: 0;");
            pw.print("right: 0;");
            pw.print("text-align: center;");
            pw.print("z-index: 999;");
        pw.print("}");

        pw.print("footer p {");
            pw.print("margin: 10px 0;");
        pw.print("}");

        pw.print("footer i {");
            pw.print("color: red;");
        pw.print("}");

        pw.print("footer a {");
            pw.print("color: #3c97bf;");
            pw.print("text-decoration: none;");
        pw.print("}");
    pw.print("</style>");
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
        pw.print("<script type=\"text/javascript\" src=\"index.js\"></script>");
        pw.print("</body>");
        pw.print("</html>");

    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
