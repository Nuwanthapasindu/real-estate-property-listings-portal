<%@ page import="com.replp.model.Property" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Dashboard</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/dashboard/dashboard.css">
</head>
<body>
<div class="dashboard-container">
    <jsp:include page="/components/dashboard-side.jsp" />

    <!-- Main Content -->
    <div class="main-content">
        <!-- Header with greeting -->
        <div class="dashboard-header">
            <h2>Hello <%= session.getAttribute("firstName") %> <%= session.getAttribute("lastName") %> </h2>
        </div>

        <!-- Properties Section -->
        <div class="properties-section">
            <div class="section-header d-flex justify-content-between align-items-center">
                <div class="d-flex align-items-center gap-5">
                    <h3>All Properties</h3>
                </div>
                <div class="action-buttons">
                    <a href="<%= request.getContextPath() %>/auth/publisher/property/create" class="btn btn-primary add-property-btn text-decoration-none">Add New Property</a>
                </div>
            </div>
            <% String error = request.getParameter("error"); %>
            <% if (error != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
            <% } %>
            <!-- Property Grid -->
            <div class="property-grid">
                <div class="row">
                    <% List<Property> properties = (List<Property>) request.getAttribute("properties"); %>

                    <% if (properties == null || properties.isEmpty()) { %>
                    <div class="col-md-12">
                        <div class="no-properties">
                            <p>No properties found.</p>
                        </div>
                    </div>
                    <% }else { %>
                    <% for (Property property : properties) { %>
                    <div class="col-md-6 col-lg-4 col-xl-3 mb-4">
                        <a href="<%= request.getContextPath() %>/auth/publisher/property/update?id=<%= property.getId() %>" class="property-card">
                            <div class="property-image">
                                <img src="<%= property.getImages().get(0).getPath() %>" alt="Luxury Family Home" class="img-fluid">
                            </div>
                            <div class="property-details">

                                <div class="details">
                                    <h5 class="property-title"><%= property.getTitle() %></h5>
                                    <p class="property-address"><%= property.getLocation() %></p>
                                </div>
                                <div class="property-price"> <%= property.getPrice() %></div>
                            </div>
                        </a>
                    </div>
                    <% } }%>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/assets/js/dashboard/dashboard.js"></script>
<script>
    const propertyPrices = document.querySelectorAll('.property-price');
    propertyPrices.forEach(price => {
        price.textContent = Intl.NumberFormat('en-US', { style: 'currency', currency: 'LKR' }).format(price.textContent);
    });
</script>
</body>
</html>