 <nav class="navbar col-lg-12 col-12 p-lg-0 fixed-top d-flex flex-row">
  <div class="navbar-menu-wrapper d-flex align-items-stretch justify-content-between">
    <a class="navbar-brand brand-logo-mini align-self-center d-lg-none" href="index.html"><img src="assets/images/logo-mini.svg" alt="logo" /></a>
    <button class="navbar-toggler navbar-toggler align-self-center mr-2" type="button" data-toggle="minimize">
      <i class="mdi mdi-menu"></i>
    </button>
    
    <ul class="navbar-nav">
      <li class="nav-item dropdown">
        <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
          <i class="mdi mdi-bell-outline"></i>
          <span class="count count-varient1">2</span>
        </a>
        <div class="dropdown-menu navbar-dropdown navbar-dropdown-large preview-list" aria-labelledby="notificationDropdown">
          <h6 class="p-3 mb-0">Notifications</h6>
          <a class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <img src="assets/images/faces/face4.jpg" alt="" class="profile-pic" />
            </div>
            <div class="preview-item-content">
              <p class="mb-0"> Mark Mwima <span class="text-small text-muted">Registered for training</span>
              </p>
            </div>
          </a>
          <a class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <img src="assets/images/faces/face3.jpg" alt="" class="profile-pic" />
            </div>
            <div class="preview-item-content">
              <p class="mb-0"> James Korir <span class="text-small text-muted">Enrolled for training</span>
              </p>
            </div>
          </a>
          <a class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <img src="assets/images/faces/face2.jpg" alt="" class="profile-pic" />
            </div>
            <div class="preview-item-content">
              <p class="mb-0"> Mercy Bore <span class="text-small text-muted">Completed one training</span>
              </p>
            </div>
          </a>
          <div class="dropdown-divider"></div>
          <p class="p-3 mb-0">View all activities</p>
        </div>
      </li>
      <li class="nav-item dropdown d-none d-sm-flex">
        <a class="nav-link count-indicator dropdown-toggle" id="messageDropdown" href="#" data-toggle="dropdown">
          <i class="mdi mdi-email-outline"></i>
          <span class="count count-varient2">5</span>
        </a>
        <div class="dropdown-menu navbar-dropdown navbar-dropdown-large preview-list" aria-labelledby="messageDropdown">
          <h6 class="p-3 mb-0">Messages</h6>
          <a class="dropdown-item preview-item">
            <div class="preview-item-content flex-grow">
              <span class="badge badge-pill badge-success">Request</span>
              <p class="text-small text-muted ellipsis mb-0"> Suport needed for this user </p>
            </div>
            <p class="text-small text-muted align-self-start"> 4:10 PM </p>
          </a>
          <a class="dropdown-item preview-item">
            <div class="preview-item-content flex-grow">
              <span class="badge badge-pill badge-warning">Competencies</span>
              <p class="text-small text-muted ellipsis mb-0"> Most of the users are Scoring high </p>
            </div>
            <p class="text-small text-muted align-self-start"> 4:10 PM </p>
          </a>
          <a class="dropdown-item preview-item">
            <div class="preview-item-content flex-grow">
              <span class="badge badge-pill badge-danger">Training</span>
              <p class="text-small text-muted ellipsis mb-0"> Two trainings are scheduled to end tomorrow </p>
            </div>
            <p class="text-small text-muted align-self-start"> 4:10 PM </p>
          </a>
          <h6 class="p-3 mb-0">See all activity</h6>
        </div>
      </li>

    </ul>
    <ul class="navbar-nav navbar-nav-right ml-lg-auto">

      <li class="nav-item nav-profile dropdown border-0">
        <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown">
          <img class="nav-profile-img mr-2" alt="" src="../assets/images/faces/face1.jpg" />
          <span class="profile-name"><%= session.getAttribute("username") %></span>
        </a>
        <div class="dropdown-menu navbar-dropdown w-100" aria-labelledby="profileDropdown">
          <a class="dropdown-item" href="#">
            <i class="mdi mdi-logout mr-2 text-primary"></i> Signout </a>
        </div>
      </li>
    </ul>
    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
      <span class="mdi mdi-menu">dd</span>
    </button>
  </div>
</nav>