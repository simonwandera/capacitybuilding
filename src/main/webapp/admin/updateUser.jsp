<%@ page isELIgnored="false" %>

<%@ page import="com.capacitybuilding.model.*" %>

<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>


<cht:Header title="Update User | Capacity building"/>

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

            <% String userId = request.getParameter("id");
                pageContext.setAttribute("userId", userId);
            %>

        <%@ include file="../utils/trainerTopNav.jsp" %>

        <jc:set value="${userBean.getUser(Long.valueOf(userId))}" var="user"/>

        <div class="main-panel">
            <div class="content-wrapper pb-0">
                <div class="page-header flex-wrap">
                    <h3 class="mb-0"> Update Training
                    </h3>

                </div>

                    <div class="col-md-8 grid-margin stretch-card mx-auto">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Update user</h4>
                                <p class="card-description">Fill the user details</p>
                                <form class="forms-sample" action="../updateUser" method="POST">
                                    <input type="hidden" name="id" value="${user.id}">
                                    <div class="form-group">
                                        <label for="firstName">First Name</label>
                                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Username" value="${user.firstName}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="lastName">Last Name</label>
                                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last name" value="${user.lastName}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="username">Email</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Email" value="${user.username}" />
                                    </div>
                                    <div class="form-group">
                                        <label for="gender">Gender</label>
                                        <select class="form-control form-control-lg" name="gender" id="gender">
                                            <jc:choose>
                                                <jc:when test="${user.gender.equalsIgnoreCase(\"Male\")}">
                                                    <option>--Select gender--</option>
                                                    <option selected>Male</option>
                                                    <option>Female</option>
                                                    <option>Other</option>
                                                </jc:when>
                                                <jc:when test="${user.gender.equalsIgnoreCase(\"Female\")}">
                                                    <option>--Select gender--</option>
                                                    <option>Male</option>
                                                    <option selected>Female</option>
                                                    <option>Other</option>
                                                </jc:when>
                                                <jc:when test="${user.gender.equalsIgnoreCase(\"Other\")}">
                                                    <option>--Select gender--</option>
                                                    <option>Male</option>
                                                    <option>Female</option>
                                                    <option selected>Other</option>
                                                </jc:when>
                                                <jc:otherwise>
                                                    <option>--Select gender--</option>
                                                    <option>Male</option>
                                                    <option>Female</option>
                                                    <option>Other</option>
                                                </jc:otherwise>
                                            </jc:choose>

                                        </select>
                                    </div>

                                    <jc:choose>
                                        <jc:when test="${applicationScope.updateError != null || applicationScope.updateError != \"\"}">
                                            <span class="text-danger">${applicationScope.updateError}</span><br>
                                        </jc:when>
                                    </jc:choose>

                                    <button type="submit" class="btn btn-primary mr-2"> Submit </button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

            </div>
        </div>
<cft:Footer/>