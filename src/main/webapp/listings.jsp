<%--
  Created by IntelliJ IDEA.
  User: nuwanthapasindu
  Date: 2025-05-13
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/navbarFooter.css">
    <link rel="stylesheet" href="./assets/css/nav-light.css">
    <link rel="stylesheet" href="./assets/css/listings.css">
</head>
<body>
<!-- Header with title --->
<div class="heroWrapper">

    <jsp:include page="components/navbar-light.jsp" />

    <!-- Header with title -->
    <div class="wishlist-header mb-4">
        <h1 class="page-title">My Wishlist</h1>
    </div>
</div>
<!-- Search Bar Section -->
<section class="search-section py-4">
    <div class="container">
        <div class="search-container bg-white rounded shadow p-4">
            <div class="row g-3">
                <div class="col-lg-4 col-md-6 seearch">
                    <label class="form-label">Search</label>
                    <input type="text" class="form-control" placeholder="Enter keywords">
                </div>
                <div class="col-lg-3 col-md-6">
                    <label class="form-label">Looking For</label>
                    <select class="form-select">
                        <option selected>Type</option>
                        <option>House</option>
                        <option>Apartment</option>
                        <option>Studio</option>
                        <option>Villa</option>
                    </select>
                </div>

                <div class="col-lg-3 col-md-6">
                    <label class="form-label">Price</label>
                    <select class="form-select">
                        <option selected disabled>Price</option>
                        <option>ASC</option>
                        <option>DESC</option>
                    </select>
                </div>

                <div class="col-lg-2 col-md-6 d-flex align-items-center justify-content-center">
                    <button class="btn btn-primary p-3">
                        <i class="fas fa-search me-2"></i> Search
                    </button>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="property-listings py-5">
    <div class="container">
        <div class="row g-4">
            <a href="#!" class=" text-decoration-none col-lg-3 col-md-6 col-sm-12">
                <div class="property-card">
                    <div class="property-image">
                        <img src="<%= request.getContextPath()%>/assets/img/publicPasswordImage.png" alt="Luxury Family Home" class="img-fluid">
                    </div>
                    <div class="property-details">

                        <div class="details">
                            <h5 class=" text-dark property-title">Luxury Family Home</h5>
                            <p class=" text-dark property-address">123 Oceana Ave</p>
                        </div>
                        <div class="text-dark property-price">LKR 50,800,000</div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    </div>
</section>
<jsp:include page="components/footer.jsp" />

</body>
</html>
