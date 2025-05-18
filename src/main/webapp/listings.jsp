<%@ page import="com.replp.services.PropertyService" %>
<%@ page import="com.replp.model.Property" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nuwanthapasindu
  Date: 2025-05-13
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Property> properties = null;
    PropertyService propertyService = new PropertyService();
    
    String typeParam = request.getParameter("type") != null? request.getParameter("type").toString():"";
    String searchParam = request.getParameter("search") != null? request.getParameter("search").toString():"";
    String priceParam = request.getParameter("price") != null? request.getParameter("price").toString():"ASC";

    properties = propertyService.filterProperties(typeParam, searchParam, priceParam);

%>


        <html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Properties</title>
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
    <div class="d-flex align-items-center justify-content-center h-100">
        <h1 class="page-title">All Listings in One Place</h1>
    </div>
</div>
<!-- Search Bar Section -->
<section class="search-section py-4">
    <div class="container">
        <form method="get">
            <div class="search-container bg-white rounded shadow p-4">
                <div class="row g-3">
                    <div class="col-lg-4 col-md-6">
                        <label class="form-label">Search</label>
                        <input type="text" class="form-control" name="search" placeholder="Enter keywords"
                               value="<%= searchParam != null ? searchParam : "" %>">
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <label class="form-label">Property Type</label>
                        <select class="form-select" name="type">
                            <option value="" <%= typeParam == null ? "selected" : "" %>>All Types</option>
                            <option value="ResidentialProperty" <%= "ResidentialProperty".equals(typeParam) ? "selected" : "" %>>Residential</option>
                            <option value="CommercialProperty" <%= "CommercialProperty".equals(typeParam) ? "selected" : "" %>>Commercial</option>
                            <option value="IndustrialProperty" <%= "IndustrialProperty".equals(typeParam) ? "selected" : "" %>>Industrial</option>
                        </select>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <label class="form-label">Price Order</label>
                        <select class="form-select" name="price">
                            <option value="" <%= priceParam == null ? "selected" : "" %>>Default</option>
                            <option value="ASC" <%= "ASC".equals(priceParam) ? "selected" : "" %>>Low to High</option>
                            <option value="DESC" <%= "DESC".equals(priceParam) ? "selected" : "" %>>High to Low</option>
                        </select>
                    </div>

                    <div class="col-lg-2 col-md-6 d-flex align-items-center justify-content-center">
                        <button class="btn btn-primary p-3 w-100" type="submit">
                            <i class="fas fa-search me-2"></i> Search
                        </button>
                    </div>
                </div>
            </div>
            <div class="mt-3 text-end">
                <a href="<%= request.getContextPath() %>/listings.jsp" class="text-decoration-none">
                    <i class="fas fa-times me-1"></i> Clear Filters
                </a>
            </div>
        </form>
    </div>
</section>

<section class="property-listings py-5">
    <div class="container">
        <div class="row g-4">

            <% if (properties == null || properties.isEmpty()) { %>
            <div class="col-md-12">
                <h1 class="alert alert-info">
                    No properties found.
                </h1>
            </div>
            <% } else { for (Property property : properties) { %>
            <a href="<%= request.getContextPath() %>/single-property.jsp?id=<%= property.getId() %>" class="text-decoration-none col-lg-3 col-md-6 col-sm-12">
                <div class="property-card">
                    <div class="property-image">
                        <% if(property.getImages() != null && !property.getImages().isEmpty()) { %>
                            <img src="<%= property.getImages().get(0).getPath() %>" alt="<%= property.getTitle() %>" class="img-fluid">
                        <% } else { %>
                            <div class="no-image-placeholder">
                                <i class="fas fa-home"></i>
                            </div>
                        <% } %>
                    </div>
                    <div class="property-details">
                        <div class="details">
                            <h5 class="text-dark property-title"><%= property.getTitle() %></h5>
                            <p class="text-dark property-address"><i class="fas fa-map-marker-alt me-1"></i> <%= property.getLocation() %></p>
                        </div>
                        <div class="text-dark property-price">LKR <%= String.format("%,.2f", property.getPrice()) %></div>
                    </div>
                </div>
            </a>
            <% } } %>
        </div>
    </div>
    </div>
</section>
<jsp:include page="components/footer.jsp" />
<style>
    .no-image-placeholder {
        height: 200px;
        background-color: #f8f9fa;
        display: flex;
        align-items: center;
        justify-content: center;
        border-radius: 0.25rem;
    }

    .no-image-placeholder i {
        font-size: 3rem;
        color: #adb5bd;
    }

    .property-card {
        transition: transform 0.3s ease;
        height: 100%;
        border: 1px solid #dee2e6;
        border-radius: 0.5rem;
        overflow: hidden;
    }

    .property-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 10px 20px rgba(0,0,0,0.1);
    }
</style>
</body>
</html>
