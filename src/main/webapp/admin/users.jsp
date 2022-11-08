<%@ page isELIgnored="false" %>
<%@ page import="com.capacitybuilding.model.*" %>
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
                    <h3 class="mb-0"> System Users </h3>

                </div>


                <div class="col-xl-10 col-lg-11 col-sm-6 grid-margin shadow-sm">
                    <div class="card">
                        <div class="card-body px-0 overflow-auto">
                            <h4 class="card-title pl-4">Users</h4>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="bg-light">
                                    <tr>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Email</th>
                                        <th>Gender</th>
                                        <th>Date Added</th>
                                        <th>Usertype</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="assets/images/faces/face1.jpg" alt="image"/>
                                                <div class="table-user-name ml-3">
                                                    <p class="mb-0 font-weight-medium"> Cecelia Cooper </p>
                                                    <small> Payment on hold</small>
                                                </div>
                                            </div>
                                        </td>
                                        <td>Angular Admin</td>
                                        <td>
                                            <div class="badge badge-inverse-success"> Completed</div>
                                        </td>
                                        <td>$ 77.99</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="assets/images/faces/face10.jpg" alt="image"/>
                                                <div class="table-user-name ml-3">
                                                    <p class="mb-0 font-weight-medium"> Victor Watkins </p>
                                                    <small>Email verified</small>
                                                </div>
                                            </div>
                                        </td>
                                        <td>Angular Admin</td>
                                        <td>
                                            <div class="badge badge-inverse-success"> Completed</div>
                                        </td>
                                        <td>$245.30</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="assets/images/faces/face11.jpg" alt="image"/>
                                                <div class="table-user-name ml-3">
                                                    <p class="mb-0 font-weight-medium"> Ada Burgess </p>
                                                    <small>Email verified</small>
                                                </div>
                                            </div>
                                        </td>
                                        <td>One page html</td>
                                        <td>
                                            <div class="badge badge-inverse-danger"> Completed</div>
                                        </td>
                                        <td>$ 160.25</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="assets/images/faces/face13.jpg" alt="image"/>
                                                <div class="table-user-name ml-3">
                                                    <p class="mb-0 font-weight-medium"> Dollie Lynch </p>
                                                    <small>Email verified</small>
                                                </div>
                                            </div>
                                        </td>
                                        <td>Wordpress</td>
                                        <td>
                                            <div class="badge badge-inverse-success"> Declined</div>
                                        </td>
                                        <td>$ 123.21</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <img src="assets/images/faces/face16.jpg" alt="image"/>
                                                <div class="table-user-name ml-3">
                                                    <p class="mb-0 font-weight-medium"> Harry Holloway </p>
                                                    <small>Payment on process</small>
                                                </div>
                                            </div>
                                        </td>
                                        <td>VueJs Application</td>
                                        <td>
                                            <div class="badge badge-inverse-danger"> Declined</div>
                                        </td>
                                        <td>$ 150.00</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <a class="text-black mt-3 d-block pl-4" href="#">
                                <span class="font-weight-medium h6">View all order history</span>
                                <i class="mdi mdi-chevron-right"></i></a>
                        </div>
                    </div>
                </div>


            </div>
        </div>
<cft:Footer/>