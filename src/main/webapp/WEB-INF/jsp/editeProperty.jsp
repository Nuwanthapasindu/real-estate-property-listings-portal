<%@ page import="com.replp.model.Property" %>
<% Property property = (Property) request.getAttribute("properties"); %>
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
                    <i class="fas fa-arrow-left"></i>  Properties
                </a>
            </div>
        </div>

        <!-- Add Property Form -->
        <div class="properties-section">
            <div class="section-header d-flex justify-content-end align-items-center mb-4">
                <div class="action-buttons">
                    <button class="btn btn-danger add-property-btn">Delete Property</button>
                </div>
            </div>

            <!-- Property Form -->
            <form id="propertyForm">
                <div class="mb-4">
                    <label for="propertyTitle" class="form-label">Property Title</label>
                    <input type="text" class="form-control" id="propertyTitle" placeholder="Property Title" value="<%= property.getTitle() %>" >
                </div>

                <div class="mb-4">
                    <label for="propertyType" class="form-label">Property Type</label>
                    <select class="form-select" id="propertyType">
                        <option selected>House</option>
                        <option>Apartment</option>
                        <option>Condo</option>
                        <option>Villa</option>
                        <option>Land</option>
                    </select>
                </div>

                <div class="mb-4">
                    <label for="location" class="form-label">Location</label>
                    <input type="text" class="form-control" id="location" placeholder="Location">
                </div>

                <div class="mb-4">
                    <label for="price" class="form-label">Price</label>
                    <input type="text" class="form-control" id="price" placeholder="Price">
                </div>

                <div class="mb-4">
                    <label for="size" class="form-label">Size</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="size" value="1">
                        <select class="form-select" id="sizeUnit">
                            <option selected>Perch</option>
                            <option>Sq ft</option>
                            <option>Sq m</option>
                            <option>Acre</option>
                        </select>
                    </div>
                </div>

                <div class="mb-4">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" rows="5"></textarea>
                </div>

                <div class="mb-4">
                    <label class="form-label">Images</label>
                    <div class="image-upload-container">
                        <div class="upload-area" id="uploadArea">
                            <button type="button" class="btn btn-outline-secondary upload-btn">
                                <i class="fas fa-plus"></i> Click here to upload
                            </button>
                            <p class="text-muted small">.jpg .png Only</p>
                        </div>
                        <div class="uploaded-images" id="uploadedImages">
                            <!-- Preview images will appear here -->
                        </div>
                    </div>
                </div>

                <div class="text-center mt-5">
                    <button type="submit" class="btn btn-primary btn-lg px-5">Add New Property</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%= request.getContextPath() %>/js/dashboard/dashboard.js"></script>
</body>
</html>
