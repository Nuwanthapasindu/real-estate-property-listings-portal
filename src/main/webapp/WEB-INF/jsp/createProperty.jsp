<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Add New Property</title>
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
            <% String error = request.getParameter("error"); %>
            <% if (error != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
            <% } %>
            <!-- Property Form -->
            <form id="propertyForm" action="" method="post" enctype="multipart/form-data">
                <div class="mb-4">
                    <label for="propertyTitle" class="form-label">Property Title</label>
                    <input type="text" class="form-control" name="title" id="propertyTitle" placeholder="Property Title" required>
                </div>

                <div class="mb-4">
                    <label for="propertyType" class="form-label">Property Type</label>
                    <select class="form-select" id="propertyType" name="type" required>
                        <option value="">Select Property Type</option>
                        <option value="commercial">Commercial</option>
                        <option value="industrial">Industrial</option>
                        <option value="residential">Residential</option>
                    </select>
                </div>

                <!-- Common Fields -->
                <div class="mb-4">
                    <label for="location" class="form-label">Location</label>
                    <input type="text" class="form-control" id="location" placeholder="Location" name="location" required>
                </div>

                <div class="mb-4">
                    <label for="price" class="form-label">Price</label>
                    <input type="number" class="form-control" id="price" placeholder="Price" name="price" required>
                </div>

                <div class="mb-4">
                    <label for="size" class="form-label">Size</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="size" value="1" name="size" required>
                        <select class="form-select" id="sizeUnit" name="sizeType" required>
                            <option value="Perch">Perch</option>
                            <option value="Sq ft">Sq ft</option>
                            <option value="Sq m">Sq m</option>
                            <option value="Acre">Acre</option>
                        </select>
                    </div>
                </div>

                <div class="mb-4">
                    <label for="description" class="form-label">Description</label>
                    <textarea class="form-control" id="description" name="description" rows="5" required></textarea>
                </div>

                <!-- Dynamic Fields based on Property Type -->
                <div id="commercialFields" class="property-type-fields" style="display: none;">
                    <div class="mb-4">
                        <label for="businessType" class="form-label">Business Type</label>
                        <input type="text" class="form-control" id="businessType" name="businessType" placeholder="e.g., Retail, Office, Restaurant">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasParking" name="hasParking" value="true">
                        <label class="form-check-label" for="hasParking">Has Parking</label>
                    </div>
                </div>

                <div id="industrialFields" class="property-type-fields" style="display: none;">
                    <div class="mb-4">
                        <label for="industryType" class="form-label">Industry Type</label>
                        <input type="text" class="form-control" id="industryType" name="industryType" placeholder="e.g., Manufacturing, Warehouse, Factory">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasLoadingDock" name="hasLoadingDock" value="true">
                        <label class="form-check-label" for="hasLoadingDock">Has Loading Dock</label>
                    </div>
                </div>

                <div id="residentialFields" class="property-type-fields" style="display: none;">
                    <div class="mb-4">
                        <label for="bedrooms" class="form-label">Bedrooms</label>
                        <input type="number" class="form-control" id="bedrooms" name="bedrooms" min="0" value="0">
                    </div>
                    <div class="mb-4">
                        <label for="bathrooms" class="form-label">Bathrooms</label>
                        <input type="number" class="form-control" id="bathrooms" name="bathrooms" min="0" value="0">
                    </div>
                    <div class="mb-4 form-check">
                        <input type="checkbox" class="form-check-input" id="hasGarage" name="hasGarage" value="true">
                        <label class="form-check-label" for="hasGarage">Has Garage</label>
                    </div>
                </div>

                <div class="mb-4">
                    <label class="form-label">Images</label>
                    <div class="image-upload-container">
                        <div class="upload-area" id="uploadArea">
                            <label for="fileInput" class="btn btn-outline-secondary upload-btn">
                                <i class="fas fa-plus"></i> Click here to upload
                            </label>
                            <input type="file" name="images[]" id="fileInput" accept="image/jpeg,image/png" multiple class="d-none">
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
<script src="<%= request.getContextPath() %>/js/dashboard/createProperty.js"></script>
</body>
</html>