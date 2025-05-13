<%
  Boolean isAuthenticatedObj = (Boolean) request.getSession().getAttribute("isAuthenticated");
  boolean isAuthenticated = isAuthenticatedObj != null && isAuthenticatedObj.booleanValue();
%>


<nav class="navbar navbar-expand-lg navbar-light bg-transparent">
  <div class="container">
    <a class="navbar-brand" href="<%= request.getContextPath()%>/">
      <img src="<%= request.getContextPath()%>/assets/img/logo-white.png" alt="Homez" class="logo">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/listings.jsp">Listings</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/about-us.jsp">About Us</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%= request.getContextPath()%>/wish-list.jsp">Wish List</a>
        </li>
      </ul>
      <div class="nav-right">
        <% if (!isAuthenticated) { %>
        <a href="<%= request.getContextPath()%>/auth/public/login.jsp" class="btn btn-link">
          <div class="user-icon-circle">
            <i class="fas fa-user"></i>
          </div>
          Login / Register
        </a>
        <% } else { %>
        <a href="<%= request.getContextPath()%>/auth/public/logout" class="btn btn-link">
          <div class="user-icon-circle">
            <i class="fas fa-user"></i>
          </div>
          Logout
        </a>
        <% } %>
      </div>
      <div class="nav-right become-partner">
        <a href="#" class="btn btn-primary">
          Become a Property <br> Partner
        </a>
      </div>
    </div>
  </div>
</nav>