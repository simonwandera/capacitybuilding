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
          <a class="nav-link" data-toggle="collapse" href="#trainings" aria-expanded="false" aria-controls="trainings">
            <i class="mdi mdi-book-open-page-variant menu-icon"></i>
            <span class="menu-title">Trainings</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="trainings">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/buttons.html">Add New</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/dropdowns.html">Upcoming</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/typography.html">Ongoing</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/typography.html">Completed</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/typography.html">Cancelled</a>
              </li>
            </ul>
          </div>
      </li>

      <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#trainers" aria-expanded="false" aria-controls="trainers">
          <i class=" mdi mdi-account-network menu-icon"></i>
          <span class="menu-title">Trainers</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="trainers">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item">
              <a class="nav-link" href="pages/ui-features/buttons.html">Add New</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="pages/ui-features/dropdowns.html">Trainers</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="pages/ui-features/typography.html">Blocked</a>
            </li>
          </ul>
        </div>
      </li>


       <li class="nav-item">
          <a class="nav-link" data-toggle="collapse" href="#trainees" aria-expanded="false" aria-controls="trainees">
            <i class="mdi mdi-account-multiple menu-icon"></i>
            <span class="menu-title">Trainees</span>
            <i class="menu-arrow"></i>
          </a>
          <div class="collapse" id="trainees">
            <ul class="nav flex-column sub-menu">
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/buttons.html">Active</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="pages/ui-features/dropdowns.html">Terminated</a>
              </li>
            </ul>
          </div>
       </li>

       <li class="nav-item">
         <a class="nav-link" data-toggle="collapse" href="#report" aria-expanded="false" aria-controls="report">
           <i class=" mdi mdi-file-document menu-icon"></i>
           <span class="menu-title">Reports</span>
           <i class="menu-arrow"></i>
         </a>
         <div class="collapse" id="report">
           <ul class="nav flex-column sub-menu">
             <li class="nav-item">
               <a class="nav-link" href="pages/ui-features/buttons.html">Report 1</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="pages/ui-features/dropdowns.html">Report 2</a>
             </li>
           </ul>
         </div>
       </li>

       <li class="nav-item">
        <a class="nav-link" data-toggle="collapse" href="#settings" aria-expanded="false" aria-controls="settings">
          <i class="mdi mdi-settings menu-icon"></i>
          <span class="menu-title">Settings</span>
          <i class="menu-arrow"></i>
        </a>
        <div class="collapse" id="settings">
          <ul class="nav flex-column sub-menu">
            <li class="nav-item">
              <a class="nav-link" href="pages/ui-features/buttons.html">Settings 1</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="pages/ui-features/dropdowns.html">Settings 2</a>
            </li>
          </ul>
        </div>
       </li>

      <li class="nav-item sidebar-actions">
        <div class="nav-link">
          <div class="mt-4">
            <ul class="mt-4 pl-0">
              <li><a href="#">Sign Out</a></li>
            </ul>
          </div>
        </div>
      </li>
    </ul>
    </nav>