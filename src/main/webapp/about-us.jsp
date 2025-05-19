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
    <link rel="stylesheet" href="./assets/css/about.css">

</head>
<body>

<!-- Hero Section -->
<section class="heroWrapper">
<jsp:include page="components/navbar-light.jsp" />
    <div class="overlay"></div>
    <div class="container position-relative z-index-1">
        <div class="row min-vh-75 align-items-center text-center">
            <div class="col-lg-8 mx-auto ">
                <h1 class="display-4 text-white fw-bold mb-4">Connecting You with the<br>Right Property</h1>
            </div>
        </div>
    </div>
</section>
<!-- Experience Section -->
<section class="experience-section py-5 mt-5">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-7">
                <h2 class="section-title">More than 10 Years of Experience</h2>
                <p class="section-subtitle">Lorem ipsum dolor sit amet consectetur adipisicing</p>

                <div class="stats-container d-flex justify-content-between mt-5">
                    <div class="stat-item">
                        <h3 class="stat-number">85%</h3>
                        <p class="stat-text">Completed Property</p>
                    </div>
                    <div class="stat-item">
                        <h3 class="stat-number">99%</h3>
                        <p class="stat-text">Satisfied Customers</p>
                    </div>
                    <div class="stat-item">
                        <h3 class="stat-number">95%</h3>
                        <p class="stat-text">Online Ownership</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-5">
                <div class="agent-image">
                    <img src="<%= request.getContextPath() %>/assets/img/agent.jpg" alt="Real Estate Agent" class="img-fluid">
                </div>
            </div>
        </div>
    </div>
</section>



<!-- Selling Options Section -->
<section class="selling-options py-5">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <h2 class="section-title">Let's Find The Right<br>Selling Option For You</h2>
                <p class="section-subtitle mb-4">At vero eos et accusamus et iusto odio dignissimos, qui blanditiis praesentium voluptatum.</p>

                <div class="selling-features">
                    <div class="feature-item d-flex align-items-center mb-3">
                        <div class="feature-icon">
                            <i class="fas fa-check-circle"></i>
                        </div>
                        <p class="feature-text mb-0">Find available listings</p>
                    </div>
                    <div class="feature-item d-flex align-items-center mb-3">
                        <div class="feature-icon">
                            <i class="fas fa-check-circle"></i>
                        </div>
                        <p class="feature-text mb-0">Consult with a real expert</p>
                    </div>
                    <div class="feature-item d-flex align-items-center">
                        <div class="feature-icon">
                            <i class="fas fa-check-circle"></i>
                        </div>
                        <p class="feature-text mb-0">Seal your next property</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="selling-images position-relative">
                    <div class="main-image">
                        <img src="<%= request.getContextPath() %>/assets/img/property.jpg" alt="Property" class="img-fluid rounded">
                    </div>
                    <div class="secondary-image">
                        <img src="<%= request.getContextPath() %>/assets/img/property1.jpg" alt="Family with agent" class="img-fluid rounded">
                    </div>
                    <div class="agents-section">
                        <p class="small-text mb-2">Our Licensed Agents</p>
                        <div class="agent-avatars d-flex">
                            <div class="agent-avatar"><img src="<%= request.getContextPath() %>/assets/img/a1.jpg" alt="Agent 1" class="rounded-circle"></div>
                            <div class="agent-avatar"><img src="<%= request.getContextPath() %>/assets/img/a2.jpg" alt="Agent 2" class="rounded-circle"></div>
                            <div class="agent-avatar"><img src="<%= request.getContextPath() %>/assets/img/a3.jpg" alt="Agent 3" class="rounded-circle"></div>
                            <div class="agent-avatar"><img src="<%= request.getContextPath() %>/assets/img/a4.jpg" alt="Agent 4" class="rounded-circle"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<jsp:include page="components/footer.jsp" />
</body>
</html>
