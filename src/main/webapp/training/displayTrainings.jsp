<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>

<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jfn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>


<jsp:useBean id="trainingController" class="com.capacitybuilding.controllers.TrainingController" />

<cht:Header title="Display trainings | Capacity building" />

<body>
    <div class="container-scroller">
    <%@ include file="../utils/trainerSideNav.jsp"%>
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

        <%@ include file="../utils/trainerTopNav.jsp"%>

        <div class="main-panel">
          <div class="content-wrapper pb-0">
            <div class="page-header flex-wrap">
              <h3 class="mb-0"> My Trainings
              </h3>
            </div>

             <div class="dropdown py-3">
                <button class="btn btn-warning btn-lg dropdown-toggle" type="button" id="dropdownMenuSizeButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Filter </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuSizeButton1">
                  <h6 class="dropdown-header">Filter</h6>
                  <a class="dropdown-item" href="#">Upcoming</a>
                  <a class="dropdown-item" href="#">Ongoing</a>
                  <a class="dropdown-item" href="#">Completed</a>
                  <a class="dropdown-item" href="#">Cancelled</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">All</a>
                </div>
             </div>

             <div class="row">

             <%

                List<Training> trainings = trainingController.list((Connection) application.getAttribute("dbConnection"));
                pageContext.setAttribute("trainings", trainings);

             %>
             <jc:forEach items="${trainings}" var="training">
                 <div class="col-xl-4 col-sm-6 grid-margin stretch-card">
                     <div class="card">
                         <div class="card-body">
                             <div class="card-title font-weight-medium">
                                 <h5>${jfn:toUpperCase(training.title)}</h6>
                             </div>
                             <p class="text-muted">

                                ${training.description.length() < 50 ? training.description : Str.description.substring(0, 50)}
                             </p>
                             <div class="d-flex flex-wrap border-bottom py-2 border-top justify-content-between">
                                 <img class="survey-img mb-lg-3" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="" />
                                 <div class="pt-2">
                                     <h5 class="mb-0">Facilitator</h5>
                                     <p class="mb-0 text-muted">Kevin Mugoye</p>
                                 </div>
                             </div>
                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <img class="survey-img mb-lg-3" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="" />
                                 <div class="pt-2">
                                     <h5 class="mb-0">Luxury villa in Hermo</h5>
                                     <p class="mb-0 text-muted">Glendale, CA</p>
                                 </div>
                             </div>
                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <img class="survey-img mb-lg-3" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="" />
                                 <div class="pt-2">
                                     <h5 class="mb-0">House on the Clarita</h5>
                                     <p class="mb-0 text-muted">Business Survey</p>
                                 </div>
                             </div>
                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <div class="dropdown py-2">
                                     <button class="btn btn-info dropdown-toggle" type="button" id="options"
                                         data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Options
                                     </button>
                                     <div class="dropdown-menu" aria-labelledby="options">
                                         <h6 class="dropdown-header">Options</h6>
                                         <a class="dropdown-item" href="#">Enrolled trainees</a>
                                         <a class="dropdown-item" href="#">Enrollment requests</a>
                                         <a class="dropdown-item" href="#">Activate</a>
                                         <div class="dropdown-divider"></div>
                                         <a class="dropdown-item" href="#">Feedback</a>
                                     </div>
                                 </div>
                                 <div>
                                     <a class="text-success mt-3 d-block font-weight-regular h6" href="#">${training.duration} Weeks<i class="mdi mdi-chevron-right"></i></a>
                                 </div>

                             </div>
                         </div>
                     </div>
                 </div>
                 </jc:forEach>


             </div>


          </div>
        </div>
        <cft:Footer />

