package com.capacitybuilding.actions;

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

        System.out.println("Sessions:\t" + req.getSession().getAttribute("students"));

        res.getWriter().print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
                "    <title>Capacity Building</title>\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/mdi/css/materialdesignicons.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/flag-icon-css/css/flag-icon.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/css/vendor.bundle.base.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/font-awesome/css/font-awesome.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.css\" />\n" +
                "    <link rel=\"stylesheet\" href=\"./assets/css/style.css\" />\n" +
                "    <link rel=\"shortcut icon\" href=\"./assets/images/favicon.png\" />\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div class=\"container-scroller\">\n" +
                "      <nav class=\"sidebar sidebar-offcanvas\" id=\"sidebar\">\n" +
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
                "\n" +
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
                "      </nav>\n" +
                "      <div class=\"container-fluid page-body-wrapper\">\n" +
                "        <div id=\"theme-settings\" class=\"settings-panel\">\n" +
                "          <i class=\"settings-close mdi mdi-close\"></i>\n" +
                "          <p class=\"settings-heading\">SIDEBAR SKINS</p>\n" +
                "          <div class=\"sidebar-bg-options selected\" id=\"sidebar-default-theme\">\n" +
                "            <div class=\"img-ss rounded-circle bg-light border mr-3\"></div> Default\n" +
                "          </div>\n" +
                "          <div class=\"sidebar-bg-options\" id=\"sidebar-dark-theme\">\n" +
                "            <div class=\"img-ss rounded-circle bg-dark border mr-3\"></div> Dark\n" +
                "          </div>\n" +
                "          <p class=\"settings-heading mt-2\">HEADER SKINS</p>\n" +
                "          <div class=\"color-tiles mx-0 px-4\">\n" +
                "            <div class=\"tiles light\"></div>\n" +
                "            <div class=\"tiles dark\"></div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "        <nav class=\"navbar col-lg-12 col-12 p-lg-0 fixed-top d-flex flex-row\">\n" +
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
                "                  <span class=\"profile-name\">John Doe</span>\n" +
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
                "        </nav>\n" +
                "        <div class=\"main-panel\">\n" +
                "          <div class=\"content-wrapper pb-0\">\n" +
                "            <div class=\"page-header flex-wrap\">\n" +
                "              <h3 class=\"mb-0\"> Hi, welcome <span class=\"pl-0 h6 pl-sm-2 text-muted d-inline-block\">Capacity buiding dashboard.</span>\n" +
                "              </h3>\n" +
                "              <div class=\"d-flex\">\n" +
                "                <button type=\"button\" class=\"btn btn-sm ml-3 btn-success\"> Add User </button>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-xl-3 col-lg-12 stretch-card grid-margin\">\n" +
                "                <div class=\"row\">\n" +
                "                  <div class=\"col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3\">\n" +
                "                    <div class=\"card bg-warning\">\n" +
                "                      <div class=\"card-body px-3 py-4\">\n" +
                "                        <div class=\"d-flex justify-content-between align-items-start\">\n" +
                "                          <div class=\"color-card\">\n" +
                "                            <p class=\"mb-0 color-card-head\">Trainings</p>\n" +
                "                            <h2 class=\"text-white\">55<span class=\"h5\"></span>\n" +
                "                            </h2>\n" +
                "                          </div>\n" +
                "                          <i class=\"card-icon-indicator mdi mdi-basket bg-inverse-icon-warning\"></i>\n" +
                "                        </div>\n" +
                "                        <h6 class=\"text-white\">80% Enrolled</h6>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                  <div class=\"col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3\">\n" +
                "                    <div class=\"card bg-danger\">\n" +
                "                      <div class=\"card-body px-3 py-4\">\n" +
                "                        <div class=\"d-flex justify-content-between align-items-start\">\n" +
                "                          <div class=\"color-card\">\n" +
                "                            <p class=\"mb-0 color-card-head\">Trainees</p>\n" +
                "                            <h2 class=\"text-white\"> 130</span>\n" +
                "                            </h2>\n" +
                "                          </div>\n" +
                "                          <i class=\"card-icon-indicator mdi mdi-cube-outline bg-inverse-icon-danger\"></i>\n" +
                "                        </div>\n" +
                "                        <h6 class=\"text-white\">15% more than last month</h6>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                  <div class=\"col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3 pb-lg-0 pb-xl-3\">\n" +
                "                    <div class=\"card bg-primary\">\n" +
                "                      <div class=\"card-body px-3 py-4\">\n" +
                "                        <div class=\"d-flex justify-content-between align-items-start\">\n" +
                "                          <div class=\"color-card\">\n" +
                "                            <p class=\"mb-0 color-card-head\">Orders</p>\n" +
                "                            <h2 class=\"text-white\"> $1,753.<span class=\"h5\">00</span>\n" +
                "                            </h2>\n" +
                "                          </div>\n" +
                "                          <i class=\"card-icon-indicator mdi mdi-briefcase-outline bg-inverse-icon-primary\"></i>\n" +
                "                        </div>\n" +
                "                        <h6 class=\"text-white\">67.98% Since last month</h6>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                  <div class=\"col-xl-12 col-md-6 stretch-card pb-sm-3 pb-lg-0\">\n" +
                "                    <div class=\"card bg-success\">\n" +
                "                      <div class=\"card-body px-3 py-4\">\n" +
                "                        <div class=\"d-flex justify-content-between align-items-start\">\n" +
                "                          <div class=\"color-card\">\n" +
                "                            <p class=\"mb-0 color-card-head\">Affiliate</p>\n" +
                "                            <h2 class=\"text-white\">2368</h2>\n" +
                "                          </div>\n" +
                "                          <i class=\"card-icon-indicator mdi mdi-account-circle bg-inverse-icon-success\"></i>\n" +
                "                        </div>\n" +
                "                        <h6 class=\"text-white\">20.32% Since last month</h6>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-9 stretch-card grid-margin\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <div class=\"row\">\n" +
                "                      <div class=\"col-sm-7\">\n" +
                "                        <h5>Business Survey</h5>\n" +
                "                        <p class=\"text-muted\"> Show overview jan 2018 - Dec 2019 <a class=\"text-muted font-weight-medium pl-2\" href=\"#\"><u>See Details</u></a>\n" +
                "                        </p>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 text-md-right\">\n" +
                "                        <button type=\"button\" class=\"btn btn-icon-text mb-3 mb-sm-0 btn-inverse-primary font-weight-normal\">\n" +
                "                          <i class=\"mdi mdi-email btn-icon-prepend\"></i>Download Report </button>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row\">\n" +
                "                      <div class=\"col-sm-4\">\n" +
                "                        <div class=\"card mb-3 mb-sm-0\">\n" +
                "                          <div class=\"card-body py-3 px-4\">\n" +
                "                            <p class=\"m-0 survey-head\">Today Earnings</p>\n" +
                "                            <div class=\"d-flex justify-content-between align-items-end flot-bar-wrapper\">\n" +
                "                              <div>\n" +
                "                                <h3 class=\"m-0 survey-value\">$5,300</h3>\n" +
                "                                <p class=\"text-success m-0\">-310 avg. sales</p>\n" +
                "                              </div>\n" +
                "                              <div id=\"earningChart\" class=\"flot-chart\"></div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-4\">\n" +
                "                        <div class=\"card mb-3 mb-sm-0\">\n" +
                "                          <div class=\"card-body py-3 px-4\">\n" +
                "                            <p class=\"m-0 survey-head\">Product Sold</p>\n" +
                "                            <div class=\"d-flex justify-content-between align-items-end flot-bar-wrapper\">\n" +
                "                              <div>\n" +
                "                                <h3 class=\"m-0 survey-value\">$9,100</h3>\n" +
                "                                <p class=\"text-danger m-0\">-310 avg. sales</p>\n" +
                "                              </div>\n" +
                "                              <div id=\"productChart\" class=\"flot-chart\"></div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-4\">\n" +
                "                        <div class=\"card\">\n" +
                "                          <div class=\"card-body py-3 px-4\">\n" +
                "                            <p class=\"m-0 survey-head\">Today Orders</p>\n" +
                "                            <div class=\"d-flex justify-content-between align-items-end flot-bar-wrapper\">\n" +
                "                              <div>\n" +
                "                                <h3 class=\"m-0 survey-value\">$4,354</h3>\n" +
                "                                <p class=\"text-success m-0\">-310 avg. sales</p>\n" +
                "                              </div>\n" +
                "                              <div id=\"orderChart\" class=\"flot-chart\"></div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row\">\n" +
                "                      <div class=\"col-sm-8\">\n" +
                "                        <p class=\"text-muted mb-0\"> Post COVID-19, we all will have to do more, with less. Learn why capacity-building is essential for your nonprofit's health and longevity. <b>Learn More</b>\n" +
                "                        </p>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-4\">\n" +
                "                        <p class=\"mb-0 text-muted\">Sales Revenue</p>\n" +
                "                        <h5 class=\"d-inline-block survey-value mb-0\"> $2,45,500 </h5>\n" +
                "                        <p class=\"d-inline-block text-danger mb-0\"> last 8 months </p>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-xl-8 col-sm-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body px-0 overflow-auto\">\n" +
                "                    <h4 class=\"card-title pl-4\">Purchase History</h4>\n" +
                "                    <div class=\"table-responsive\">\n" +
                "                      <table class=\"table\">\n" +
                "                        <thead class=\"bg-light\">\n" +
                "                          <tr>\n" +
                "                            <th>Customer</th>\n" +
                "                            <th>Project</th>\n" +
                "                            <th>Invoice</th>\n" +
                "                            <th>Amount</th>\n" +
                "                          </tr>\n" +
                "                        </thead>\n" +
                "                        <tbody>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <div class=\"d-flex align-items-center\">\n" +
                "                                <img src=\"assets/images/faces/face1.jpg\" alt=\"image\" />\n" +
                "                                <div class=\"table-user-name ml-3\">\n" +
                "                                  <p class=\"mb-0 font-weight-medium\"> Cecelia Cooper </p>\n" +
                "                                  <small> Payment on hold</small>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                            <td>Angular Admin</td>\n" +
                "                            <td>\n" +
                "                              <div class=\"badge badge-inverse-success\"> Completed </div>\n" +
                "                            </td>\n" +
                "                            <td>$ 77.99</td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <div class=\"d-flex align-items-center\">\n" +
                "                                <img src=\"assets/images/faces/face10.jpg\" alt=\"image\" />\n" +
                "                                <div class=\"table-user-name ml-3\">\n" +
                "                                  <p class=\"mb-0 font-weight-medium\"> Victor Watkins </p>\n" +
                "                                  <small>Email verified</small>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                            <td>Angular Admin</td>\n" +
                "                            <td>\n" +
                "                              <div class=\"badge badge-inverse-success\"> Completed </div>\n" +
                "                            </td>\n" +
                "                            <td>$245.30</td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <div class=\"d-flex align-items-center\">\n" +
                "                                <img src=\"assets/images/faces/face11.jpg\" alt=\"image\" />\n" +
                "                                <div class=\"table-user-name ml-3\">\n" +
                "                                  <p class=\"mb-0 font-weight-medium\"> Ada Burgess </p>\n" +
                "                                  <small>Email verified</small>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                            <td>One page html</td>\n" +
                "                            <td>\n" +
                "                              <div class=\"badge badge-inverse-danger\"> Completed </div>\n" +
                "                            </td>\n" +
                "                            <td>$ 160.25</td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <div class=\"d-flex align-items-center\">\n" +
                "                                <img src=\"assets/images/faces/face13.jpg\" alt=\"image\" />\n" +
                "                                <div class=\"table-user-name ml-3\">\n" +
                "                                  <p class=\"mb-0 font-weight-medium\"> Dollie Lynch </p>\n" +
                "                                  <small>Email verified</small>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                            <td>Wordpress</td>\n" +
                "                            <td>\n" +
                "                              <div class=\"badge badge-inverse-success\"> Declined </div>\n" +
                "                            </td>\n" +
                "                            <td>$ 123.21</td>\n" +
                "                          </tr>\n" +
                "                          <tr>\n" +
                "                            <td>\n" +
                "                              <div class=\"d-flex align-items-center\">\n" +
                "                                <img src=\"assets/images/faces/face16.jpg\" alt=\"image\" />\n" +
                "                                <div class=\"table-user-name ml-3\">\n" +
                "                                  <p class=\"mb-0 font-weight-medium\"> Harry Holloway </p>\n" +
                "                                  <small>Payment on process</small>\n" +
                "                                </div>\n" +
                "                              </div>\n" +
                "                            </td>\n" +
                "                            <td>VueJs Application</td>\n" +
                "                            <td>\n" +
                "                              <div class=\"badge badge-inverse-danger\"> Declined </div>\n" +
                "                            </td>\n" +
                "                            <td>$ 150.00</td>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </div>\n" +
                "                    <a class=\"text-black mt-3 d-block pl-4\" href=\"#\">\n" +
                "                      <span class=\"font-weight-medium h6\">View all order history</span>\n" +
                "                      <i class=\"mdi mdi-chevron-right\"></i></a>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-4 col-sm-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <div class=\"card-title font-weight-medium\"> Business Survey </div>\n" +
                "                    <p class=\"text-muted\"> Lorem ipsum dolor sitadipiscing elit, sed amet do eiusmod tempor we find a new solution </p>\n" +
                "                    <div class=\"d-flex flex-wrap border-bottom py-2 border-top justify-content-between\">\n" +
                "                      <img class=\"survey-img mb-lg-3\" src=\"assets/images/dashboard/img_3.jpg\" alt=\"\" />\n" +
                "                      <div class=\"pt-2\">\n" +
                "                        <h5 class=\"mb-0\">Villa called Archagel</h5>\n" +
                "                        <p class=\"mb-0 text-muted\">St, San Diego, CA</p>\n" +
                "                        <h5 class=\"mb-0\">$600/mo</h5>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"d-flex flex-wrap border-bottom py-2 justify-content-between\">\n" +
                "                      <img class=\"survey-img mb-lg-3\" src=\"assets/images/dashboard/img_1.jpg\" alt=\"\" />\n" +
                "                      <div class=\"pt-2\">\n" +
                "                        <h5 class=\"mb-0\">Luxury villa in Hermo</h5>\n" +
                "                        <p class=\"mb-0 text-muted\">Glendale, CA</p>\n" +
                "                        <h5 class=\"mb-0\">$900/mo</h5>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"d-flex flex-wrap border-bottom py-2 justify-content-between\">\n" +
                "                      <img class=\"survey-img mb-lg-3\" src=\"assets/images/dashboard/img_2.jpg\" alt=\"\" />\n" +
                "                      <div class=\"pt-2\">\n" +
                "                        <h5 class=\"mb-0\">House on the Clarita</h5>\n" +
                "                        <p class=\"mb-0 text-muted\">Business Survey</p>\n" +
                "                        <h5 class=\"mb-0\">$459/mo</h5>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <a class=\"text-black mt-3 d-block font-weight-medium h6\" href=\"#\">View all <i class=\"mdi mdi-chevron-right\"></i></a>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-xl-4 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title text-black\">To do Task List</h4>\n" +
                "                    <p class=\"text-muted\">Created by anonymous</p>\n" +
                "                    <div class=\"list-wrapper\">\n" +
                "                      <ul class=\"d-flex flex-column-reverse todo-list todo-list-custom\">\n" +
                "                        <li>\n" +
                "                          <div class=\"form-check\">\n" +
                "                            <label class=\"form-check-label\">\n" +
                "                              <input class=\"checkbox\" type=\"checkbox\" /> Meeting with Alisa </label>\n" +
                "                            <span class=\"list-time\">4 Hours Ago</span>\n" +
                "                          </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                          <div class=\"form-check\">\n" +
                "                            <label class=\"form-check-label\">\n" +
                "                              <input class=\"checkbox\" type=\"checkbox\" /> Create invoice </label>\n" +
                "                            <span class=\"list-time\">6 Hours Ago</span>\n" +
                "                          </div>\n" +
                "                        </li>\n" +
                "                        <li class=\"completed\">\n" +
                "                          <div class=\"form-check\">\n" +
                "                            <label class=\"form-check-label\">\n" +
                "                              <input class=\"checkbox\" type=\"checkbox\" checked /> Prepare for presentation </label>\n" +
                "                            <span class=\"list-time\">2 Hours Ago</span>\n" +
                "                          </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                          <div class=\"form-check\">\n" +
                "                            <label class=\"form-check-label\">\n" +
                "                              <input class=\"checkbox\" type=\"checkbox\" /> Pick up kids from school </label>\n" +
                "                            <span class=\"list-time\">8 Hours Ago</span>\n" +
                "                          </div>\n" +
                "                        </li>\n" +
                "                      </ul>\n" +
                "                    </div>\n" +
                "                    <div class=\"add-items d-flex flex-wrap flex-sm-nowrap\">\n" +
                "                      <input type=\"text\" class=\"form-control todo-list-input flex-grow\" placeholder=\"Add task name\" />\n" +
                "                      <button class=\"add btn btn-primary font-weight-regular text-nowrap\" id=\"add-task\"> Add Task </button>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-4 col-md-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title text-black\">Recent Customers</h4>\n" +
                "                    <p class=\"text-muted\">All contacts</p>\n" +
                "                    <div class=\"row pt-2 pb-1\">\n" +
                "                      <div class=\"col-12 col-sm-7\">\n" +
                "                        <div class=\"row\">\n" +
                "                          <div class=\"col-4 col-md-4\">\n" +
                "                            <img class=\"customer-img\" src=\"assets/images/faces/face22.jpg\" alt=\"\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"col-8 col-md-8 p-sm-0\">\n" +
                "                            <h6 class=\"mb-0\">Cecelia Cooper</h6>\n" +
                "                            <p class=\"text-muted font-12\">05:58AM</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 pl-0\">\n" +
                "                        <canvas id=\"areaChart1\"></canvas>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-1\">\n" +
                "                      <div class=\"col-sm-7\">\n" +
                "                        <div class=\"row\">\n" +
                "                          <div class=\"col-4 col-sm-4\">\n" +
                "                            <img class=\"customer-img\" src=\"assets/images/faces/face25.jpg\" alt=\"\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"col-8 col-sm-8 p-sm-0\">\n" +
                "                            <h6 class=\"mb-0\">Victor Watkins</h6>\n" +
                "                            <p class=\"text-muted font-12\">05:28AM</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 pl-0\">\n" +
                "                        <canvas id=\"areaChart2\"></canvas>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-1\">\n" +
                "                      <div class=\"col-sm-7\">\n" +
                "                        <div class=\"row\">\n" +
                "                          <div class=\"col-4 col-sm-4\">\n" +
                "                            <img class=\"customer-img\" src=\"assets/images/faces/face15.jpg\" alt=\"\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"col-8 col-sm-8 p-sm-0\">\n" +
                "                            <h6 class=\"mb-0\">Ada Burgess</h6>\n" +
                "                            <p class=\"text-muted font-12\">05:57AM</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 pl-0\">\n" +
                "                        <canvas id=\"areaChart3\"></canvas>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-1\">\n" +
                "                      <div class=\"col-sm-7\">\n" +
                "                        <div class=\"row\">\n" +
                "                          <div class=\"col-4 col-sm-4\">\n" +
                "                            <img class=\"customer-img\" src=\"assets/images/faces/face5.jpg\" alt=\"\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"col-8 col-sm-8 p-sm-0\">\n" +
                "                            <h6 class=\"mb-0\">Dollie Lynch</h6>\n" +
                "                            <p class=\"text-muted font-12\">05:59AM</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 pl-0\">\n" +
                "                        <canvas id=\"areaChart4\"></canvas>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row\">\n" +
                "                      <div class=\"col-sm-7\">\n" +
                "                        <div class=\"row\">\n" +
                "                          <div class=\"col-4 col-sm-4\">\n" +
                "                            <img class=\"customer-img\" src=\"assets/images/faces/face2.jpg\" alt=\"\" />\n" +
                "                          </div>\n" +
                "                          <div class=\"col-8 col-sm-8 p-sm-0\">\n" +
                "                            <h6 class=\"mb-0\">Harry Holloway</h6>\n" +
                "                            <p class=\"text-muted font-12 mb-0\">05:13AM</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-5 pl-0\">\n" +
                "                        <canvas id=\"areaChart5\" height=\"100\"></canvas>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-4 col-md-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title text-black\">Business Survey</h4>\n" +
                "                    <p class=\"text-muted pb-2\">Jan 01 2019 - Dec 31 2019</p>\n" +
                "                    <canvas id=\"surveyBar\"></canvas>\n" +
                "                    <div class=\"row border-bottom pb-3 pt-4 align-items-center mx-0\">\n" +
                "                      <div class=\"col-sm-9 pl-0\">\n" +
                "                        <div class=\"d-flex\">\n" +
                "                          <img src=\"assets/images/dashboard/img_4.jpg\" alt=\"\" />\n" +
                "                          <div class=\"pl-2\">\n" +
                "                            <h6 class=\"m-0\">Red Chair</h6>\n" +
                "                            <p class=\"m-0\">Home Decoration</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-3 pl-0 pl-sm-3\">\n" +
                "                        <div class=\"badge badge-inverse-success mt-3 mt-sm-0\"> +7.7% </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-3 align-items-center mx-0\">\n" +
                "                      <div class=\"col-sm-9 pl-0\">\n" +
                "                        <div class=\"d-flex\">\n" +
                "                          <img src=\"assets/images/dashboard/img_5.jpg\" alt=\"\" />\n" +
                "                          <div class=\"pl-2\">\n" +
                "                            <h6 class=\"m-0\">Gray Sofa</h6>\n" +
                "                            <p class=\"m-0\">Home Decoration</p>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                      <div class=\"col-sm-3 pl-0 pl-sm-3\">\n" +
                "                        <div class=\"badge badge-inverse-success mt-3 mt-sm-0\"> +7.7% </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-xl-4 grid-margin stretch-card\">\n" +
                "                <!--activity-->\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title\">\n" +
                "                      <span class=\"d-flex justify-content-between\">\n" +
                "                        <span>Activity</span>\n" +
                "                        <span class=\"dropdown dropleft d-block\">\n" +
                "                          <span id=\"dropdownMenuButton1\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                            <span><i class=\"mdi mdi-dots-horizontal\"></i></span>\n" +
                "                          </span>\n" +
                "                          <span class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton1\">\n" +
                "                            <a class=\"dropdown-item\" href=\"#\">Contact</a>\n" +
                "                            <a class=\"dropdown-item\" href=\"#\">Helpdesk</a>\n" +
                "                            <a class=\"dropdown-item\" href=\"#\">Chat with us</a>\n" +
                "                          </span>\n" +
                "                        </span>\n" +
                "                      </span>\n" +
                "                    </h4>\n" +
                "                    <ul class=\"gradient-bullet-list border-bottom\">\n" +
                "                      <li>\n" +
                "                        <h6 class=\"mb-0\"> It's awesome when we find a new solution </h6>\n" +
                "                        <p class=\"text-muted\">2h ago</p>\n" +
                "                      </li>\n" +
                "                      <li>\n" +
                "                        <h6 class=\"mb-0\">Report has been updated</h6>\n" +
                "                        <p class=\"text-muted\">\n" +
                "                          <span>2h ago</span>\n" +
                "                          <span class=\"d-inline-block\">\n" +
                "                            <span class=\"d-flex d-inline-block\">\n" +
                "                              <img class=\"ml-1\" src=\"assets/images/faces/face1.jpg\" alt=\"\" />\n" +
                "                              <img class=\"ml-1\" src=\"assets/images/faces/face10.jpg\" alt=\"\" />\n" +
                "                              <img class=\"ml-1\" src=\"assets/images/faces/face14.jpg\" alt=\"\" />\n" +
                "                            </span>\n" +
                "                          </span>\n" +
                "                        </p>\n" +
                "                      </li>\n" +
                "                      <li>\n" +
                "                        <h6 class=\"mb-0\"> Analytics dashboard has been created#Slack </h6>\n" +
                "                        <p class=\"text-muted\">2h ago</p>\n" +
                "                      </li>\n" +
                "                      <li>\n" +
                "                        <h6 class=\"mb-0\"> It's awesome when we find a new solution </h6>\n" +
                "                        <p class=\"text-muted\">2h ago</p>\n" +
                "                      </li>\n" +
                "                    </ul>\n" +
                "                    <a class=\"text-black mt-3 mb-0 d-block h6\" href=\"#\">View all <i class=\"mdi mdi-chevron-right\"></i></a>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-xl-4 col-md-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card card-invoice\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title pb-3\">Pending invoices</h4>\n" +
                "                    <div class=\"list-card\">\n" +
                "                      <div class=\"row align-items-center\">\n" +
                "                        <div class=\"col-7 col-sm-8\">\n" +
                "                          <div class=\"row align-items-center\">\n" +
                "                            <div class=\"col-sm-4\">\n" +
                "                              <img src=\"assets/images/faces/face2.jpg\" alt=\"\" />\n" +
                "                            </div>\n" +
                "                            <div class=\"col-sm-8 pr-0 pl-sm-0\">\n" +
                "                              <span>06 Jan 2019</span>\n" +
                "                              <h6 class=\"mb-1 mb-sm-0\">Isabel Cross</h6>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-5 col-sm-4\">\n" +
                "                          <div class=\"d-flex pt-1 align-items-center\">\n" +
                "                            <div class=\"reload-outer bg-info\">\n" +
                "                              <i class=\"mdi mdi-reload\"></i>\n" +
                "                            </div>\n" +
                "                            <div class=\"dropdown dropleft pl-1 pt-3\">\n" +
                "                              <div id=\"dropdownMenuButton2\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                                <p><i class=\"mdi mdi-dots-vertical\"></i></p>\n" +
                "                              </div>\n" +
                "                              <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton2\">\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Sales</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Track Invoice</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Payment History</a>\n" +
                "                              </div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"list-card\">\n" +
                "                      <div class=\"row align-items-center\">\n" +
                "                        <div class=\"col-7 col-sm-8\">\n" +
                "                          <div class=\"row align-items-center\">\n" +
                "                            <div class=\"col-sm-4\">\n" +
                "                              <img src=\"assets/images/faces/face3.jpg\" alt=\"\" />\n" +
                "                            </div>\n" +
                "                            <div class=\"col-sm-8 pr-0 pl-sm-0\">\n" +
                "                              <span>18 Mar 2019</span>\n" +
                "                              <h6 class=\"mb-1 mb-sm-0\">Carrie Parker</h6>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-5 col-sm-4\">\n" +
                "                          <div class=\"d-flex pt-1 align-items-center\">\n" +
                "                            <div class=\"reload-outer bg-primary\">\n" +
                "                              <i class=\"mdi mdi-reload\"></i>\n" +
                "                            </div>\n" +
                "                            <div class=\"dropdown dropleft pl-1 pt-3\">\n" +
                "                              <div id=\"dropdownMenuButton3\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                                <p><i class=\"mdi mdi-dots-vertical\"></i></p>\n" +
                "                              </div>\n" +
                "                              <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton3\">\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Sales</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Track Invoice</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Payment History</a>\n" +
                "                              </div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"list-card\">\n" +
                "                      <div class=\"row align-items-center\">\n" +
                "                        <div class=\"col-7 col-sm-8\">\n" +
                "                          <div class=\"row align-items-center\">\n" +
                "                            <div class=\"col-sm-4\">\n" +
                "                              <img src=\"assets/images/faces/face11.jpg\" alt=\"\" />\n" +
                "                            </div>\n" +
                "                            <div class=\"col-sm-8 pr-0 pl-sm-0\">\n" +
                "                              <span>10 Apr 2019</span>\n" +
                "                              <h6 class=\"mb-1 mb-sm-0\">Don Bennett</h6>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-5 col-sm-4\">\n" +
                "                          <div class=\"d-flex pt-1 align-items-center\">\n" +
                "                            <div class=\"reload-outer bg-warning\">\n" +
                "                              <i class=\"mdi mdi-reload\"></i>\n" +
                "                            </div>\n" +
                "                            <div class=\"dropdown dropleft pl-1 pt-3\">\n" +
                "                              <div id=\"dropdownMenuButton4\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                                <p><i class=\"mdi mdi-dots-vertical\"></i></p>\n" +
                "                              </div>\n" +
                "                              <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton4\">\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Sales</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Track Invoice</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Payment History</a>\n" +
                "                              </div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"list-card\">\n" +
                "                      <div class=\"row align-items-center\">\n" +
                "                        <div class=\"col-7 col-sm-8\">\n" +
                "                          <div class=\"row align-items-center\">\n" +
                "                            <div class=\"col-sm-4\">\n" +
                "                              <img src=\"assets/images/faces/face3.jpg\" alt=\"\" />\n" +
                "                            </div>\n" +
                "                            <div class=\"col-sm-8 pr-0 pl-sm-0\">\n" +
                "                              <span>18 Mar 2019</span>\n" +
                "                              <h6 class=\"mb-1 mb-sm-0\">Carrie Parker</h6>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"col-5 col-sm-4\">\n" +
                "                          <div class=\"d-flex pt-1 align-items-center\">\n" +
                "                            <div class=\"reload-outer bg-info\">\n" +
                "                              <i class=\"mdi mdi-reload\"></i>\n" +
                "                            </div>\n" +
                "                            <div class=\"dropdown dropleft pl-1 pt-3\">\n" +
                "                              <div id=\"dropdownMenuButton5\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "                                <p><i class=\"mdi mdi-dots-vertical\"></i></p>\n" +
                "                              </div>\n" +
                "                              <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton5\">\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Sales</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Track Invoice</a>\n" +
                "                                <a class=\"dropdown-item\" href=\"#\">Payment History</a>\n" +
                "                              </div>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-4 col-md-6 grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <div id=\"inline-datepicker\" class=\"datepicker table-responsive\"></div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "              <div class=\"col-xl-4 col-md-6 stretch-card grid-margin stretch-card\">\n" +
                "                <div class=\"card\">\n" +
                "                  <div class=\"card-body\">\n" +
                "                    <h4 class=\"card-title\">Browser stats</h4>\n" +
                "                    <div class=\"row py-2\">\n" +
                "                      <div class=\"col-sm-12\">\n" +
                "                        <div class=\"d-flex justify-content-between pb-3 border-bottom\">\n" +
                "                          <div>\n" +
                "                            <img class=\"mr-2\" src=\"assets/images/browser-logo/opera-logo.png\" alt=\"\" />\n" +
                "                            <span class=\"p\">opera mini</span>\n" +
                "                          </div>\n" +
                "                          <p class=\"mb-0\">23%</p>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-2\">\n" +
                "                      <div class=\"col-sm-12\">\n" +
                "                        <div class=\"d-flex justify-content-between pb-3 border-bottom\">\n" +
                "                          <div>\n" +
                "                            <img class=\"mr-2\" src=\"assets/images/browser-logo/safari-logo.png\" alt=\"\" />\n" +
                "                            <span class=\"p\">Safari</span>\n" +
                "                          </div>\n" +
                "                          <p class=\"mb-0\">07%</p>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-2\">\n" +
                "                      <div class=\"col-sm-12\">\n" +
                "                        <div class=\"d-flex justify-content-between pb-3 border-bottom\">\n" +
                "                          <div>\n" +
                "                            <img class=\"mr-2\" src=\"assets/images/browser-logo/chrome-logo.png\" alt=\"\" />\n" +
                "                            <span class=\"p\">Chrome</span>\n" +
                "                          </div>\n" +
                "                          <p class=\"mb-0\">33%</p>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-2\">\n" +
                "                      <div class=\"col-sm-12\">\n" +
                "                        <div class=\"d-flex justify-content-between pb-3 border-bottom\">\n" +
                "                          <div>\n" +
                "                            <img class=\"mr-2\" src=\"assets/images/browser-logo/firefox-logo.png\" alt=\"\" />\n" +
                "                            <span class=\"p\">Firefox</span>\n" +
                "                          </div>\n" +
                "                          <p class=\"mb-0\">17%</p>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                    <div class=\"row py-2\">\n" +
                "                      <div class=\"col-sm-12\">\n" +
                "                        <div class=\"d-flex justify-content-between\">\n" +
                "                          <div>\n" +
                "                            <img class=\"mr-2\" src=\"assets/images/browser-logo/explorer-logo.png\" alt=\"\" />\n" +
                "                            <span class=\"p\">Explorer</span>\n" +
                "                          </div>\n" +
                "                          <p class=\"mb-0\">05%</p>\n" +
                "                        </div>\n" +
                "                      </div>\n" +
                "                    </div>\n" +
                "                  </div>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <script src=\"./assets/vendors/js/vendor.bundle.base.js\"></script>\n" +
                "    <script src=\"./assets/vendors/chart.js/Chart.min.js\"></script>\n" +
                "    <script src=\"./assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.resize.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.categories.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.fillbetween.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.stack.js\"></script>\n" +
                "    <script src=\"./assets/vendors/flot/jquery.flot.pie.js\"></script>\n" +
                "    <script src=\"./assets/js/off-canvas.js\"></script>\n" +
                "    <script src=\"./assets/js/hoverable-collapse.js\"></script>\n" +
                "    <script src=\"./assets/js/misc.js\"></script>\n" +
                "    <script src=\"./assets/js/dashboard.js\"></script>\n" +
                "  </body>\n" +
                "</html>");

    }
}
