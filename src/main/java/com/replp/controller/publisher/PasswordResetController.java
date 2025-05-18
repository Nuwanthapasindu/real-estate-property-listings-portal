package com.replp.controller.publisher;

import com.replp.services.PublisherAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ResetPasswordController", urlPatterns = {"/auth/publisher/reset-password"})
public class PasswordResetController extends HttpServlet {

    private final PublisherAuthService authService = new PublisherAuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newPassword = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        HttpSession session = req.getSession();
        String email = session.getAttribute("email").toString();

        if (email == null || newPassword == null || confirmPassword == null || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/resetPassword.jsp?error=Password Required");
            return;
        }
        if (!newPassword.equals(confirmPassword)) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/resetPassword.jsp?error=Passwords do not match");
            return;
        }
        if (authService.updatePassword(email, newPassword)) {
            session.invalidate();
            resp.sendRedirect(req.getContextPath()+"/auth/publisher/login.jsp?success=Password reset successful.");
        } else {
            resp.sendRedirect(req.getContextPath()+"/auth/publisher/resetPassword.jsp?error=Failed to reset password.");
        }
    }
}