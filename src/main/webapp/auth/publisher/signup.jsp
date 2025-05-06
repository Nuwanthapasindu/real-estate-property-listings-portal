<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Real Estate</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="../../css/styles.css">
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
                <div class="nav-right">
                    <a href="#" class="btn btn-link">
                        <div class="user-icon-circle">
                            <i class="fas fa-user"></i>
                        </div>
                        Login / Register
                    </a>
                </div>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="row align-items-center min-vh-100">
            <div class="col-md-6">
                <img src="../../img/Image.png" alt="Modern Architecture" class="img-fluid rounded">
            </div>
            <div class="col-md-6">
                <div class="signup-form">
                    <h1 class="mb-4">Let's level up your brand, together</h1>
                   <% String error = request.getParameter("error"); %>
                   <% if (error != null) { %>
                    <div class="alert alert-danger" role="alert">
                     <%= error %>
                    </div>
                    <% } %>
                    <form id="signupForm" action="register" method="POST">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Your first name">
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Your last name">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="you@company.com">
                        </div>
                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="+1 (555) 000-0000">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Your password">
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-type your password">
                        </div>
                        <button type="submit" class="btn w-100 btn-primary">Signup</button>
                    </form>
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
                    <div class="social-links d-flex justify-content-center justify-content-md-end gap-4">
                        <a href="#" class="text-white"><i class="fab fa-twitter"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-github"></i></a>
                    </div>
                </div>
            </div>
            <hr class="my-4 border-secondary">
            <div class="text-center py-3">
                <p class="mb-0">© Copyright 2025. All Rights Reserved by NVIDIAR</p>
            </div>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/script.js"></script>
</body>
</html>