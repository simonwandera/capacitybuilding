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
                        <h3 class="mb-0"> All Trainees </h3>
                        <div class="d-flex">
                            <a href="./addTrainee" class="btn btn-sm ml-3 btn-success"> Add Trainee </a>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12 grid-margin stretch-card">
                    <div class="card">
                      <div class="card-body">
                        <h4 class="card-title">All Registered Trainees</h4>
                        <p class="card-description"> Updated </p>
                        <div class="table-responsive">

                        <table>
                        </table>

                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

<%@ include file="../utils/footer.jsp"%>

