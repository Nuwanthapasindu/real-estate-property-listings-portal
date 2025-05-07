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
            String otp1 = req.getParameter("otp1");
            String otp2 = req.getParameter("otp2");
            String otp3 = req.getParameter("otp3");
            String otp4 = req.getParameter("otp4");
            String otp5 = req.getParameter("otp5");
            String otp6 = req.getParameter("otp6");

            HttpSession session = req.getSession();
            String email = (String) session.getAttribute("email");
            String sessionOtp = (String) session.getAttribute("otp");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(otp1);
            stringBuilder.append(otp2);
            stringBuilder.append(otp3);
            stringBuilder.append(otp4);
            stringBuilder.append(otp5);
            stringBuilder.append(otp6);
            if (stringBuilder.toString().equals(sessionOtp)) {
                resp.sendRedirect(req.getContextPath()+"/auth/publisher/resetPassword.jsp");
            } else {
                resp.sendRedirect(req.getContextPath()+"/auth/publisher/verifyOTP.jsp?error=Invalid OTP. Try again.");
            }
        }
    }

