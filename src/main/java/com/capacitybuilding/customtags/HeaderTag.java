package com.capacitybuilding.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HeaderTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\" />\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "<title>Capacity Building</title>\n" +
                "<link rel=\"stylesheet\" href=\"../assets/vendors/mdi/css/materialdesignicons.min.css\" />\n" +
                "<link rel=\"stylesheet\" href=\"../assets/vendors/flag-icon-css/css/flag-icon.min.css\" />\n" +
                "<link rel=\"stylesheet\" href=\"../assets/vendors/css/vendor.bundle.base.css\" />\n" +
                "<link rel=\"stylesheet\" href=\"../assets/vendors/select2/select2.min.css\" />\n" +
                "<link rel=\"stylesheet\" href=\"../assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css\" />\n" +
                "<link rel=\"stylesheet\" href=\"../assets/css/style.css\" />\n" +
                "<link rel=\"shortcut icon\" href=\"../assets/images/favicon.png\" />\n" +
                "</head>");

    }
}
