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
                    <h3 class="mb-0"> Add User </h3>
                </div>

                <div class="col-md-6 grid-margin stretch-card m-auto">

                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Default form</h4>
                            <p class="card-description">Basic form layout</p>
                            <form class="forms-sample" action="../createUser" method="post">
                                <div class="form-group">
                                    <label for="firstName">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Jane" required />
                                </div>
                                <div class="form-group">
                                    <label for="lastName">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Doe" required/>
                                </div>

                                <div class="form-group">
                                    <label for="email">Email address</label>
                                    <input type="email" class="form-control" id="email" name="username" placeholder="janedoe@example.com" required />
                                </div>

                                <div class="form-group">
                                    <label>Gender</label>
                                    <select class="js-example-basic-multiple" name="gender" style="width: 100%;">
                                        <option value="--Select Gender--">--Select Gender--</option>
                                        <option value="Male">MALE</option>
                                        <option value="Female">FEMALE</option>
                                        <option value="Other">OTHER</option>
                                    </select>

                                </div>

                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" name = "password" required/>
                                </div>
                                <div class="form-group">
                                    <label for="confirmPassword">Confirm Password</label>
                                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required/>
                                </div>

                                <div class="my-1 py-2 text-center">
                                    <%
                                        String addUserError = (String) application.getAttribute("addUserError");
                                        if (addUserError != null && !addUserError.equals("")) {
                                    %>
                                    <span class="text-danger"> <%= application.getAttribute("trainingError") %> </span>
                                    <% } %>
                                </div>
                                <button type="submit" class="btn btn-primary mr-2"> Submit </button>
                            </form>
                        </div>
                    </div>
                </div>


            </div>
        </div>
<cft:Footer/>