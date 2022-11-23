package com.capacitybuilding.training.action;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/uploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {

    ServletContext servletContext;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");

        try(PrintWriter out = res.getWriter()) {
            Part part = req.getPart("file");
            String filename = part.getSubmittedFileName();
            String path = getServletContext().getRealPath("/"+"uploads"+ File.separator+filename);

            InputStream is = part.getInputStream();
            boolean success = uploadFile(is, path);
            if (success){
                out.println("File uploaded to this directory" + path);
            }else {
                out.println("Error");
            }

        }
    }


    public boolean uploadFile(InputStream is, String path){
        boolean test = false;
        try {
            byte[] bytes = new byte[is.available()];
            is.read();
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

            test = true;

        }catch (Exception ex){
            ex.printStackTrace();

        }

        return test;
    }
}
