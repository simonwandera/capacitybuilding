<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.user.model.Usertype" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>

<cht:Header title="Add Training | Capacity building"/>

<body>
<div class="container-scroller">

    <jc:set value="${sessionScope.activeUser}" var="activeUser"/>

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

            <% String trainingId = request.getParameter("trainingId");
                pageContext.setAttribute("trainingId", trainingId);
            %>

        <jc:set value="${uploadsBean.getUploads(trainingBean.getTraining(Long.valueOf(trainingId)))}"
                var="uploads"/>

        <div class="main-panel">
            <div class="content-wrapper pb-0">
                <div class="page-header flex-wrap">
                    <h3 class="mb-0"> Resources for ${trainingBean.getTraining(Long.valueOf(trainingId)).title}</h3>
                </div>

                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <jc:choose>
                                <jc:when test="${uploads.size() < 1}">
                                    <h4 class="mb-1">No records to display</h4>
                                </jc:when>
                                <jc:otherwise>

                                    <h4 class="card-title">Uploads</h4>
                                    <p class="card-description"> Date: ${LocalDate.now()} </p>
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>File</th>
                                                <th>Date Added</th>
                                                <th>Delete</th>

                                            </tr>
                                            </thead>
                                            <tbody>

                                            <jc:forEach items="${uploads}" var="upload">
                                                <tr>

                                                    <td>${upload.fileName}</td>
                                                    <td>${upload.timeCreated}</td>
                                                    <td><a href="./modals.jsp"><i
                                                            class=" mdi mdi-delete-forever mdi-24px"></i></a></td>

                                                    <%@ include file="./modals.jsp" %>

                                                </tr>
                                            </jc:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </jc:otherwise>
                            </jc:choose>

                        </div>
                    </div>
                </div>

                <div class="col-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Upload resources</h4>
                            <form class="form-inline" action="../uploadFile" method="post" enctype="multipart/form-data">
                                <label class="sr-only" for="file">File</label>
                                <input type="file" class="form-control mb-2 mr-sm-2" id="file"
                                       placeholder="Jane Doe"/>
                                <button type="submit" class="btn btn-primary mb-2"> Upload</button>
                            </form>
                        </div>
                    </div>
                </div>


            </div>
        </div>
<cft:Footer/>