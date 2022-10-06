package com.capacitybuilding.actions;

public class Common {

    public static String Header(){
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\" />\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "  <title>Login</title>\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/mdi/css/materialdesignicons.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/flag-icon-css/css/flag-icon.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/css/vendor.bundle.base.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/select2/select2.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css\" />\n" +
                "  <link rel=\"stylesheet\" href=\"./assets/css/style.css\" />\n" +
                "  <link rel=\"shortcut icon\" href=\"./assets/images/favicon.png\" />\n" +
                "</head>\n";
    }

    public static String Footer(){
        return "  <script src=\"./assets/vendors/js/vendor.bundle.base.js\"></script>\n" +
                "  <script src=\"./assets/vendors/select2/select2.min.js\"></script>\n" +
                "  <script src=\"./assets/vendors/typeahead.js/typeahead.bundle.min.js\"></script>\n" +
                "  <script src=\"./assets/js/off-canvas.js\"></script>\n" +
                "  <script src=\"./assets/js/hoverable-collapse.js\"></script>\n" +
                "  <script src=\"./assets/js/misc.js\"></script>\n" +
                "  <script src=\"./assets/js/file-upload.js\"></script>\n" +
                "  <script src=\"./assets/js/typeahead.js\"></script>\n" +
                "  <script src=\"./assets/js/select2.js\"></script>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
    }
}
