package com.replp.controller.publicUser;


import com.replp.services.publicAuthService.PublicAuthService;
import com.replp.services.publicAuthService.PublicAuthServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

    @WebServlet(name = "ResetPasswordController", urlPatterns = {"/auth/public/reset-password"})
    public class ResetPasswordController extends HttpServlet {

        private  final PublicAuthService publicAuthService;

        public ResetPasswordController() {
            this.publicAuthService = new PublicAuthServiceImpl();
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String newPassword = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");
            HttpSession session = req.getSession();
            String email = session.getAttribute("email").toString();

            if (email == null || newPassword == null || confirmPassword == null || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/auth/public/resetPassword.jsp?error=Password Required");
                return;
            }
            if (!newPassword.equals(confirmPassword)) {
                resp.sendRedirect(req.getContextPath() + "/auth/public/resetPassword.jsp?error=Passwords do not match");
                return;
            }
            if (publicAuthService.updatePassword(email, newPassword)) {
                session.invalidate();
                resp.sendRedirect(req.getContextPath()+"/auth/public/login.jsp?success=Password reset successful.");
            } else {
                resp.sendRedirect(req.getContextPath()+"/auth/public/resetPassword.jsp?error=Failed to reset password.");
            }
        }
    }

