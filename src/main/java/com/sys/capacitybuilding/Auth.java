package com.sys.capacitybuilding;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class Auth extends HttpServlet {
    ServletConfig servletConfig = null;

    public void init(ServletConfig servletConfig) throws ServletException{
        this.servletConfig = servletConfig;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements())
            System.out.println("Headers: " + headers.nextElement());

        System.out.println("Content length: "+ req.getContentLength());
        System.out.println("Get Protocol: "+ req.getProtocol());
        System.out.println("Get scheme: "+ req.getScheme());
        System.out.println("Get serverName: " + req.getServerName());
        System.out.println("Get ServerPort: " + req.getServerPort());
        System.out.println("Get RemoteAddress: " + req.getRemoteAddr());
        System.out.println("Get RemoteHost: " + req.getRemoteHost());
        System.out.println("Get Locale: " + req.getLocale());
        System.out.println("Is secure: " + req.isSecure());
        System.out.println("Get RemotePort: " + req.getRemotePort());
        System.out.println("Get RemotePort: " + req.getRemotePort());
        System.out.println("Get LocalAddr: " + req.getLocalAddr());
        System.out.println("Get LocalPort: " + req.getLocalPort());
        System.out.println("Is AsyncStarted: " + req.isAsyncStarted());
        System.out.println("Is AsyncSupported: " + req.isAsyncSupported());


        String action = req.getParameter("action");
        PrintWriter wr = res.getWriter();
        if (action != null && action.equalsIgnoreCase("login"))
            wr.print(this.login(null));
        else if (action != null && action.equalsIgnoreCase("signUp")) {
            wr.print(this.signUp(null));
        } else
            wr.print(this.home(servletConfig.getServletContext().getInitParameter("appName")));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Map<String, String[]> paramsInMap = req.getParameterMap();
        for (Map.Entry<String, String[]> map : paramsInMap.entrySet()) {
            if (map.getValue() != null && map.getValue().length > 0)
                System.out.println(map.getKey() + " ============= " + map.getValue()[0]);
        }

        System.out.println("Character Encoding: "+ req.getCharacterEncoding());
        System.out.println("Content length: "+ req.getContentLength());

        Enumeration<String> parameterName = req.getParameterNames();
        while (parameterName.hasMoreElements()){
            System.out.println("\t\t" + req.getParameter(parameterName.nextElement()));
        }


        PrintWriter wr = res.getWriter();
        String action = req.getParameter("action");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");

        boolean register = action != null && action.equalsIgnoreCase("signup");
        boolean login = action != null && action.equalsIgnoreCase("login");

        String actionError = "";

        if (login){
            System.out.println("\n\n");
            System.out.println("Action:" + action);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "Email is required<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (password != null && !password.equals("password") )
                actionError += "Incorrect password<br/>";

            if(actionError.equals(""))
                wr.print(this.loggedIn(email, servletConfig.getServletContext().getInitParameter("appName")));
            else
                wr.print(this.login(actionError));


        } else if (register) {
            System.out.println("Action:" + action);
            System.out.println("name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Password: "+ password);

            if (email == null || email.equalsIgnoreCase(""))
                actionError = "Please provide an email<br/>";

            if (password == null || password.equalsIgnoreCase(""))
                actionError += "Password is required<br/>";

            if (password == null || password.length() < 5)
                actionError += "Password must be more than 5 characters<br/>";

            if (name == null || name.equalsIgnoreCase(""))
                actionError += "Name is required<br/>";

            if (actionError.equals(""))
                wr.print(this.home(servletConfig.getInitParameter("appName")));
            else
                wr.print(this.signUp(actionError));

        }

    }

    private String login(String actionError){
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
                "<h2>Welcome to capacity building system</h2>\n" +
                "<div class=\"container \" id=\"container\">\n" +
                "\t<div class=\"form-container sign-in-container\">\n" +
                "\t\t<form action=\"./auth\" method=\"post\">" +
                "\t\t\t<h1>Sign in</h1>\n" +
                "\t\t\t<div class=\"social-container\">\n" +
                "\t\t\t<span class=\"errorMessage\">"+ (actionError != null? actionError : "") +"</span>"+
                "\t\t\t</div>\n" +
                "\t\t\t<input type=\"hidden\" name=\"action\" value=\"login\">\n" +
                "\t\t\t<input type=\"email\" name=\"email\" placeholder=\"Email\" />\n" +
                "\t\t\t<input type=\"password\" name=\"password\" placeholder=\"Password\" />\n" +
                "\t\t\t<a href=\"#\">Forgot your password?</a>\n" +
                "\t\t\t<button>Sign In</button>\n" +
                "\t\t</form>\n" +
                "\t</div>\n" +
                "\t<div class=\"overlay-container\">\n" +
                "\t\t<div class=\"overlay\">\n" +
                "\t\t\t<div class=\"overlay-panel overlay-right\">\n" +
                "\t\t\t\t<h1>Hello, Friend!</h1>\n" +
                "\t\t\t\t<p>Please log in and enroll to one of the available trainings</p>\n" +
                "\t\t\t\t<a href=\"auth?action=signup\"><button class=\"ghost\" id=\"signUp\" name=\"signUp\">Sign Up</button></a>" +
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

    private String signUp(String actionError){
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
                "<div class=\"container right-panel-active\" id=\"container\">\n" +
                "\t<div class=\"form-container sign-up-container\">\n" +
                "\t\t<form action=\"./auth\" method=\"post\">" +
                "\t\t\t<h1>Create Account</h1>\n" +
                "\t\t\t<div class=\"social-container\">\n" +
                "\t\t\t<span class=\"errorMessage\">"+ (actionError != null? actionError : "") +"</span>"+
                "\t\t\t</div>\n" +
                "\t\t\t<input type=\"hidden\" name=\"action\" value=\"signup\">\n" +
                "\t\t\t<input type=\"text\" name=\"name\" placeholder=\"Name\" />\n" +
                "\t\t\t<input type=\"email\" name=\"email\" placeholder=\"Email\" />\n" +
                "\t\t\t<input type=\"password\" name=\"password\" placeholder=\"Password\" />\n" +
                "\t\t\t<button>Sign Up</button>\n" +
                "\t\t</form>\n" +
                "\t</div>\n" +
                "\t<div class=\"overlay-container\">\n" +
                "\t\t<div class=\"overlay\">\n" +
                "\t\t\t<div class=\"overlay-panel overlay-left\">\n" +
                "\t\t\t\t<h1>Welcome Back!</h1>\n" +
                "\t\t\t\t<p>To keep connected with us, login and track your training</p>\n" +
                "\t\t\t\t<a href=\"auth?action=login\"><button class=\"ghost\" id=\"signIn\" name=\"signUp\">Login</button></a>" +
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
                "</body>\n" +
                "</html>";
    }

    private String loggedIn(String email, String label){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<title>Capacity building</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins\">\n" +
                "<link rel=\"stylesheet\" href=\"./assets/css/welcome.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<!-- Sidebar/menu -->\n" +
                "<nav class=\"w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding\" style=\"z-index:3;width:300px;font-weight:bold;\" id=\"mySidebar\"><br>\n" +
                "  <a href=\"javascript:void(0)\" onclick=\"w3_close()\" class=\"w3-button w3-hide-large w3-display-topleft\" style=\"width:100%;font-size:22px\">Close Menu</a>\n" +
                "  <div class=\"w3-container\">\n" +
                "    <h5 class=\"w3-padding-64\">"+ email.toLowerCase() + "</h5>\n" +
                "  </div>\n" +
                "  <div class=\"w3-bar-block\">\n" +
                "    <a href=\"#\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Home</a> \n" +
                "    <a href=\"#showcase\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Showcase</a> \n" +
                "    <a href=\"#services\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Services</a> \n" +
                "    <a href=\"#clients\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Clients</a> \n" +
                "    <a href=\"#contact\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Contact</a>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Top menu on small screens -->\n" +
                "<header class=\"w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding\">\n" +
                "  <a href=\"javascript:void(0)\" class=\"w3-button w3-red w3-margin-right\" onclick=\"w3_open()\">☰</a>\n" +
                "  <span>Capacity Building</span>\n" +
                "</header>\n" +
                "\n" +
                "<!-- Overlay effect when opening sidebar on small screens -->\n" +
                "<div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n" +
                "\n" +
                "<!-- !PAGE CONTENT! -->\n" +
                "<div class=\"w3-main\" style=\"margin-left:340px;margin-right:40px\">\n" +
                "\n" +
                "  <!-- Header -->\n" +
                "  <div class=\"w3-container\" style=\"margin-top:80px\" id=\"showcase\">\n" +
                "    <h1 class=\"w3-jumbo\"><b>" + label + "</b></h1>\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Showcase.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Photo grid (modal) -->\n" +
                "  <div class=\"w3-row-padding\">\n" +
                "    <div class=\"w3-half\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/kitchenconcrete.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Concrete meets bricks\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/atrium.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Light, white and tight scandinavian design\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/livingroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"White walls with designer chairs\">\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"w3-half\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/bedroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Windows for the atrium\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/diningroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Bedroom and office in one space\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/livingroom2.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Scandinavian design\">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Modal for full size images on click-->\n" +
                "  <div id=\"modal01\" class=\"w3-modal w3-black\" style=\"padding-top:0\" onclick=\"this.style.display='none'\">\n" +
                "    <span class=\"w3-button w3-black w3-xxlarge w3-display-topright\">×</span>\n" +
                "    <div class=\"w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64\">\n" +
                "      <img id=\"img01\" class=\"w3-image\">\n" +
                "      <p id=\"caption\"></p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Services -->\n" +
                "  <div class=\"w3-container\" id=\"services\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Services.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>Post COVID-19, we all will have to do more, with less. Learn why capacity-building is essential for your nonprofit's health and longevity.</p>\n" +
                "    <h4>Individual Capacity Building</h4>\n" +
                "    <p>Successful implementation begins at the individual level, where capacity building activities increase a worker’s knowledge and skill. An individual who’s been empowered to facilitate change can impact their organization and their community, and they can further work to effect systemic change.</p><br>\n" +
                "\n" +
                "    <h4>Organizational Capacity Building</h4>\n" +
                "    <p>For organizations, capacity building activities may focus on shoring up sustainability, improving governance, supporting collaboration, or strengthening infrastructure. All have a common goal: Strengthening the skills, resources, and abilities that allow an organization and its workers to grow and thrive.</p><br>\n" +
                "\n" +
                "    <h4>Systemic Capacity Building</h4>\n" +
                "    <p>At the systemic level, capacity building can be more complex. With multiple layers and moving parts involved, capacity building activities may focus on policy development, allocation of resources, and political advocacy efforts. Examples may include:</p><br>\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Designers -->\n" +
                "  <div class=\"w3-container\" id=\"clients\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Esteemed Clients.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>What can we Do for you</p>\n" +
                "    <p> \n" +
                "      The Company and its Subsidiaries are in compliance with the terms of each investment advisory Contract with each Client, and each such Contract is in full force and effect with respect to the applicable Client. \n" +
                "      There are no material disputes pending or threatened with any Client or with any former Client. The Company has made available to Parent true and complete copies of all material advisory, sub-advisory and similar agreements with any Clients.\n" +
                "    </p>\n" +
                "    <p><b>Our Clients </b>:</p>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- The Team -->\n" +
                "  <div class=\"w3-row-padding w3-grayscale\">\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://30blackstars.face2faceafrica.com/wp-content/uploads/shawndove-598x700.jpg\" alt=\"John\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Mike Ross</h3>\n" +
                "          <p class=\"w3-opacity\">CEO & Founder</p>\n" +
                "          <p>Mr King went to the Hertie School for a career workshop. I have nothing negative to say. The workshop was extremely interesting and the group of students all participated actively.</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://content.fortune.com/wp-content/uploads/2020/06/GettyImages-490298616.jpg\" alt=\"Jane\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Lesley Mdogo</h3>\n" +
                "          <p class=\"w3-opacity\">Director & Leader</p>\n" +
                "          <p>Clear, in-depth, and customized career advice that can transform your job search in the highly competitive field of international careers. The coaching sessions provide you with instant clarity about strategizing and taking action for the most-awaited outcomes.</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://leadingladiesafrica.org/wp-content/uploads/2019/07/BEE1DDCC-0F80-46E5-92A3-AE260E6CA482.jpeg\" alt=\"Mike\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Jammie James</h3>\n" +
                "          <p class=\"w3-opacity\">Business owner</p>\n" +
                "          <p>Kyle is amazing! He's given me so much insight and clarity in so little time. The trick is to be as specific with your questions as possible, so that the advice he gives you is as tailored as possible. The only thing I regret is not having booked this session earlier!</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Contact -->\n" +
                "  <div class=\"w3-container\" id=\"contact\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Contact.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>Do you want us to empower your team? Fill out the form and fill me in with the details :) We love meeting new people!</p>\n" +
                "    <form action=\"/action_page.php\" target=\"_blank\">\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Name</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Name\" required>\n" +
                "      </div>\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Email</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Email\" required>\n" +
                "      </div>\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Message</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Message\" required>\n" +
                "      </div>\n" +
                "      <button type=\"submit\" class=\"w3-button w3-block w3-padding-large w3-red w3-margin-bottom\">Send Message</button>\n" +
                "    </form>  \n" +
                "  </div>\n" +
                "\n" +
                "<!-- End page content -->\n" +
                "</div>\n" +
                "\n" +
                "<!-- W3.CSS Container -->\n" +
                "\n" +
                "<script src=\"./assets/js/welcome.js\">\n" +
                "// Script to open and close sidebar\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    public String home(String label){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<title>Capacity building</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins\">\n" +
                "<link rel=\"stylesheet\" href=\"welcome.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<!-- Sidebar/menu -->\n" +
                "<nav class=\"w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding\" style=\"z-index:3;width:300px;font-weight:bold;\" id=\"mySidebar\"><br>\n" +
                "  <a href=\"javascript:void(0)\" onclick=\"w3_close()\" class=\"w3-button w3-hide-large w3-display-topleft\" style=\"width:100%;font-size:22px\">Close Menu</a>\n" +

                "  <div class=\"w3-container\">\n" +
                "     <a href=\"./auth?action=login\" class=\"w3-button w3-block w3-ripple w3-text-black w3-red w3-margin-bottom\"> Login </a>" +
                "  </div>\n" +

                "  <div class=\"w3-bar-block\">\n" +
                "    <a href=\"#\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Home</a> \n" +
                "    <a href=\"#showcase\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Showcase</a> \n" +
                "    <a href=\"#services\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Services</a> \n" +
                "    <a href=\"#clients\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Clients</a> \n" +
                "    <a href=\"#contact\" onclick=\"w3_close()\" class=\"w3-bar-item w3-button w3-hover-white\">Contact</a>\n" +
                "  </div>\n" +
                "</nav>\n" +
                "\n" +
                "<!-- Top menu on small screens -->\n" +
                "<header class=\"w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding\">\n" +
                "  <a href=\"javascript:void(0)\" class=\"w3-button w3-red w3-margin-right\" onclick=\"w3_open()\">☰</a>\n" +
                "  <span>" + label + "</span>\n" +
                "</header>\n" +
                "\n" +
                "<!-- Overlay effect when opening sidebar on small screens -->\n" +
                "<div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>\n" +
                "\n" +
                "<!-- !PAGE CONTENT! -->\n" +
                "<div class=\"w3-main\" style=\"margin-left:340px;margin-right:40px\">\n" +
                "\n" +
                "  <!-- Header -->\n" +
                "  <div class=\"w3-container\" style=\"margin-top:80px\" id=\"showcase\">\n" +
                "    <h1 class=\"w3-jumbo\"><b>" + label + "</b></h1>\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Showcase.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Photo grid (modal) -->\n" +
                "  <div class=\"w3-row-padding\">\n" +
                "    <div class=\"w3-half\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/kitchenconcrete.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Concrete meets bricks\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/atrium.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Light, white and tight scandinavian design\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/livingroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"White walls with designer chairs\">\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"w3-half\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/bedroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Windows for the atrium\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/diningroom.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Bedroom and office in one space\">\n" +
                "      <img src=\"https://www.w3schools.com/w3images/livingroom2.jpg\" style=\"width:100%\" onclick=\"onClick(this)\" alt=\"Scandinavian design\">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Modal for full size images on click-->\n" +
                "  <div id=\"modal01\" class=\"w3-modal w3-black\" style=\"padding-top:0\" onclick=\"this.style.display='none'\">\n" +
                "    <span class=\"w3-button w3-black w3-xxlarge w3-display-topright\">×</span>\n" +
                "    <div class=\"w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64\">\n" +
                "      <img id=\"img01\" class=\"w3-image\">\n" +
                "      <p id=\"caption\"></p>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- Services -->\n" +
                "  <div class=\"w3-container\" id=\"services\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Services.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>Post COVID-19, we all will have to do more, with less. Learn why capacity-building is essential for your nonprofit's health and longevity.</p>\n" +
                "    <h4>Individual Capacity Building</h4>\n" +
                "    <p>Successful implementation begins at the individual level, where capacity building activities increase a worker’s knowledge and skill. An individual who’s been empowered to facilitate change can impact their organization and their community, and they can further work to effect systemic change.</p><br>\n" +
                "\n" +
                "    <h4>Organizational Capacity Building</h4>\n" +
                "    <p>For organizations, capacity building activities may focus on shoring up sustainability, improving governance, supporting collaboration, or strengthening infrastructure. All have a common goal: Strengthening the skills, resources, and abilities that allow an organization and its workers to grow and thrive.</p><br>\n" +
                "\n" +
                "    <h4>Systemic Capacity Building</h4>\n" +
                "    <p>At the systemic level, capacity building can be more complex. With multiple layers and moving parts involved, capacity building activities may focus on policy development, allocation of resources, and political advocacy efforts. Examples may include:</p><br>\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Designers -->\n" +
                "  <div class=\"w3-container\" id=\"clients\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Esteemed Clients.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>What can we Do for you</p>\n" +
                "    <p> \n" +
                "      The Company and its Subsidiaries are in compliance with the terms of each investment advisory Contract with each Client, and each such Contract is in full force and effect with respect to the applicable Client. \n" +
                "      There are no material disputes pending or threatened with any Client or with any former Client. The Company has made available to Parent true and complete copies of all material advisory, sub-advisory and similar agreements with any Clients.\n" +
                "    </p>\n" +
                "    <p><b>Our Clients </b>:</p>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- The Team -->\n" +
                "  <div class=\"w3-row-padding w3-grayscale\">\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://30blackstars.face2faceafrica.com/wp-content/uploads/shawndove-598x700.jpg\" alt=\"John\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Mike Ross</h3>\n" +
                "          <p class=\"w3-opacity\">CEO & Founder</p>\n" +
                "          <p>Mr King went to the Hertie School for a career workshop. I have nothing negative to say. The workshop was extremely interesting and the group of students all participated actively.</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://content.fortune.com/wp-content/uploads/2020/06/GettyImages-490298616.jpg\" alt=\"Jane\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Lesley Mdogo</h3>\n" +
                "          <p class=\"w3-opacity\">Director & Leader</p>\n" +
                "          <p>Clear, in-depth, and customized career advice that can transform your job search in the highly competitive field of international careers. The coaching sessions provide you with instant clarity about strategizing and taking action for the most-awaited outcomes.</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"w3-col m4 w3-margin-bottom\">\n" +
                "      <div class=\"w3-light-grey\">\n" +
                "        <img src=\"https://leadingladiesafrica.org/wp-content/uploads/2019/07/BEE1DDCC-0F80-46E5-92A3-AE260E6CA482.jpeg\" alt=\"Mike\" style=\"width:100%\">\n" +
                "        <div class=\"w3-container\">\n" +
                "          <h3>Jammie James</h3>\n" +
                "          <p class=\"w3-opacity\">Business owner</p>\n" +
                "          <p>Kyle is amazing! He's given me so much insight and clarity in so little time. The trick is to be as specific with your questions as possible, so that the advice he gives you is as tailored as possible. The only thing I regret is not having booked this session earlier!</p>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  \n" +
                "  <!-- Contact -->\n" +
                "  <div class=\"w3-container\" id=\"contact\" style=\"margin-top:75px\">\n" +
                "    <h1 class=\"w3-xxxlarge w3-text-red\"><b>Contact.</b></h1>\n" +
                "    <hr style=\"width:50px;border:5px solid red\" class=\"w3-round\">\n" +
                "    <p>Do you want us to empower your team? Fill out the form and fill me in with the details :) We love meeting new people!</p>\n" +
                "    <form action=\"/action_page.php\" target=\"_blank\">\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Name</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Name\" required>\n" +
                "      </div>\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Email</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Email\" required>\n" +
                "      </div>\n" +
                "      <div class=\"w3-section\">\n" +
                "        <label>Message</label>\n" +
                "        <input class=\"w3-input w3-border\" type=\"text\" name=\"Message\" required>\n" +
                "      </div>\n" +
                "      <button type=\"submit\" class=\"w3-button w3-block w3-padding-large w3-red w3-margin-bottom\">Send Message</button>\n" +
                "    </form>  \n" +
                "  </div>\n" +
                "\n" +
                "<!-- End page content -->\n" +
                "</div>\n" +
                "\n" +
                "<!-- W3.CSS Container -->\n" +
                "\n" +
                "<script src=\"welcome.js\">\n" +
                "// Script to open and close sidebar\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }
}
