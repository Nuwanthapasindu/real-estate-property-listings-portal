<%
    String otp = (String) request.getSession().getAttribute("otp");
    String email = (String) request.getSession().getAttribute("email");

    if (otp == null || otp.isEmpty() || email == null || email.isEmpty()) {
        response.sendRedirect("login.jsp");
    }
%>

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
<jsp:include page="/components/navbar-dark.jsp" />

    <!-- Main Content -->
    <main class="py-5">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <img src="<%= request.getContextPath()%>/assets/img/publicOtpVerification.png" alt="Home Interior" class="img-fluid rounded-4 shadow-sm">
                </div>
                <div class="col-lg-6">
                    <div class="ms-lg-5">
                        <h2 class="display-6 fw-bold mb-4">Help Us Confirm It's You</h2>
                        <p class="text-muted mb-4">Please enter the OTP code sent to your device to verify your identity.</p>

                        <% String error = request.getParameter("error"); %>
                        <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= error %>
                        </div>
                        <% } %>
                        <form action="verify-otp" method="post">
                            <div class="mb-4">
                                <label for="otp" class="form-label">OTP</label>
                                <input type="text" class="form-control form-control-lg" id="otp" name="otp" placeholder="******" maxlength="6" autocomplete="off">
                                <small class="text-muted mt-2 d-block">Enter the 6-digit code sent to your device</small>
                            </div>
                            
                            <button type="submit" class="btn btn-primary btn-lg w-100 mb-3">Verify</button>
                            
                            <div class="text-center mt-3">
                                <p class="mb-0">Didn't receive the code? <a href="#" class="text-primary text-decoration-none">Resend</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>

<jsp:include page="/components/footer.jsp" />
<script src="<%= request.getContextPath()%>/assets/js/otpVerification.js"></script>
</body>
</html>