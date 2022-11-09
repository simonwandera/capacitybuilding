<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>

<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>


<jsp:useBean id="traineeController" class="com.capacitybuilding.controllers.TraineeController" />

<cht:Header title="Display dashboard | Capacity building" />
<body>
    <div class="container-scroller">

     <%@ include file="../utils/sideNav.jsp"%>
        <div class="container-fluid page-body-wrapper">
            <div id="theme-settings" class="settings-panel">
              <i class="settings-close mdi mdi-close"></i>
              <p class="settings-heading">SIDEBAR SKINS</p>
              <div class="sidebar-bg-options selected" id="sidebar-default-theme">
                <div class="img-ss rounded-circle bg-light border mr-3"></div> Default
              </div>
              <div class="sidebar-bg-options" id="sidebar-dark-theme">
                <div class="img-ss rounded-circle bg-dark border mr-3"></div> Dark
              </div>
              <p class="settings-heading mt-2">HEADER SKINS</p>
              <div class="color-tiles mx-0 px-4">
                <div class="tiles light"></div>
                <div class="tiles dark"></div>
              </div>
            </div>

            <%@ include file="../utils/topNav.jsp"%>

            <div class="main-panel">
                <div class="content-wrapper pb-0">
                    <div class="page-header flex-wrap">
                        <h3 class="mb-0"> All Trainees </h3>
                        <div class="d-flex">
                            <a href="../addTrainee" class="btn btn-sm ml-3 btn-success"> Add Trainee </a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h4 class="card-title">All Registered Trainees</h4>
                        <p class="card-description"> Updated </p>
                        <div class="table-responsive">

                        <table class="table table-striped">
                            <thead>
                               <tr>
                                <th>User</th>
                                <th>First name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>Gender</th>
                                <th>Date</th>
                                <th>Action</th>
                              </tr>
                            </thead>
                            <tbody>

                               <%

                               List<Trainee> trainees = traineeController.list((Connection) application.getAttribute("dbConnection"), new Trainee());

                               for(Trainee trainee : trainees) {


                                %>

                                <td class="py-1">
                                    <img src="../assets/images/faces-clipart/pic-1.png" alt="image" />
                                </td>
                                <td><%= trainee.getFirstName() </td>
                                <td><%= trainee.getLastName()  %></td>
                                <td><%= trainee.getEmail()  %></td>
                                <td><%= trainee.getGender() %></td>
                                <td><%= new Date() %></td>
                                <td>
                                    <a href="./updateTrainee?id=<%= trainee.getId() %>"  ><i class="mdi mdi-border-color mdi-24px"></i></a>
                                    <a href="./deleteTrainee?id=<%= trainee.getId() %>"  ><i class="mdi mdi-delete md-24 mdi-24px text-danger"></i></a>
                                </td>
                                </tr>
                                <% } %>

                            </tbody>
                        </table>

                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

  <cft:Footer />
