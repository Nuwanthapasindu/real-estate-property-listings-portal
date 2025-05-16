<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.replp.model.*" %>
<%
    Property property = (Property) request.getAttribute("property");
    if (property == null) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND);
        return;
    }
    CommercialProperty commercialProperty = null;
    ResidentialProperty residentialProperty = null;
    IndustrialProperty industrialProperty = null;
    String propertyType = property.getClass().getSimpleName();

    if (property instanceof CommercialProperty) {
        commercialProperty = (CommercialProperty) property;
    } else if (property instanceof ResidentialProperty) {
        residentialProperty = (ResidentialProperty) property;
    } else if (property instanceof IndustrialProperty) {
        industrialProperty = (IndustrialProperty) property;
    }

%>
<%
    DecimalFormat decimalFormat = new DecimalFormat("#.##"); // or use "#,###.##" for thousands separator
    String formattedPrice = decimalFormat.format(property.getPrice());
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Edit Property</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/main.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard/dashboard.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/dashboard/createProperty.css">

</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar Navigation -->
    <jsp:include page="/components/dashboard-side.jsp" />

    <!-- Main Content -->
    <div class="main-content">
        <!-- Header with back button and title -->
        <div class="dashboard-header mb-4">
            <div class="d-flex align-items-center">
                <a href="<%= request.getContextPath() %>/auth/publisher/property" class="back-link me-3">
                    <i class="fas fa-arrow-left"></i> Add New Properties
                </a>
            </div>
        </div>

        <!-- Add Property Form -->
        <div class="properties-section">
            <div class="section-header d-flex justify-content-end align-items-center mb-4">
                <div class="action-buttons">

                    <form action="<%= request.getContextPath() %>/auth/publisher/property/delete" method="post">
                        <input type="hidden" name="propertyId" value="<%= property.getId() %>">
                        <button type="submit" class="btn btn-danger add-property-btn">Delete Property</button>
                    </form>
                </div>
            </div>

            <!-- Property Form -->
            <form id="propertyForm">
                <input type="hidden" readonly name="propertyId" value="<%= property.getId() %>">
                <div class="mb-4">
                    <label for="propertyTitle" class="form-label">Property Title</label>
                    <input type="text" class="form-control" id="propertyTitle" placeholder="Property Title" readonly  value="<%= property.getTitle() %>">
                </div>

                <div class="mb-4">
                    <label for="propertyType" class="form-label">Property Type</label>
                    <select class="form-select" id="propertyType" disabled >
                        <option selected> <%= propertyType %> </option>
                    </select>
                </div>

                <div class="mb-4">
                    <label for="location" class="form-label">Location</label>
                    <input type="text" class="form-control" id="location" placeholder="Location" value="<%= property.getLocation() %>" >
                </div>

                <div class="mb-4">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" class="form-control" id="price" placeholder="Price" value="<%= formattedPrice %>" >
                </div>

                <div class="mb-4">
                    <label for="size" class="form-label">Size</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="size" value="<%= property.getSize() %>">
                        <select class="form-select" id="sizeUnit">
                            <option <%= "Perch".equalsIgnoreCase(property.getSizeType())? "selected":"" %>>Perch</option>
                            <option <%= "Sq ft".equalsIgnoreCase(property.getSizeType())? "selected":"" %>>Sq ft</option>
                            <option <%= "Sq m".equalsIgnoreCase(property.getSizeType())? "selected" :""%>>Sq m</option>
                            <option <%= "Acre".equalsIgnoreCase(property.getSizeType())? "selected" :""%>>Acre</option>
                        </select>
                    </div>
                </div>

                <div class="mb-4">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" rows="5"><%= property.getDescription() %></textarea>
                </div>
                <% if (propertyType.equalsIgnoreCase("CommercialProperty")){
                    %>
                <div id="commercialFields" class="property-type-fields">
                    <div class="mb-4">
                        <label for="businessType" class="form-label">Business Type</label>
                        <input type="text" class="form-control" id="businessType" name="businessType" value="<%= commercialProperty.getBusinessType() %>" placeholder="e.g., Retail, Office, Restaurant">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasParking" name="hasParking" value="<%= commercialProperty.isHasParking() %>">
                        <label class="form-check-label" for="hasParking">Has Parking</label>
                    </div>
                </div>

                    <%
                }
                %>

                <% if (propertyType.equalsIgnoreCase("IndustrialProperty")){
                %>
                <div id="industrialFields" class="property-type-fields">
                    <div class="mb-4">
                        <label for="industryType" class="form-label">Industry Type</label>
                        <input type="text" class="form-control" id="industryType" name="industryType" value="<%= industrialProperty.getIndustryType() %>" placeholder="e.g., Manufacturing, Warehouse, Factory">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasLoadingDock" name="hasLoadingDock" value="<%= industrialProperty.isHasLoadingDock() %>">
                        <label class="form-check-label" for="hasLoadingDock">Has Loading Dock</label>
                    </div>
                </div>
                <%
                    }
                %>

                <% if (propertyType.equalsIgnoreCase("ResidentialProperty")){
                %>

                <div id="residentialFields" class="property-type-fields">
                    <div class="mb-4">
                        <label for="bedrooms" class="form-label">Bedrooms</label>
                        <input type="number" class="form-control" id="bedrooms" name="bedrooms" min="0" value="<%= residentialProperty.getBedrooms() %>">
                    </div>
                    <div class="mb-4">
                        <label for="bathrooms" class="form-label">Bathrooms</label>
                        <input type="number" class="form-control" id="bathrooms" name="bathrooms" min="0" value="<%= residentialProperty.getBathrooms() %>">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasGarage" name="hasGarage" value="<%= residentialProperty.isHasGarage() %>">
                        <label class="form-check-label" for="hasGarage">Has Garage</label>
                    </div>
                </div>
                <%
                    }
                %>


                <div class="mb-4">
                    <label class="form-label">Images</label>
                    <div class="image-upload-container">
                        <div class="uploaded-images" id="uploadedImages">
                            <% for (SystemFile file : property.getImages()) { %>
                            <img src="<%= file.getPath() %>" class="image-preview" alt="img-preview" />
                            <% } %>
                        </div>

                    </div>
                </div>
                <button type="button" class="btn w-100 btn-primary add-property-btn">Update Property</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/dashboard/dashboard.js"></script>
</body>
</html>