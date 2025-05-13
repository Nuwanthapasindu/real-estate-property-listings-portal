<%--
  Created by IntelliJ IDEA.
  User: nuwanthapasindu
  Date: 2025-05-13
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <link rel="stylesheet" href="./assets/css/navbarFooter.css">
    <link rel="stylesheet" href="./assets/css/singleProperty.css">
</head>
<body>

<jsp:include page="/components/navbar-dark.jsp" />
    <!-- Main Content -->
    <main>
        <!-- Property Hero Section -->
        <div class="container pt-5">
            <div class="property-hero">
                <img src="property-main.jpg" alt="Modern 3-Bedroom Family Home" class="img-fluid w-100 rounded-4">
            </div>

        </div>

        <div class="container my-5">
            <!-- Property Header -->
            <div class="row">
                <div class="col-12">
                    <h1 class="property-title">Modern 3-Bedroom Family Home with Garden</h1>
                    <div class="d-flex align-items-center mt-3 gap-3">
                        <img src="agent.jpg" alt="Agent" class="agent-avatar">
                        <span class="h5">Ali Tufan</span>
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
                                <h3>Rs 40,500,000</h3>
                            </div>
                            <div class="col-md-4 property-detail-item d-flex align-items-center flex-column gap-3">
                                <i class="fas fa-vector-square"></i>
                                <h3>18 m<sup>2</sup></h3>
                            </div>
                            <div class="col-md-4 property-detail-item d-flex align-items-center flex-column gap-3">
                                <i class="fas fa-map-marker-alt"></i>
                                <h3>Colombo</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Property Description -->
            <div class="row mt-5">
                <div class="col-12">
                    <p class="property-description">
                        Experience the art of fine living through a thoughtful balance of comfort, style, and functionality. This flexible 3-bedroom home offers an appealing open-plan kitchen/dining/living area with a cozy fireplace, perfect for family gatherings. The spacious primary bedroom features a walk-in closet and an ensuite bathroom. Two additional bedrooms share a well-appointed family bathroom. A versatile study nook provides a dedicated space for work or homework.
                    </p>
                    <p class="property-description">
                        The home's design emphasizes natural light and flow, with large windows overlooking the beautifully landscaped garden. High ceilings and thoughtful storage solutions enhance the sense of space. Energy-efficient features include double-glazed windows, superior insulation, and a modern heating system that ensures year-round comfort while keeping utility costs manageable.
                    </p>
                    <p class="property-description">
                        The property boasts an entertainer's dream outdoor space with a covered patio area perfect for year-round enjoyment. The fully fenced, low-maintenance garden provides a safe play area for children and pets. A double garage with internal access offers convenient, secure parking and additional storage space.
                    </p>
                    <p class="property-description">
                        Located in a sought-after neighborhood, you'll be just minutes from excellent schools, parks, shopping centers, and public transportation. The established community offers a perfect balance of privacy and connectivity.
                    </p>
                    <p class="property-description">
                        Additional features include a security system, high-speed internet connectivity, quality fixtures and fittings throughout, and a dedicated laundry room. Recent updates to the kitchen and bathrooms ensure modern functionality while maintaining the home's timeless appeal.
                    </p>
                    <p class="property-description">
                        This turnkey property represents exceptional value and is ready for immediate occupancy. Schedule a viewing today to experience firsthand the perfect blend of comfort, style, and convenience that makes this house a true home.
                    </p>
                </div>
            </div>

            <!-- Property Gallery -->
            <div class="row mt-5">
                <div class="col-12">
                    <h2 class="mb-4">Property Gallery</h2>
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-1.jpg" alt="Property Exterior" class="img-fluid rounded gallery-img">
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-2.jpg" alt="Property Front" class="img-fluid rounded gallery-img">
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-3.jpg" alt="Property Entrance" class="img-fluid rounded gallery-img">
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-4.jpg" alt="Property Side View" class="img-fluid rounded gallery-img">
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-5.jpg" alt="Property Wall Detail" class="img-fluid rounded gallery-img">
                </div>
                <div class="col-md-4 mb-4">
                    <img src="property-6.jpg" alt="Property Bathroom" class="img-fluid rounded gallery-img">
                </div>
            </div>
        </div>
    </main>

<jsp:include page="components/footer.jsp" />
</body>
</html>
