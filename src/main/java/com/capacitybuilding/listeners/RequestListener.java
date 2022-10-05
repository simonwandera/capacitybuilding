package com.capacitybuilding.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent requestEvent) {
        System.out.println(">>>>Request Made: " + requestEvent.getServletContext().getContextPath());
        ServletRequest servletRequest = requestEvent.getServletRequest();
        HttpServletRequest request = (HttpServletRequest) servletRequest;  // Cast to subinterface.

        String method = request.getMethod();
        Map<String,String[]> parameters = request.getParameterMap();

        System.out.println("Method: " + method);
        System.out.println("Path info: " + request.getServletPath());
        for (Map.Entry<String, String[]> parameter : parameters.entrySet())
            System.out.println(parameter.getKey() + " : " + parameter.getValue()[0]);

    }
}
