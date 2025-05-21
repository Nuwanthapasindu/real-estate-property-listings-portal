<!-- Sidebar Navigation -->
<div class="sidebar">

  <div class="sidebar-header">
    <a href="#" class="logo-container">
      <img src="<%= request.getContextPath() %>/assets/img/logo.png" alt="Homez" class="logo">
    </a>
  </div>

  <div class="sidebar-menu">
    <ul class="nav flex-column">
      <li class="nav-item <%= request.getRequestURI().endsWith("dashboard.jsp") ? "active":"" %>">
        <a class="nav-link" href="<%= request.getContextPath() %>/auth/publisher/property">
          <i class="fas fa-th-large"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item <%= request.getRequestURI().endsWith("profileUpdate.jsp") ? "active":"" %>">
        <a class="nav-link" href="<%= request.getContextPath() %>/auth/publisher/profile">
          <i class="fas fa-user"></i>
          <span>Profile</span>
        </a>
      </li>
      <li class="nav-item%>">
        <a class="nav-link" href="<%= request.getContextPath() %>/auth/publisher/logout">
          <i class="fa-solid fa-right-from-bracket"></i>
          <span>Logout</span>
        </a>
      </li>
    </ul>
  </div>
  <div class="sidebar-footer">
    <div class="user-info">
      <img src="../PropertyDetails/agent.jpg" alt="User" class="user-avatar">
      <div class="user-details">
        <h6><%= session.getAttribute("firstName") %></h6>
        <p>Publisher</p>
      </div>
    </div>
  </div>
</div>