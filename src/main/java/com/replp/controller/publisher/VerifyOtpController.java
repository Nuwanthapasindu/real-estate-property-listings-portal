package com.replp.controller.publisher;

import com.replp.services.PublisherAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "VerifyOtpController", urlPatterns = {"/auth/publisher/verify-otp"})

    public class VerifyOtpController extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String inputOtp = req.getParameter("otp");

            HttpSession session = req.getSession();
            String email = (String) session.getAttribute("email");
            String sessionOtp = (String) session.getAttribute("otp");

            if (inputOtp.equals(sessionOtp)) {
                resp.sendRedirect(req.getContextPath()+"/auth/publisher/resetPassword.jsp");
            } else {
                resp.sendRedirect(req.getContextPath()+"/auth/publisher/verifyOTP.jsp?error=Invalid OTP. Try again.");
            }
        }
    }

