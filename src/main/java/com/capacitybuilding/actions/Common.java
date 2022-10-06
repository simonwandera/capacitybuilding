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

    public static String SideNav(){
        return  "      <nav class=\"sidebar sidebar-offcanvas\" id=\"sidebar\">\n" +
                "        <div class=\"text-center sidebar-brand-wrapper d-flex align-items-center\">\n" +
                "          <a class=\"sidebar-brand brand-logo\" href=\"index.html\"><img src=\"assets/images/logo.svg\" alt=\"logo\" /></a>\n" +
                "          <a class=\"sidebar-brand brand-logo-mini pl-4 pt-3\" href=\"index.html\"><img src=\"assets/images/logo-mini.svg\" alt=\"logo\" /></a>\n" +
                "        </div>\n" +
                "        <ul class=\"nav\">\n" +
                "          <li class=\"nav-item nav-profile\">\n" +
                "            <a href=\"#\" class=\"nav-link\">\n" +
                "              <div class=\"nav-profile-image\">\n" +
                "                <img src=\"assets/images/faces/face1.jpg\" alt=\"profile\" />\n" +
                "                <span class=\"login-status online\"></span>\n" +
                "              </div>\n" +
                "              <div class=\"nav-profile-text d-flex flex-column pr-3\">\n" +
                "                <span class=\"font-weight-medium mb-2\">User</span>\n" +
                "                <span class=\"font-weight-normal\">Admin</span>\n" +
                "              </div>\n" +
                "              <span class=\"badge badge-danger text-white ml-3 rounded\">3</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"index.html\">\n" +
                "              <i class=\"mdi mdi-home menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Dashboard</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" data-toggle=\"collapse\" href=\"#ui-basic\" aria-expanded=\"false\" aria-controls=\"ui-basic\">\n" +
                "              <i class=\"mdi mdi-crosshairs-gps menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Home</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" data-toggle=\"collapse\" href=\"#ui-basic\" aria-expanded=\"false\" aria-controls=\"ui-basic\">\n" +
                "              <i class=\"mdi mdi-account-multiple menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Trainees</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          \n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"pages/icons/mdi.html\">\n" +
                "              <i class=\"mdi mdi-contacts menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Notifications</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"pages/forms/basic_elements.html\">\n" +
                "              <i class=\"mdi mdi-format-list-bulleted menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Report</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"pages/charts/chartjs.html\">\n" +
                "              <i class=\"mdi mdi-chart-bar menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Trainings</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"pages/tables/basic-table.html\">\n" +
                "              <i class=\"mdi mdi-table-large menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Graphs</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item\">\n" +
                "            <a class=\"nav-link\" href=\"https://www.bootstrapdash.com/demo/breeze-free/documentation/documentation.html\">\n" +
                "              <i class=\"mdi mdi-file-document-box menu-icon\"></i>\n" +
                "              <span class=\"menu-title\">Documentation</span>\n" +
                "            </a>\n" +
                "          </li>\n" +
                "          <li class=\"nav-item sidebar-actions\">\n" +
                "            <div class=\"nav-link\">\n" +
                "              <div class=\"mt-4\">\n" +
                "                <div class=\"border-none\">\n" +
                "                  <p class=\"text-black\">Settings</p>\n" +
                "                </div>\n" +
                "                <ul class=\"mt-4 pl-0\">\n" +
                "                  <li><a href=\"#\">Sign Out</a></li>\n" +
                "                </ul>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </li>\n" +
                "        </ul>\n" +
                "      </nav>";
    }
}
