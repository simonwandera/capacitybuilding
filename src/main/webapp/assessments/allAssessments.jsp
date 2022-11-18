<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.user.model.Usertype" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>

<cht:Header title="Add Training | Capacity building"/>

<body>
<div class="container-scroller">

    <jc:choose>
    <jc:when test="${sessionScope.userType == Usertype.ADMIN}">
        <jsp:include page="../utils/adminSideNav.jsp"/>
    </jc:when>
    <jc:when test="${sessionScope.userType == Usertype.TRAINER}">
        <jsp:include page="../utils/trainerSideNav.jsp"/>
    </jc:when>
    <jc:when test="${sessionScope.userType == Usertype.USER}">
        <jsp:include page="../utils/traineeSideNav.jsp"/>
    </jc:when>
    </jc:choose>

    <div class="container-fluid page-body-wrapper">
        <div id="theme-settings" class="settings-panel">
            <i class="settings-close mdi mdi-close"></i>
            <p class="settings-heading">SIDEBAR SKINS</p>
            <div class="sidebar-bg-options selected" id="sidebar-default-theme">
                <div class="img-ss rounded-circle bg-light border mr-3"></div>
                Default
            </div>
            <div class="sidebar-bg-options" id="sidebar-dark-theme">
                <div class="img-ss rounded-circle bg-dark border mr-3"></div>
                Dark
            </div>
            <p class="settings-heading mt-2">HEADER SKINS</p>
            <div class="color-tiles mx-0 px-4">
                <div class="tiles light"></div>
                <div class="tiles dark"></div>
            </div>
        </div>

        <%@ include file="../utils/trainerTopNav.jsp" %>

        <div class="main-panel">
            <div class="content-wrapper pb-0">
                <div class="page-header flex-wrap">
                    <h3 class="mb-0"> All assessments </h3>
                </div>

                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Enrollments</h4>
                            <p class="card-description"> Record details </p>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Trainee Name</th>
                                        <th>Training Title</th>
                                        <th>Date Enrolled</th>
                                        <th>Score</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <jc:forEach items="${assessmentBean.getAssesments()}" var="assessment">
                                        <tr>

                                            <td>${assessment.enrollment.trainee.firstName} ${assessment.enrollment.trainee.firstName}</td>
                                            <td>${assessment.enrollment.training.title}</td>
                                            <td>${assessment.enrollment.timeCreated}</td>
                                            <td>${assessment.score}</td>
                                            <td>${assessment.remarks}</td>

                                            <td>
                                                <div class="dropdown">
                                                    <button class="btn btn-primary dropdown-toggle" type="button" id="drop6" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        <i class="mdi mdi-security"></i>
                                                    </button>
                                                    <div class="dropdown-menu bg-secondary" aria-labelledby="drop6">
                                                        <h6 class="dropdown-header">Settings</h6>
                                                        <button type="button" class="dropdown-item" data-toggle="modal" data-target="#modal${enrollment.id}">
                                                            Approve
                                                        </button>
                                                        <div class="dropdown-divider"></div>
                                                        <button type="button" class="dropdown-item" data-toggle="modal" data-target="#modal_delete${enrollment.id}">
                                                            Delete
                                                        </button>
                                                    </div>
                                                </div>
                                            </td>

                                            <%@ include file="./modals.jsp" %>

                                        </tr>
                                    </jc:forEach>


                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                </div>


            </div>
        </div>
<cft:Footer/>