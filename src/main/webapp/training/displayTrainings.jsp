<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.model.*" %>
<%@ page import="com.capacitybuilding.controllers.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>


<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jf" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jfn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>


<cht:Header title="Display trainings | Capacity building" />


<body>
    <div class="container-scroller">
    <jc:choose>
        <jc:when test="${sessionScope.userType.equals(\"ADMIN\")}">
            <jsp:include page="../utils/adminSideNav.jsp" />
        </jc:when>
        <jc:when test="${sessionScope.userType.equals(\"TRAINER\")}">
            <jsp:include page="../utils/trainerSideNav.jsp" />
         </jc:when>
        <jc:when test="${sessionScope.userType.equals(\"USER\")}">
            <jsp:include page="../utils/traineeSideNav.jsp" />
        </jc:when>
    </jc:choose>

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
              <h3 class="mb-0"> My Trainings </h3>
            </div>
            <div>
              <h5 class="text-muted">${trainingController.list.size()} Courses</h5>
            </div>

             <div class="dropdown py-2 d-flex justify-content-end">
                <button class="btn btn-warning btn-lg dropdown-toggle" type="button" id="dropdownMenuSizeButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Filter </button>
                <div class="dropdown-menu bg-secondary" aria-labelledby="dropdownMenuSizeButton1">
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

             <jc:forEach items="${trainingController.list}" var="training">
                 <div class="col-xl-4 col-sm-6 grid-margin stretch-card">
                     <div class="card">
                         <div class="card-body">
                             <div class="card-title font-weight-medium">
                                 <h5>${jfn:toUpperCase(training.title)}</h6>
                             </div>

                             <div class="mb-2 border-bottom">
                                 <p class="text-muted">
                                    ${training.description.length() < 50 ? training.description : training.description.substring(0, 50).concat("...")}
                                 </p>
                             </div>

                            <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                <div class="pt-2">
                                    <h5 class="mb-0"> ${training.duration} weeks</h5>
                                    <p class="mb-0 text-muted">Start Date - ${training.startDate}</p>
                                </div>
                            </div>

                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <div class="pt-2">
                                     <h6><p class="mb-0 text-info">Enrolled trainees: ${enrollmentController.getTrainees(training).size()}</p></h6>
                                 </div>
                             </div>

                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <img class="survey-img mb-lg-3" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="" />
                                 <div class="pt-2">

                                     <h5 class="mb-0">Trainer</h5>

                                     <jc:forEach items="${assignTrainerController.getTrainers(training)}" var="trainer">
                                        <h5><p class="mb-0 text-muted">${trainer.firstName }  ${trainer.lastName}</p></h5>
                                     </jc:forEach>

                                 </div>
                             </div>

                             <div class="d-flex flex-wrap border-bottom py-2 justify-content-between">
                                 <div class="dropdown py-2">
                                     <button class="btn btn-success dropdown-toggle" type="button" id="options"
                                         data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Options
                                     </button>
                                     <div class="dropdown-menu" aria-labelledby="options">
                                         <h6 class="dropdown-header">Options</h6>
                                         <a class="dropdown-item" href="#">Enroll</a>
                                         <a class="dropdown-item" href="#">Enrolled trainees</a>
                                         <a class="dropdown-item" href="#">Enrollment requests</a>
                                         <a class="dropdown-item" href="#">Activate</a>
                                         <div class="dropdown-divider"></div>
                                         <a class="dropdown-item" href="#">Feedback</a>
                                     </div>
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

