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
                    <h3 class="mb-0"> System Users </h3>

                </div>

                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Users</h4>
                            <p class="card-description"> User details </p>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>User</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Gender</th>
                                        <th>Usertype</th>
                                        <th>Date Created</th>
                                        <th>Edit</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <jc:forEach items="${userBean.list()}" var="user">
                                    <tr>
                                        <td class="py-1">
                                            <img src="https://shorturl.at/qrCQ9" alt="image"/>
                                        </td>
                                        <td>${user.firstName} ${user.lastName}</td>
                                        <td>
                                           ${user.username}
                                        </td>
                                        <td>${user.gender}</td>
                                        <td>${user.userType}</td>
                                        <td>${user.timeCreated}</td>

                                        <td>
                                            <a href="updateUser.jsp?id=${user.id}" ><i class="mdi mdi-border-color mdi-24px"></i></a>
                                        </td>

                                        <td>
                                            <div class="dropdown">
                                                <button class="btn btn-primary dropdown-toggle" type="button" id="drop6" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="mdi mdi-security"></i>
                                                </button>
                                                <div class="dropdown-menu bg-secondary" aria-labelledby="drop6">
                                                    <h6 class="dropdown-header">Settings</h6>
                                                    <a class="btn-link" href="#">ResetPassword</a>

                                                    <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modal${user.id}">
                                                        Edit privileges
                                                    </button>

                                                    <div class="dropdown-divider"></div>
                                                    <a class="dropdown-item text-danger" href="#">Deactivate</a>
                                                </div>
                                            </div>
                                        </td>

                                        <div class="modal fade" id="modal${user.id}" tabindex="-1" role="dialog"
                                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">

                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>


                                                    <div class="card">
                                                        <div class="card-body">
                                                            <h4 class="card-title">Change Usertype</h4>
                                                            <p class="card-description">Select Usertype</p>

                                                            <form method="POST" action="../changeUsertype">
                                                                <div class="form-group row">
                                                                    <div class="col">
                                                                        <input type="hidden" name="id" value="${user.id}">
                                                                        <label>Name</label>
                                                                        <div id="the-basics">
                                                                            <input class="typeahead border border-success" type="text"
                                                                                   placeholder="Your name" disabled value="${user.firstName} ${user.lastName}"/>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col">
                                                                        <label>Usertype</label>
                                                                        <div id="bloodhound">

                                                                            <select class="form-control border border-success" name="userType" id="exampleSelectGender">
                                                                                <option>USER</option>
                                                                                <option>TRAINER</option>
                                                                                <option>ADMIN</option>
                                                                            </select>

                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                                </div>
                                                            </form>

                                                        </div>
                                                    </div>

                                                </div>

                                            </div>
                                        </div>

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