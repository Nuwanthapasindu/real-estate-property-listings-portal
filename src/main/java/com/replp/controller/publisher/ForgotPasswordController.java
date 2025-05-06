package com.replp.controller.publisher;

import com.replp.services.PublisherAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/auth/publisher/forgot-password"})
public class ForgotPasswordController extends HttpServlet {

        private final PublisherAuthService authService = new PublisherAuthService();

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String email = req.getParameter("email");

            if (email == null || email.isEmpty()) {
                resp.sendRedirect(req.getContextPath() +"/auth/publisher/forgotPassword.jsp?error=Please enter your email.");
                return;
            }

            // Generate OTP and send it to user's email
            String otp = authService.generateAndSendOtp(email);

            if (otp == null) {
                resp.sendRedirect(req.getContextPath() +"/auth/publisher/forgotPassword.jsp?error=No user found with this email.");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("otp", otp);
                session.setAttribute("email", email);
                resp.sendRedirect(req.getContextPath() +"/auth/publisher/verifyOTP.jsp");
            }
        }
    }




