<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.user.model.Usertype" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>

<cht:Header title="Add Training | Capacity building" />
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

                    <%@ include file="../utils/trainerTopNav.jsp" %>

                        <div class="main-panel">
                            <div class="content-wrapper pb-0">
                                <div class="page-header flex-wrap">
                                    <h3 class="mb-0"> New Training </h3>

                                </div>

                                <div class="row">
                                    <div class="col-12 grid-margin">
                                        <div class="card">
                                            <div class="card-body">
                                                <div>
                                                    <h4 class="card-title">Add training*</h4>
                                                </div>
                                                <form class="form-sample" action="../addTraining" method="POST">
                                                    <p class="card-description">Training info</p>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 col-form-label">Title</label>
                                                                <div class="col-sm-9">
                                                                    <input type="text" name="title" class="form-control" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 col-lg-6 col-form-label">Duration(Weeks)</label>
                                                                <div class="col-sm-9">
                                                                    <input type="number" name="duration" class="form-control" min="1" max="50" required />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 col-form-label">Start Date</label>
                                                                <div class="col-sm-9">
                                                                    <input type="date" name="startDate" class="form-control" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 col-form-label">Description</label>
                                                                <div class="col-sm-9">
                                                                    <textarea class="form-control" name="description"></textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="my-3 py-2 text-center">
                                                         <%
                                                              String trainingError = (String) application.getAttribute("trainingError");
                                                              if (trainingError != null && !trainingError.equals("")) {
                                                            %>
                                                              <span class="text-danger"> <%= application.getAttribute("trainingError") %> </span>
                                                            <% } %>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary mr-2"> Add </button>

                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                          <cft:Footer />