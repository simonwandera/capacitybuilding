<%@ page isELIgnored="false" %>
<%@ taglib prefix="jc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="cht" uri="../WEB-INF/tlds/header.tld" %>
<%@ taglib prefix="cft" uri="../WEB-INF/tlds/footer.tld" %>

<cht:Header title="Login page | Capacity building" />

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper">
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="page-header">
            <h3 class="page-title m-auto">
                ${applicationScope.appName}
            </h3>
          </div>
          <div class="row">
            <div class="col-md-6 grid-margin stretch-card m-auto">
              <div class="card">
                <div class="card-body">
                  <div class="mb-5">
                    <h4 class="card-title">LogIn</h4>
                  </div>
                  <form class="forms-sample" action= "../login" method="post">
                    <div class="form-group">
                      <label for="exampleInputEmail1">Email address</label>
                      <input type="email" class="form-control" name="username" id="email" placeholder="Email" />
                    </div>
                    <div class="form-group">
                      <label for="exampleInputPassword1">Password</label>
                      <input type="password" class="form-control" name="password" id="password" placeholder="Password" />
                    </div>
                    <div class="form-check form-check-flat form-check-primary">
                      <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" /> Remember me </label>
                    </div>
                    <div class="my-3 py-2 text-center">
                    <%
                      String loginError = (String) application.getAttribute("loginError");
                      if (loginError != null && !loginError.equals("")) {
                    %>
                      <span class="text-danger"> <%= application.getAttribute("loginError") %> </span>
                    <% } %>

                    </div>
                    <button type="submit" class="btn btn-primary mr-2"> Login </button>
                    <a href="./register.jsp">Register</a>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <cft:Footer />
