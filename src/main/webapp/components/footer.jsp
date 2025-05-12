<%@ page import="java.util.Date" %>
<!-- Footer -->
<footer class="bg-dark text-white py-5">
  <div class="container">
    <div class="row align-items-center text-center text-md-start py-4">
      <div class="col-md-3 mb-4 mb-md-0">
        <a href="#" class="footer-brand d-inline-block">
          <img src="<%= request.getContextPath()%>/assets/img/logo-white.png" alt="Homez" class="logo">

        </a>
      </div>
      <div class="col-md-6 mb-4 mb-md-0">
        <ul class="list-unstyled d-flex flex-column flex-md-row justify-content-center mb-0 gap-3">
          <li class="mb-3 mb-md-0">
            <a href="#" class="text-primary text-decoration-none">Home</a>
          </li>
          <li class="mb-3 mb-md-0 ms-md-4">
            <a href="#" class="text-white text-decoration-none">Properties</a>
          </li>
          <li class="mb-3 mb-md-0 ms-md-4">
            <a href="#" class="text-white text-decoration-none">About Us</a>
          </li>
          <li class="mb-3 mb-md-0 ms-md-4">
            <a href="#" class="text-white text-decoration-none">Wish List</a>
          </li>
        </ul>
      </div>
      <div class="col-md-3">
        <div class="social-links d-flex justify-content-center justify-content-md-end gap-3">
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-facebook-f"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
          <a href="#"><i class="fab fa-github"></i></a>
        </div>
      </div>
    </div>
    <hr class="border-secondary">
    <p class="text-center mb-0">&copy; Copyright 2025. All Rights Reserved by PG-277</p>
  </div>
</footer>

<!-- JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath()%>/assets/js/script.js"></script>