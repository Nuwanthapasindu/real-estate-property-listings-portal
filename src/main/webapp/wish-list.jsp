<%@ page import="com.replp.services.wishlist.WishlistService" %>
<%@ page import="com.replp.services.wishlist.WishlistServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.replp.model.Property" %><%
    Boolean isAuthenticatedObj = (Boolean) request.getSession().getAttribute("isAuthenticated");
    boolean isAuthenticated = isAuthenticatedObj != null && isAuthenticatedObj.booleanValue();
    if (!isAuthenticated) {
        response.sendRedirect(request.getContextPath()+"/");
        return;
    }
    String userId = request.getSession().getAttribute("userId").toString();

    WishlistService wishlistService = new WishlistServiceImpl();

   List<Property> wishlist =  wishlistService.getWishlist(userId);



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
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/navbarFooter.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/nav-light.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/wishlist.css">
    <style>
        .empty-wishlist {
            background-color: #f8f9fa;
            border-radius: 8px;
            padding: 30px;
            margin-bottom: 20px;
        }

        .no-image-placeholder {
            height: 150px;
            width: 100%;
            background-color: #f8f9fa;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 8px;
        }

        .no-image-placeholder i {
            font-size: 3rem;
            color: #adb5bd;
        }

        .wishlist-item {
            display: flex;
            margin-bottom: 20px;
            background: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }

        .wishlist-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }

        .property-image {
            flex: 0 0 200px;
            overflow: hidden;
        }

        .property-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .property-info {
            flex: 1;
            padding: 15px;
        }

        .property-title {
            font-size: 1.2rem;
            margin-bottom: 8px;
        }

        .property-address {
            color: #6c757d;
            margin-bottom: 8px;
        }

        .property-price {
            font-weight: bold;
            color: #212529;
            font-size: 1.1rem;
        }

        .property-actions {
            display: flex;
            flex-direction: column;
            justify-content: center;
            padding: 15px;
            gap: 10px;
        }
        @media (max-width: 768px) {
            .wishlist-item {
                flex-direction: column;
            }

            .property-image {
                flex: 0 0 180px;
                width: 100%;
            }

            .property-actions {
                flex-direction: row;
                padding: 15px;
            }
        }
    </style>
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
            <% if (wishlist == null || wishlist.isEmpty()) { %>
                <div class="empty-wishlist">
                    <div class="text-center py-5">
                        <i class="fas fa-heart-broken fa-4x text-muted mb-3"></i>
                        <h3>Your wishlist is empty</h3>
                        <p class="text-muted">Save properties you like by clicking the heart icon</p>
                        <a href="<%= request.getContextPath() %>/listings.jsp" class="btn btn-primary mt-3">
                            <i class="fas fa-search me-2"></i> Browse Properties
                        </a>
                    </div>
                </div>
            <% } else { %>
                <% for (Property property : wishlist) { %>
                    <div class="wishlist-item">
                        <div class="property-image">
                            <% if (property.getImages() != null && !property.getImages().isEmpty()) { %>
                                <img src="<%= property.getImages().get(0).getPath() %>"
                                     alt="<%= property.getTitle() %>">
                            <% } else { %>
                                <div class="no-image-placeholder">
                                    <i class="fas fa-home"></i>
                                </div>
                            <% } %>
                        </div>
                        <div class="property-info">
                            <h3 class="property-title"><%= property.getTitle() %></h3>
                            <p class="property-address"><i class="fas fa-map-marker-alt me-2"></i> <%= property.getLocation() %></p>
                            <div class="property-price">LKR <%= String.format("%,.2f", property.getPrice()) %></div>
                        </div>
                        <div class="property-actions">
                            <a href="<%= request.getContextPath() %>/single-property.jsp?id=<%= property.getId() %>" class="btn view-btn">
                                View Details
                            </a>
                            <form action="<%= request.getContextPath() %>/auth/public/wishlist/remove" method="post" class="d-inline">
                                <input type="hidden" name="propertyId" value="<%= property.getId() %>">
                                <button type="submit" class="btn btn-outline-dark remove-btn">
                                    <i class="fas fa-trash-alt me-2"></i> Remove
                                </button>
                            </form>
                        </div>
                    </div>
                <% } %>
            <% } %>
        </div>
    </main>
    <jsp:include page="components/footer.jsp" />
</body>
</html>