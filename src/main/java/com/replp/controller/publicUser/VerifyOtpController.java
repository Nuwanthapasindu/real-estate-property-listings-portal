package com.replp.controller.publicUser;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

    @WebServlet(name = "VerifyOtpController", urlPatterns = {"/auth/public/verify-otp"})
    public class VerifyOtpController extends HttpServlet {


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String inputOtp = req.getParameter("otp");
                if (inputOtp == null || inputOtp.isEmpty()) {
                    resp.sendRedirect(req.getContextPath() + "/auth/public/verifyOTP.jsp?error=OTP is required.");
                    return;
                }
            HttpSession session = req.getSession();
            String email = (String) session.getAttribute("email");
            String sessionOtp = (String) session.getAttribute("otp");
            if (inputOtp.equals(sessionOtp)) {
                resp.sendRedirect(req.getContextPath()+"/auth/public/resetPassword.jsp");
            } else {
                resp.sendRedirect(req.getContextPath()+"/auth/public/verifyOTP.jsp?error=Invalid OTP. Try again.");
            }
        }
    }

