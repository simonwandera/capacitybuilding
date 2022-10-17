package com.capacitybuilding.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Printing from session Remote address: " + servletRequest.getRemoteAddr());

        HttpServletRequest httpReq = (HttpServletRequest)  servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse)  servletResponse;
        HttpSession session = httpReq.getSession(); //returns existing session or creates if not existing

        String reqPath = httpReq.getServletPath();

        System.out.println("Request path: "+ reqPath);
        System.out.println("\n\nNew session: "+ session.isNew());

        if (reqPath == null) {
            session.invalidate();
            httpRes.sendRedirect("./");
            return;
        }

        //if user is accessing /home - (page accessed only by logged-in users),
        //with a new session creating in this filter (which mean the session was initially
        // null and was crated in this filter at line 21, the user will be redirected to login page
        if (reqPath.equalsIgnoreCase("/home") && session.isNew() /*checks if
        // session was created in the filte*/) {
            httpRes.sendRedirect("./login");
            return;
        }

        //in case user is accessing login/register/index page, they should not have a session.. invalidate
        if (reqPath.equalsIgnoreCase("/login")
                || reqPath.equalsIgnoreCase("/register")
                || reqPath.equalsIgnoreCase("/"))
            session.invalidate();

        //proceed to the resource/servlet requested
        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
