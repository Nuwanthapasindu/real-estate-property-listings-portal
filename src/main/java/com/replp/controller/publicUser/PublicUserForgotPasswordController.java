package com.replp.controller.publicUser;


import com.replp.services.publicAuthService.PublicAuthService;
import com.replp.services.publicAuthService.PublicAuthServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/public/forgot-password"}, name = "PublicUserForgotPasswordController", description = "PublicUserForgotPassword")
public class PublicUserForgotPasswordController extends HttpServlet {
    private  final PublicAuthService publicAuthService;

    public PublicUserForgotPasswordController() {
        this.publicAuthService = new PublicAuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        if (email == null || email.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/auth/public/forgotPassword.jsp?error=Please enter your email.");
            return;
        }

        // Generate OTP and send it to user's email
        String otp = publicAuthService.generateAndSendOtp(email);

        if (otp == null) {
            resp.sendRedirect(req.getContextPath() +"/auth/public/forgotPassword.jsp?error=No user found with this email.");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("otp", otp);
            session.setAttribute("email", email);
            resp.sendRedirect(req.getContextPath() +"/auth/public/verifyOTP.jsp");
        } 
    }
}
