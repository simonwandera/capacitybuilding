package com.capacitybuilding.actions;

import javax.servlet.http.HttpSession;

public class Common {

    public static String Header(){
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\" />\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "  <title>Capacity Building</title>\n" +
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

    public static  String TopNav(String email){
        return "<nav class=\"navbar col-lg-12 col-12 p-lg-0 fixed-top d-flex flex-row\">\n" +
                "          <div class=\"navbar-menu-wrapper d-flex align-items-stretch justify-content-between\">\n" +
                "            <a class=\"navbar-brand brand-logo-mini align-self-center d-lg-none\" href=\"index.html\"><img src=\"assets/images/logo-mini.svg\" alt=\"logo\" /></a>\n" +
                "            <button class=\"navbar-toggler navbar-toggler align-self-center mr-2\" type=\"button\" data-toggle=\"minimize\">\n" +
                "              <i class=\"mdi mdi-menu\"></i>\n" +
                "            </button>\n" +
                "            <ul class=\"navbar-nav\">\n" +
                "              <li class=\"nav-item dropdown\">\n" +
                "                <a class=\"nav-link count-indicator dropdown-toggle\" id=\"notificationDropdown\" href=\"#\" data-toggle=\"dropdown\">\n" +
                "                  <i class=\"mdi mdi-bell-outline\"></i>\n" +
                "                  <span class=\"count count-varient1\">2</span>\n" +
                "                </a>\n" +
                "                <div class=\"dropdown-menu navbar-dropdown navbar-dropdown-large preview-list\" aria-labelledby=\"notificationDropdown\">\n" +
                "                  <h6 class=\"p-3 mb-0\">Notifications</h6>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-thumbnail\">\n" +
                "                      <img src=\"assets/images/faces/face4.jpg\" alt=\"\" class=\"profile-pic\" />\n" +
                "                    </div>\n" +
                "                    <div class=\"preview-item-content\">\n" +
                "                      <p class=\"mb-0\"> Mark Mwima <span class=\"text-small text-muted\">Registered for training</span>\n" +
                "                      </p>\n" +
                "                    </div>\n" +
                "                  </a>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-thumbnail\">\n" +
                "                      <img src=\"assets/images/faces/face3.jpg\" alt=\"\" class=\"profile-pic\" />\n" +
                "                    </div>\n" +
                "                    <div class=\"preview-item-content\">\n" +
                "                      <p class=\"mb-0\"> James Korir <span class=\"text-small text-muted\">Enrolled for training</span>\n" +
                "                      </p>\n" +
                "                    </div>\n" +
                "                  </a>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-thumbnail\">\n" +
                "                      <img src=\"assets/images/faces/face2.jpg\" alt=\"\" class=\"profile-pic\" />\n" +
                "                    </div>\n" +
                "                    <div class=\"preview-item-content\">\n" +
                "                      <p class=\"mb-0\"> Mercy Bore <span class=\"text-small text-muted\">Completed one training</span>\n" +
                "                      </p>\n" +
                "                    </div>\n" +
                "                  </a>\n" +
                "                  <div class=\"dropdown-divider\"></div>\n" +
                "                  <p class=\"p-3 mb-0\">View all activities</p>\n" +
                "                </div>\n" +
                "              </li>\n" +
                "              <li class=\"nav-item dropdown d-none d-sm-flex\">\n" +
                "                <a class=\"nav-link count-indicator dropdown-toggle\" id=\"messageDropdown\" href=\"#\" data-toggle=\"dropdown\">\n" +
                "                  <i class=\"mdi mdi-email-outline\"></i>\n" +
                "                  <span class=\"count count-varient2\">5</span>\n" +
                "                </a>\n" +
                "                <div class=\"dropdown-menu navbar-dropdown navbar-dropdown-large preview-list\" aria-labelledby=\"messageDropdown\">\n" +
                "                  <h6 class=\"p-3 mb-0\">Messages</h6>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-item-content flex-grow\">\n" +
                "                      <span class=\"badge badge-pill badge-success\">Request</span>\n" +
                "                      <p class=\"text-small text-muted ellipsis mb-0\"> Suport needed for this user </p>\n" +
                "                    </div>\n" +
                "                    <p class=\"text-small text-muted align-self-start\"> 4:10 PM </p>\n" +
                "                  </a>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-item-content flex-grow\">\n" +
                "                      <span class=\"badge badge-pill badge-warning\">Competencies</span>\n" +
                "                      <p class=\"text-small text-muted ellipsis mb-0\"> Most of the users are Scoring high </p>\n" +
                "                    </div>\n" +
                "                    <p class=\"text-small text-muted align-self-start\"> 4:10 PM </p>\n" +
                "                  </a>\n" +
                "                  <a class=\"dropdown-item preview-item\">\n" +
                "                    <div class=\"preview-item-content flex-grow\">\n" +
                "                      <span class=\"badge badge-pill badge-danger\">Training</span>\n" +
                "                      <p class=\"text-small text-muted ellipsis mb-0\"> Two trainings are scheduled to end tomorrow </p>\n" +
                "                    </div>\n" +
                "                    <p class=\"text-small text-muted align-self-start\"> 4:10 PM </p>\n" +
                "                  </a>\n" +
                "                  <h6 class=\"p-3 mb-0\">See all activity</h6>\n" +
                "                </div>\n" +
                "              </li>\n" +
                "\n" +
                "            </ul>\n" +
                "            <ul class=\"navbar-nav navbar-nav-right ml-lg-auto\">\n" +
                "\n" +
                "              <li class=\"nav-item nav-profile dropdown border-0\">\n" +
                "                <a class=\"nav-link dropdown-toggle\" id=\"profileDropdown\" href=\"#\" data-toggle=\"dropdown\">\n" +
                "                  <img class=\"nav-profile-img mr-2\" alt=\"\" src=\"assets/images/faces/face1.jpg\" />\n" +
                "                  <span class=\"profile-name\">" +email+ "</span>\n" +
                "                </a>\n" +
                "                <div class=\"dropdown-menu navbar-dropdown w-100\" aria-labelledby=\"profileDropdown\">\n" +
                "                  <a class=\"dropdown-item\" href=\"#\">\n" +
                "                    <i class=\"mdi mdi-logout mr-2 text-primary\"></i> Signout </a>\n" +
                "                </div>\n" +
                "              </li>\n" +
                "            </ul>\n" +
                "            <button class=\"navbar-toggler navbar-toggler-right d-lg-none align-self-center\" type=\"button\" data-toggle=\"offcanvas\">\n" +
                "              <span class=\"mdi mdi-menu\">dd</span>\n" +
                "            </button>\n" +
                "          </div>\n" +
                "        </nav>";
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
                "            <a class=\"nav-link\" href=\"./trainees\" aria-controls=\"ui-basic\">\n" +
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
                "            <a class=\"nav-link\" href=\"./trainees\">\n" +
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
