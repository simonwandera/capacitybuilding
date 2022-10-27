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

@WebListener
public class ContextListener implements ServletContextListener {

    @Resource(lookup = "java:jboss/datasources/CapacityBuilding")
    DataSource dataSource;
    public void contextInitialized(ServletContextEvent event){
        System.out.print("Capacity building system... initializing default attributes");
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("appName", "Capacity building system | Made in Kenya");

        try {
            System.out.print("Establishing connections....");

            Connection connection = dataSource.getConnection();
            servletContext.setAttribute("dbConnection", connection);
            System.out.print("Connection Established....");
        } catch (Exception ex) {
            System.out.println("Connection Not Established....: " + ex.getMessage());

        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ServletContext ctx = servletContextEvent.getServletContext();
            Connection connection = (Connection) ctx.getAttribute("dbConnection");
            connection.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
