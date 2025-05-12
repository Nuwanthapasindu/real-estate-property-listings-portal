<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Homez - OTP Verification</title>
    <!-- Add Inter font from Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="../../assets/css/main.css">
    <link rel="stylesheet" href="../../assets/css/login.css">
    <link rel="stylesheet" href="../../assets/css/otpVerification.css">
    <link rel="stylesheet" href="../../assets/css/navbarFooter.css">
</head>
<body>
<jsp:include page="/components/navbar-light.jsp" />

    <!-- Main Content -->
    <main class="container">
        <div class="row align-items-center min-vh-100">
            <div class="col-md-6">
                <img src="<%= request.getContextPath()%>/assets/img/publicPasswordResetImage.png" alt="Modern Architecture" class="img-fluid rounded">
            </div>
            <div class="col-md-6">
                <div class="signup-form">
                    <h1 class="mb-4">Reset Your Password</h1>
                    <form id="loginForm">
                 
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Your password">
                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" placeholder="Your password">
                        </div>
                        
                        <button type="submit" class="btn w-100 btn-primary">Reset</button>
                    </form>
                </div>
            </div>
        </div>
    </main>

<jsp:include page="/components/footer.jsp" />
</body>
</html>