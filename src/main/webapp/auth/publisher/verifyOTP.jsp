<%
    String otp = (String) request.getSession().getAttribute("otp");
    String email = (String) request.getSession().getAttribute("email");

    if (otp == null || otp.isEmpty() || email == null || email.isEmpty()) {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - OTP Verification</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="../../css/otpVerification.css">
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img src="../../img/logo.png" alt="Homez" class="logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Listings</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact Us</a>
                    </li>
                </ul>
                <div class="nav-right d-flex align-items-center">
                    <a href="#" class="btn-link me-4">
                        <i class="fas fa-user me-2"></i> Login / Register
                    </a>
                </div>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="py-5">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <img src="../../img/otpVerification.png" alt="Home Interior" class="img-fluid rounded-4 shadow-sm">
                </div>
                <div class="col-lg-6">
                    <div class="ms-lg-5">
                        <h2 class="display-6 fw-bold mb-4">Help Us Confirm It's You</h2>
                        <p class="text-muted mb-4">Please enter the OTP code sent to your device to verify your identity.</p>
                        <% String error = request.getParameter("error"); %>
                        <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= error %>
                        </div>
                        <% } %>
                        <form action="verify-otp" method="post">
                            <div class="mb-4">
                                <label for="otp" class="form-label">OTP</label>
                                <input type="text" class="form-control form-control-lg" id="otp" name="otp" placeholder="******" maxlength="6" autocomplete="off">
                                <small class="text-muted mt-2 d-block">Enter the 6-digit code sent to your device</small>
                            </div>

                            <button type="submit" class="btn btn-primary btn-lg w-100 mb-3">Sign In</button>

                            <div class="text-center mt-3">
                                <p class="mb-0">Didn't receive the code? <a href="#" class="text-primary text-decoration-none">Resend</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="bg-dark text-white py-5">
        <div class="container">
            <div class="row align-items-center text-center text-md-start py-4">
                <div class="col-md-3 mb-4 mb-md-0">
                    <a href="#" class="footer-brand d-inline-block">
                        <img src="../../img/logo-white.png" alt="Homez" class="logo">
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
                            <a href="#" class="text-white text-decoration-none">Contact Us</a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <div class="d-flex justify-content-center justify-content-md-end gap-3">
                        <a href="#" class="text-white"><i class="fab fa-twitter"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-github"></i></a>
                    </div>
                </div>
            </div>
            <div class="text-center pt-4 border-top border-secondary">
                <p class="mb-0">© Copyright 2023. All Rights Reserved by INVIDIA®</p>
            </div>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="otpVerification.js"></script>
</body>
</html>