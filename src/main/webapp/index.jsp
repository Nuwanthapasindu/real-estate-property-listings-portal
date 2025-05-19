<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Find Your Dream Property</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Google Fonts - Inter -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/navbarFooter.css">
    <link rel="stylesheet" href="./assets/css/nav-light.css">
    <link rel="stylesheet" href="./assets/css/wishlist.css">
    <link rel="stylesheet" href="./assets/css/home.css">

</head>
<body>

<!-- Hero Section -->
<section class="heroWrapper">
<jsp:include page="components/navbar-light.jsp" />
    <div class="overlay"></div>
    <div class="container position-relative z-index-1">
        <div class="row min-vh-75 align-items-center text-center">
            <div class="col-lg-8 mx-auto">
                <h1 class="display-4 text-white fw-bold mb-4">The Best Way to Find Your Dream Property</h1>
            </div>
        </div>
    </div>
</section>

<!-- Category Section -->
<section class="category-section py-5">
    <div class="container">
        <div class="row justify-content-center">
            <!-- Buy Category -->
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="category-card text-center p-4 h-100">
                    <div class="icon-circle mb-3 mx-auto">
                        <i class="fas fa-home"></i>
                    </div>
                    <h3 class="mb-3">Buy a Property</h3>
                    <p class="text-muted">Find your place with an immersive photo experience and the most listings, including things you won't find anywhere else.</p>
                </div>
            </div>

            <!-- Sell Category -->
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="category-card text-center p-4 h-100">
                    <div class="icon-circle mb-3 mx-auto">
                        <i class="fas fa-dollar-sign"></i>
                    </div>
                    <h3 class="mb-3">Sell a Property</h3>
                    <p class="text-muted">No matter what path you take to sell your home, we can help you navigate a successful sale with lower fees.</p>
                </div>
            </div>

            <!-- Rent Category -->
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="category-card text-center p-4 h-100">
                    <div class="icon-circle mb-3 mx-auto">
                        <i class="fas fa-key"></i>
                    </div>
                    <h3 class="mb-3">Rent a Property</h3>
                    <p class="text-muted">We're creating a seamless online experience – from shopping on the largest rental network to applying to paying rent.</p>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- Selling Guidance Section -->
<section class="selling-guidance py-5">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 mb-4 mb-lg-0">
                <h2 class="section-title mb-4">We'll Guide You Through The Selling Process</h2>
                <p class="mb-4">Selling your home can be complicated—but it doesn't have to be. We can help you navigate the selling process, avoid costly mistakes, and get the highest price for your property.</p>

                <ul class="check-list mb-4">
                    <li><i class="fas fa-check-circle text-primary me-2"></i> Get a free home valuation</li>
                    <li><i class="fas fa-check-circle text-primary me-2"></i> Professional photography and virtual tours</li>
                    <li><i class="fas fa-check-circle text-primary me-2"></i> Listing on major real estate platforms</li>
                    <li><i class="fas fa-check-circle text-primary me-2"></i> Dedicated agent to handle showings and offers</li>
                    <li><i class="fas fa-check-circle text-primary me-2"></i> Assistance with paperwork and closing</li>
                </ul>

                <a href="#" class="btn btn-primary">Learn More <i class="fas fa-arrow-right ms-2"></i></a>
            </div>

            <div class="col-lg-6">
                <div class="row g-3">
                    <div class="col-6">
                        <img src="<%= request.getContextPath() %>/assets/img/h1.png" alt="Happy Couple" class="img-fluid rounded shadow-sm">
                    </div>
                    <div class="col-6 pt-5">
                        <img src="<%= request.getContextPath() %>/assets/img/h2.png" alt="Modern House" class="img-fluid rounded shadow-sm">
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- CTA Section -->
<section class="cta-section py-5 bg-light-gray">
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-lg-8">
                <h2 class="section-title mb-4">Need Help? Talk To Our Expert.</h2>
                <div class="d-flex flex-column flex-md-row justify-content-center gap-3">
                    <a href="#" class="btn btn-outline-dark px-4 py-2">
                        <i class="fas fa-envelope me-2"></i> Contact Us
                    </a>
                    <a href="tel:+1234567890" class="btn btn-dark px-4 py-2">
                        <i class="fas fa-phone-alt me-2"></i> +1 (234) 567-890
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer py-4 bg-dark-blue text-white">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-4 mb-3 mb-md-0">
                <a class="footer-brand d-flex align-items-center" href="#">
                    <div class="logo-circle me-2">
                        <i class="fas fa-home text-white"></i>
                    </div>
                    <span>homez</span>
                </a>
                <p class="mt-2 mb-0 small">Your trusted partner in real estate since 2010</p>
            </div>
            <div class="col-md-4 mb-3 mb-md-0 text-center">
                <ul class="nav justify-content-center">
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Home</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Properties</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">About Us</a></li>
                    <li class="nav-item"><a href="#" class="nav-link px-2 text-white">Contact Us</a></li>
                </ul>
            </div>
            <div class="col-md-4 text-center text-md-end">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item">
                        <a href="#" class="text-white">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="text-white">
                            <i class="fab fa-twitter"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="text-white">
                            <i class="fab fa-instagram"></i>
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="#" class="text-white">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom JS -->
<script src="script.js"></script>
</body>
</html>
