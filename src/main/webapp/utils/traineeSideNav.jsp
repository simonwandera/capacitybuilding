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
            <span class="font-weight-medium mb-2">Usertype</span>
            <span class="font-weight-normal">User</span>
          </div>
          <span class="badge badge-danger text-white ml-3 rounded">3</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../main/traineeDashboard.jsp">
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
        <a class="nav-link" href="../enrollment/userEnrollments.jsp">
          <i class="mdi mdi-account-multiple menu-icon"></i>
          <span class="menu-title">My Enrollments</span>
        </a>
      </li>

      <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#assessments" aria-expanded="false" aria-controls="assessments">
          <i class="mdi mdi-book-open-page-variant menu-icon"></i>
          <span class="menu-title">Assessments</span>
          <i class="menu-arrow"></i>
        </a>

        <div class="collapse" id="assessments">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item">
              <a class="nav-link" href="../assessments/userAssessments.jsp">All assessments</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../assessments/userGroupedAverage.jsp">Grouped averages</a>
            </li>
          </ul>
        </div>

      </li>
      <li class="nav-item">
        <a class="nav-link" href="../training/userCompletedTrainings.jsp">
          <i class="mdi mdi-chart-bar menu-icon"></i>
          <span class="menu-title">Completed Trainings</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="pages/forms/basic_elements.html">
          <i class="mdi mdi-format-list-bulleted menu-icon"></i>
          <span class="menu-title">Report</span>
        </a>
      </li>

    </ul>
    </nav>