package com.capacitybuilding.training.action;

import com.capacitybuilding.training.bean.TrainingBeanI;
import com.capacitybuilding.training.bean.UploadsBeanI;
import com.capacitybuilding.training.model.Upload;
import lombok.extern.java.Log;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/fileuploadservlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

@Log
public class FileUploadServlet extends HttpServlet {

    ServletContext servletContext;

    @EJB
    TrainingBeanI trainingBean;

    @EJB
    UploadsBeanI uploadsBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        servletContext = getServletConfig().getServletContext();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Receive file uploaded to the Servlet from the HTML5 form */
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();

        String trainingId = request.getParameter("trainingId");
        for (Part part : request.getParts()) {
//            String path = System.getProperty("user.home") + System.getProperty("path.separator");
//            String path = getServletContext().getRealPath("/"+"uploads"+ File.separator + fileName);
            String path = "/home/magenta/Documents/capacitybuilding/uploads/" + fileName;

            part.write(path);

            System.out.println("*******************************************************************************************");

            log.info(path);

            Upload upload = new Upload();
            upload.setFileName(fileName);
            upload.setTraining(trainingBean.getTraining(Long.parseLong(trainingId)));

            try {
                uploadsBean.upload(upload);
                response.sendRedirect("./training/uploads.jsp?trainingId=" + upload.getTraining().getId());
            } catch (Exception ex) {
                servletContext.setAttribute("uploadError", ex.getMessage());
                System.out.println(ex.getMessage());
                response.sendRedirect("./training/uploads.jsp?trainingId=" + upload.getTraining().getId());
            }
            break;
        }
    }
}