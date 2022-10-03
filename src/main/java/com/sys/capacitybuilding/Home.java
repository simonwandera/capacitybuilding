package com.sys.capacitybuilding;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Home extends HttpServlet {
    ServletConfig config = null;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
