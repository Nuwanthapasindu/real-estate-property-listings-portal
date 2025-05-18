<%
    Boolean isAuthenticatedObj = (Boolean) request.getSession().getAttribute("isAuthenticated");
    boolean isAuthenticated = isAuthenticatedObj != null && isAuthenticatedObj.booleanValue();

    if (!isAuthenticated) {
        response.sendRedirect(request.getContextPath()+"/");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - My Wishlist</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/navbarFooter.css">
    <link rel="stylesheet" href="./assets/css/nav-light.css">
    <link rel="stylesheet" href="./assets/css/wishlist.css">
</head>
<body>
    <div class="heroWrapper">

        <jsp:include page="components/navbar-light.jsp" />
    
        <!-- Header with title -->
        <div class="wishlist-header mb-4">
            <h1 class="page-title">My Wishlist</h1>
        </div>
    </div>
    <!-- Main Content -->
    <main class="container py-5">
        <!-- Wishlist Items -->
        <div class="wishlist-container">

                <!-- Wishlist Item 1 -->
                <div class="wishlist-item">
                    <div class="property-image">
                        <img src="<%= request.getContextPath()%>/assets/img/wishlistHeroBanner.jpg" alt="The Pinnacle at Havelock">
                    </div>
                    <div class="property-info">
                        <div class="property-badges d-flex gap-3">
                            <span> <i class="fas fa-bed"></i> 4 Bedrooms</span>
                            <span> <i class="fas fa-bath"></i> 2 Bathrooms</span>
                        </div>
                        <h3 class="property-title">The Pinnacle at Havelock</h3>
                        <p class="property-address"><i class="fas fa-map-marker-alt"></i> 123 Havelock Road, Colombo</p>
                        <div class="property-price">LKR 120,000,000.00</div>
                    </div>
                    <div class="property-actions">
                        <button class="btn view-btn">View Details</button>
                        <button class="btn btn-outline-dark remove-btn">Remove from Wishlist</button>
                    </div>
                </div>

                
            </div>
    </main>
    <jsp:include page="components/footer.jsp" />
</body>
</html>