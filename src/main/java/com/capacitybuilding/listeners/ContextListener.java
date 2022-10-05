package com.capacitybuilding.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.print("Capacity building system... initializing default attributes");
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("applicationLabel", "Capacity building system | Made in Kenya");
    }
}
