package com.capacitybuilding.util.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class FooterTag extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        out.println("  <script src=\"../assets/vendors/js/vendor.bundle.base.js\"></script>\n" +
                "  <script src=\"../assets/vendors/select2/select2.min.js\"></script>\n" +
                "  <script src=\"../assets/vendors/typeahead.js/typeahead.bundle.min.js\"></script>\n" +
                "  <script src=\"../assets/js/off-canvas.js\"></script>\n" +
                "  <script src=\"../assets/js/hoverable-collapse.js\"></script>\n" +
                "  <script src=\"../assets/js/misc.js\"></script>\n" +
                "  <script src=\"../assets/js/file-upload.js\"></script>\n" +
                "  <script src=\"../assets/js/typeahead.js\"></script>\n" +
                "  <script src=\"../assets/js/select2.js\"></script>\n" +
                "</body>\n" +
                "</html>");

    }
}
