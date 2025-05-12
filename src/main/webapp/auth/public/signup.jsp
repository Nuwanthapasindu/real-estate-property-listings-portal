<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - Real Estate</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="../../assets/css/main.css">
    <link rel="stylesheet" href="../../assets/css/login.css">
    <link rel="stylesheet" href="../../assets/css/navbarFooter.css">
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="/components/navbar-light.jsp" />
    <!-- Main Content -->
    <main class="container">
        <div class="row align-items-center min-vh-100">
            <div class="col-md-6">
                <img src="<%= request.getContextPath()%>/assets/img/publicSignup.png" alt="Modern Architecture" class="img-fluid rounded">
            </div>
            <div class="col-md-6">
                <div class="signup-form">
                    <h1 class="mb-4">Let's level up your brand, together</h1>
                        <% String error = request.getParameter("error"); %>
                        <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= error %>
                        </div>
                        <% } %>
                    <form id="signupForm" action="register" method="POST">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Your first name">
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Your last name">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="you@company.com">
                        </div>
                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="+1 (555) 000-0000">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Your password">
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Re-type your password">
                        </div>
                        <button type="submit" class="btn w-100 btn-primary">Signup</button>
                    </form>
                    <div class="text-center mt-4">
                        <p>Already have an account? <a href="<%= request.getContextPath()%>/auth/public/login.jsp">Login</a></p>
                    </div>
                </div>
            </div>
        </div>
    </main>
<jsp:include page="/components/footer.jsp" />
</body>
</html>