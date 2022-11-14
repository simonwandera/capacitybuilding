package com.capacitybuilding.listeners;

import com.zaxxer.hikari.HikariDataSource;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event){


        System.out.print("Capacity building system... initializing default attributes");
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("appName", "Capacity building system | Made in Kenya");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}