package com.replp.controller.publicUser;


import com.replp.model.PublicUser;
import com.replp.model.User;
import com.replp.services.publicAuthService.PublicAuthService;
import com.replp.services.publicAuthService.PublicAuthServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/auth/public/login"}, name = "PublicAuthLoginController", description = "Publisher Authentication Login Controller")
public class LoginController extends HttpServlet {
    private  final PublicAuthService publicAuthService;

    public LoginController() {
        this.publicAuthService = new PublicAuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get login form inputs
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Basic input validation
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/auth/public/login.jsp?error=Email and Password are required.");
            return;
        }
        try {
            Optional<PublicUser> userExists = publicAuthService.authenticate(email,password);

            if (!userExists.isPresent()) {
                resp.sendRedirect(req.getContextPath() +"/auth/public/login.jsp?error=Invalid email or password.");
                return;
            }

            HttpSession session = req.getSession();
            session.setAttribute("isAuthenticated", true);
            session.setAttribute("userId", userExists.get().getId());
            session.setAttribute("name", userExists.get().getFirstName());


            resp.sendRedirect(req.getContextPath() +"/");

        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() +"/auth/public/login.jsp?error=Something went wrong.");
        }

    }
}

