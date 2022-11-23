<%@ page isELIgnored="false" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>

<cht:Header title="Admin dashboard | Capacity building" />

<body>
<div class="container-scroller">
  <%@ include file="../utils/adminSideNav.jsp"%>
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

    <%@ include file="../utils/adminTopNav.jsp"%>

    <jc:set value="${sessionScope.activeUser}" var="activeUser"/>

    <div class="main-panel">
      <div class="content-wrapper pb-0">
        <div class="page-header flex-wrap">
          <h3 class="mb-0"> Hi, welcome ${activeUser.firstName} <span class="pl-0 h6 pl-sm-2 text-muted d-inline-block">Capacity building trainee dashboard.</span>
          </h3>
          <div class="d-flex">
            <a href="../admin/addUser.jsp" class="btn btn-sm ml-3 btn-success">Add User</a>
          </div>
        </div>
        <div class="row">
          <div class="col-xl-3 col-lg-12 stretch-card grid-margin">
            <div class="row">
              <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3">
                <div class="card bg-warning">
                  <div class="card-body px-3 py-4">
                    <div class="d-flex justify-content-between align-items-start">
                      <div class="color-card">
                        <p class="mb-0 color-card-head">Enrolled Trainings</p>
                        <h2 class="text-white">${enrollmentBean.getEnrollments().size()}<span class="h5"></span>
                        </h2>
                      </div>
                      <i class="card-icon-indicator mdi mdi-basket bg-inverse-icon-warning"></i>
                    </div>
                    <h6 class="text-white">80% Enrolled</h6>
                  </div>
                </div>
              </div>
              <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3">
                <div class="card bg-danger">
                  <div class="card-body px-3 py-4">
                    <div class="d-flex justify-content-between align-items-start">
                      <div class="color-card">
                        <p class="mb-0 color-card-head">Trainees</p>
                        <h2 class="text-white"> ${userBean.getTrainees(activeUser).size()} </h2>
                      </div>
                      <i class="card-icon-indicator mdi mdi-cube-outline bg-inverse-icon-danger"></i>
                    </div>
                    <h6 class="text-white"> More enrollments this month</h6>
                  </div>
                </div>
              </div>
              <div class="col-xl-12 col-md-6 stretch-card grid-margin grid-margin-sm-0 pb-sm-3 pb-lg-0 pb-xl-3">
                <div class="card bg-primary">
                  <div class="card-body px-3 py-4">
                    <div class="d-flex justify-content-between align-items-start">
                      <div class="color-card">
                        <p class="mb-0 color-card-head">Trainers</p>
                        <h2 class="text-white">${userBean.getTrainers().size()}<span class="h5"></span>
                        </h2>
                      </div>
                      <i class="card-icon-indicator mdi mdi-briefcase-outline bg-inverse-icon-primary"></i>
                    </div>
                    <h6 class="text-white">10x professionals</h6>
                  </div>
                </div>
              </div>

            </div>
          </div>
          <div class="col-xl-9 stretch-card grid-margin">
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="col-sm-7">
                    <h5>Training Survey</h5>
                    <p class="text-muted"> Recent overview </p>
                  </div>

                </div>
                <div class="row">
                  <div class="col-sm-4">
                    <div class="card mb-3 mb-sm-0">
                      <div class="card-body py-3 px-4">
                        <p class="m-0 survey-head">Total Enrollments</p>
                        <div class="d-flex justify-content-between align-items-end flot-bar-wrapper">
                          <div>
                            <h3 class="m-0 survey-value">${enrollmentBean.getEnrollments().size()}</h3>
                            <p class="text-success m-0">${enrollmentBean.getApprovedEnrollments().size()}</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="card mb-3 mb-sm-0">
                      <div class="card-body py-3 px-4">
                        <p class="m-0 survey-head">Assessments</p>
                        <div class="d-flex justify-content-between align-items-end flot-bar-wrapper">
                          <div>
                            <h3 class="m-0 survey-value">${assessmentBean.list().size()}</h3>
                            <p class="text-danger m-0">Total assessments</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="card">
                      <div class="card-body py-3 px-4">
                        <p class="m-0 survey-head">Trainer assignments</p>
                        <div class="d-flex justify-content-between align-items-end flot-bar-wrapper">
                          <div>
                            <h3 class="m-0 survey-value">${assignTrainerBean.list().size()}</h3>
                          </div>
                          <div id="orderChart" class="flot-chart"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-sm-8">
                    <p class="text-muted mb-0"> Post COVID-19, we will have to do more, with less. Learn why capacity-building is essential for your organization's productivity. <b>Learn More</b>
                    </p>
                  </div>

                </div>
              </div>
            </div>
          </div>
        </div>


      </div>
    </div>
    <cft:Footer />

