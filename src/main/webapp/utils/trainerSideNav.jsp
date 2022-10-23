 <nav class="sidebar sidebar-offcanvas" id="sidebar">
    <div class="text-center sidebar-brand-wrapper d-flex align-items-center">
      <a class="sidebar-brand brand-logo" href="index.html"><img src="../assets/images/logo.svg" alt="logo" /></a>
      <a class="sidebar-brand brand-logo-mini pl-4 pt-3" href="index.html"><img src="assets/images/logo-mini.svg" alt="logo" /></a>
    </div>
    <ul class="nav">
      <li class="nav-item nav-profile">
        <a href="#" class="nav-link">
          <div class="nav-profile-image">
            <img src="../assets/images/faces/face1.jpg" alt="profile" />
            <span class="login-status online"></span>
          </div>
          <div class="nav-profile-text d-flex flex-column pr-3">
            <span class="font-weight-medium mb-2">User</span>
            <span class="font-weight-normal">Admin</span>
          </div>
          <span class="badge badge-danger text-white ml-3 rounded">3</span>
        </a>
      </li>
      <li class="nav-item">
          <a class="nav-link" href="index.html">
            <i class="mdi mdi-home menu-icon"></i>
            <span class="menu-title">Dashboard</span>
          </a>
      </li>
      <li class="nav-item">
          <a class="nav-link" data-toggle="collapse" href="#training" aria-expanded="false" aria-controls="training">
            <i class="mdi mdi-book-open-page-variant menu-icon"></i>
            <span class="menu-title">Trainings</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="training">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="../training/displayTrainings.jsp">My Trainings</a>
              </li>
            </ul>
          </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.html">
          <i class="mdi mdi-home menu-icon"></i>
          <span class="menu-title">Notifications</span>
        </a>
      </li>
      <li class="nav-item sidebar-actions">
        <div class="nav-link">
          <div class="mt-4">
            <div class="border-none">
              <p class="text-black">Settings</p>
            </div>
            <ul class="mt-4 pl-0">
              <li><a href="#">Sign Out</a></li>
            </ul>
          </div>
        </div>
      </li>
    </ul>
 </nav>