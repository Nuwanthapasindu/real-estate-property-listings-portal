<%@ page import="com.replp.services.PropertyService" %>
<%@ page import="com.replp.model.Property" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.replp.model.CommercialProperty" %>
<%@ page import="com.replp.model.ResidentialProperty" %>
<%@ page import="com.replp.model.IndustrialProperty" %>
<%
    CommercialProperty commercialProperty =null;
    ResidentialProperty residentialProperty = null;
    IndustrialProperty industrialProperty = null;
    String propertyType = null;
    PropertyService propertyService = new PropertyService();
    Optional<Property> propertyOptional = propertyService.findByID(request.getParameter("id").toString());
    if (propertyOptional.isEmpty()) {
        response.sendRedirect(request.getContextPath() + "/listings.jsp?error=Property not found");
        return;
    }

    Property property = propertyOptional.get();
    if (property instanceof CommercialProperty) {
        commercialProperty = (CommercialProperty) property;
        propertyType = "commercial";
    } else if (property instanceof ResidentialProperty) {
        residentialProperty = (ResidentialProperty) property;
        propertyType = "residential";
    } else if (property instanceof IndustrialProperty) {
        industrialProperty = (IndustrialProperty) property;
        propertyType = "industrial";
    }
    
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= property.getTitle() %> | Homez</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/navbarFooter.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/singleProperty.css">
    <style>
        .property-type-badge .badge {
            font-size: 0.8rem;
            font-weight: 500;
            padding: 0.5rem 0.8rem;
        }
        .no-image-placeholder {
            height: 300px;
            background-color: #f8f9fa;
            border: 1px dashed #dee2e6;
        }
        .specific-detail-item {
            padding: 0.5rem 0;
            border-bottom: 1px solid #dee2e6;
        }
    </style>
</head>
<body>

<jsp:include page="/components/navbar-dark.jsp" />
    <!-- Main Content -->
    <main>
        <!-- Property Hero Section -->
        <div class="container pt-5">
            <div class="property-hero">
                <% if(property.getImages() != null && !property.getImages().isEmpty()) { %>
                <img src="<%= property.getImages().get(0).getPath() %>" alt="<%= property.getTitle() %>" class="img-fluid w-100 rounded-4">
                <% } else { %>
                <div class="no-image-placeholder rounded-4 d-flex align-items-center justify-content-center">
                    <p class="text-muted">No image available</p>
                </div>
                <% } %>
            </div>
        </div>
    
        <div class="container my-5">
            <!-- Property Header -->
            <div class="row">
                <div class="col-12">
                    <h1 class="property-title"><%= property.getTitle() %></h1>
                    <div class="property-type-badge my-2">
                        <span class="badge bg-primary"><%= propertyType.toUpperCase() %> PROPERTY</span>
                    </div>
                </div>
            </div>

            <!-- Property Details -->
            <div class="row mt-4">
                <div class="col-12">
                    <div class="property-details-box">
                        <div class="row">
                            <div class="col-md-4 property-detail-item d-flex align-items-center flex-column gap-3">
                                <i class="fas fa-tag"></i>
                                <h3>LKR <%= String.format("%,.2f", property.getPrice()) %></h3>
                            </div>
                            <div class="col-md-4 property-detail-item d-flex align-items-center flex-column gap-3">
                                <i class="fas fa-vector-square"></i>
                                <h3><%= property.getSize() %> <%= property.getSizeType() != null ? property.getSizeType() : "m<sup>2</sup>" %></h3>
                            </div>
                            <div class="col-md-4 property-detail-item d-flex align-items-center flex-column gap-3">
                                <i class="fas fa-map-marker-alt"></i>
                                <h3><%= property.getLocation() %></h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Property Type-Specific Details -->
            <div class="row mt-4">
                <div class="col-12">
                    <div class="property-specific-details p-4 bg-light rounded">
                        <h4 class="mb-3">Additional Details</h4>
                        <div class="row">
                            <% if (propertyType.equals("residential") && residentialProperty != null) { %>
                                <div class="col-md-4 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-bed me-2 text-primary"></i>
                                        <span class="fw-bold">Bedrooms:</span> <%= residentialProperty.getBedrooms() %>
                                    </div>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-bath me-2 text-primary"></i>
                                        <span class="fw-bold">Bathrooms:</span> <%= residentialProperty.getBathrooms() %>
                                    </div>
                                </div>
                                <div class="col-md-4 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-car me-2 text-primary"></i>
                                        <span class="fw-bold">Garage:</span> <%= residentialProperty.isHasGarage() ? "Yes" : "No" %>
                                    </div>
                                </div>
                            <% } else if (propertyType.equals("commercial") && commercialProperty != null) { %>
                                <div class="col-md-6 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-building me-2 text-primary"></i>
                                        <span class="fw-bold">Business Type:</span> <%= commercialProperty.getBusinessType() %>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-parking me-2 text-primary"></i>
                                        <span class="fw-bold">Parking Available:</span> <%= commercialProperty.isHasParking() ? "Yes" : "No" %>
                                    </div>
                                </div>
                            <% } else if (propertyType.equals("industrial") && industrialProperty != null) { %>
                                <div class="col-md-6 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-industry me-2 text-primary"></i>
                                        <span class="fw-bold">Industry Type:</span> <%= industrialProperty.getIndustryType() %>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <div class="specific-detail-item">
                                        <i class="fas fa-truck-loading me-2 text-primary"></i>
                                        <span class="fw-bold">Loading Dock:</span> <%= industrialProperty.isHasLoadingDock() ? "Yes" : "No" %>
                                    </div>
                                </div>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Property Description -->
            <div class="row mt-5">
                <div class="col-12">
                    <h4 class="mb-3">Property Description</h4>
                    <div class="property-description">
                        <%= property.getDescription() %>
                    </div>
                </div>
            </div>

            <!-- Property Gallery -->
            <div class="row mt-5">
                <div class="col-12">
                    <h2 class="mb-4">Property Gallery</h2>
                </div>
                <% if(property.getImages() != null && !property.getImages().isEmpty()) { 
                    for(int i = 0; i < property.getImages().size(); i++) { %>
                        <div class="col-md-4 mb-4">
                            <img src="<%= property.getImages().get(i).getPath() %>"
                                 alt="<%= property.getTitle() %> - Image <%= i+1 %>" 
                                 class="img-fluid rounded gallery-img">
                        </div>
                    <% } 
                } else { %>
                    <div class="col-12">
                        <p class="text-muted">No gallery images available</p>
                    </div>
                <% } %>
            </div>
            
            <!-- Contact Information -->
            <div class="row mt-5">
                <div class="col-12">
                    <div class="contact-box p-4 bg-light rounded">
                        <h4 class="mb-3">Interested in this property?</h4>
                        <p>Contact us for more information or to schedule a viewing.</p>
                        <div class="d-flex flex-column flex-md-row gap-3">
                            <a href="#" class="btn btn-primary">
                                <i class="fas fa-phone me-2"></i> Contact Agent
                            </a>

                            <form action="auth/public/wishlist/add" method="post">
                            <input type="hidden" name="propertyId" value="<%= property.getId() %>" />
                            <button type="submit" class="btn btn-outline-primary">
                                <i class="fas fa-heart me-2"></i> Add to Wishlist
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

<jsp:include page="components/footer.jsp" />
</body>
</html>
