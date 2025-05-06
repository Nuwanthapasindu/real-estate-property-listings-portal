<%
    String otp = (String) request.getSession().getAttribute("otp");
    String email = (String) request.getSession().getAttribute("email");

    if (otp == null || otp.isEmpty() || email == null || email.isEmpty()) {
        response.sendRedirect("login.jsp");
    }
%><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 5/6/2025
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .otp-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 100%;
            max-width: 450px;
            text-align: center;
        }

        .otp-header {
            margin-bottom: 30px;
        }

        .otp-header h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .otp-header p {
            color: #666;
            font-size: 14px;
        }

        .otp-inputs {
            display: flex;
            justify-content: space-between;
            margin-bottom: 30px;
        }

        .otp-input {
            width: 50px;
            height: 60px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            border: 2px solid #e0e0e0;
            border-radius: 8px;
            outline: none;
            transition: all 0.3s;
        }

        .otp-input:focus {
            border-color: #4a90e2;
            box-shadow: 0 0 5px rgba(74, 144, 226, 0.3);
        }

        .verify-btn {
            background-color: #4a90e2;
            color: white;
            border: none;
            border-radius: 8px;
            padding: 12px 0;
            width: 100%;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .verify-btn:hover {
            background-color: #3a7bc8;
        }

        .resend-text {
            margin-top: 20px;
            color: #666;
            font-size: 14px;
        }

        .resend-link {
            color: #4a90e2;
            text-decoration: none;
            font-weight: 600;
            cursor: pointer;
        }

        .resend-link:hover {
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .otp-container {
                padding: 30px 20px;
            }

            .otp-input {
                width: 40px;
                height: 50px;
                font-size: 20px;
            }
        }
    </style>
</head>
<body>
<div class="otp-container">
    <div class="otp-header">
        <h1>OTP Verification</h1>
        <p>We've sent a verification code to your email</p>
    </div>
    <% String error = request.getParameter("error"); %>
    <% if (error != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= error %>
    </div>
    <% } %>
    <form action="verify-otp" method="post">

    <div class="otp-inputs">
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp1" inputmode="numeric" autofocus>
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp2" inputmode="numeric">
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp3" inputmode="numeric">
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp4" inputmode="numeric">
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp5" inputmode="numeric">
        <input type="text" class="otp-input" maxlength="1" pattern="[0-9]" name="otp6" inputmode="numeric">
    </div>

    <button type="submit" class="verify-btn">Verify</button>
    </form>

    <p class="resend-text">
        Didn't receive code? <a class="resend-link">Resend</a>
    </p>
</div>

<script>
    // Simple JavaScript to auto-focus next input
    const inputs = document.querySelectorAll('.otp-input');

    inputs.forEach((input, index) => {
        input.addEventListener('input', (e) => {
            if (e.target.value.length === 1) {
                if (index < inputs.length - 1) {
                    inputs[index + 1].focus();
                }
            }
        });

        input.addEventListener('keydown', (e) => {
            if (e.key === 'Backspace' && e.target.value.length === 0) {
                if (index > 0) {
                    inputs[index - 1].focus();
                }
            }
        });
    });
</script>
</body>
</html>
