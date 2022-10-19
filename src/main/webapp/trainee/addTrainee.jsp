<%@ include file="../utils/header.jsp"%>
<body>
    <div class="container-scroller">

     <%@ include file="../utils/sideNav.jsp"%>
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

            <%@ include file="../utils/topNav.jsp"%>

            <div class="main-panel">
                <div class="content-wrapper pb-0">
                    <div class="page-header flex-wrap">
                        <h3 class="mb-0"> Trainee Registration </h3>
                        <div class="d-flex">
                            <a href="./displayTrainees.jsp" class="btn btn-sm ml-3 btn-primary"> All Trainees </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 grid-margin stretch-card mx-auto my-3">
                    <div class="card">
                      <div class="card-body">
                        <h4 class="card-title">New Trainee</h4>
                        <p class="card-description">Basic form layout</p>
                        <form class="forms-sample" method="POST" action="../addTrainee">
                          <div class="form-group">
                            <label for="exampleInputUsername1">First name</label>
                            <input type="text" class="form-control" name="firstName" id="exampleInputUsername1" placeholder="John" />
                          </div>
                          <div class="form-group">
                            <label for="exampleInputEmail1">Last Name</label>
                            <input type="text" class="form-control" name="lastName" id="exampleInputEmail1" placeholder="Doe" />
                          </div>

                          <div class="form-group">
                            <label for="exampleInputEmail1">Email</label>
                            <input type="email" class="form-control" name="email" id="exampleInputEmail1" placeholder="johndoe@example.com" />
                          </div>

                          <div class="form-group">
                            <label for="exampleInputPassword1">Gender</label>
                            <select class="form-control" name="gender" id="exampleSelectGender">
                                <option>Male</option>
                                <option>Female</option>
                                <option>Other</option>
                            </select>
                          </div>

                          <div class= "py-1 text-center">

                            <%
                              String addTraineeError = (String) application.getAttribute("addTraineeError");
                              if (addTraineeError != null && !addTraineeError.equals("")) {
                            %>
                              <span class="text-danger"> ${applicationScope.addTraineeError} </span>
                            <% } %>
                          </div>

                          <button type="submit" class="btn btn-primary mr-2"> Submit </button>
                        </form>
                      </div>
                    </div>
                  </div>
            </div>
        </div>
      </div>
  <%@ include file="../utils/footer.jsp"%>