package com.replp.controller;

import com.replp.model.User;
import com.replp.services.PublisherAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/auth/publisher/login"}, name = "PublisherAuthLoginController", description = "Publisher Authentication Login Controller")
public class PublisherAuthLoginController extends HttpServlet {
    private final PublisherAuthService publisherAuthService = new PublisherAuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get login form inputs
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Basic input validation
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/login.jsp?error=Email and Password are required.");
            return;
        }
        try {
            Optional<User> userExists = publisherAuthService.authenticate(email,password);

            if (!userExists.isPresent()) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/login.jsp?error=Invalid email or password.");
            return;
            }

            User user = userExists.get();
            HttpSession session = req.getSession();
            session.setAttribute("id",user.getId());
            session.setAttribute("firstName",user.getFirstName());
            session.setAttribute("lastName",user.getLastName());
            session.setAttribute("contactNumber",user.getContactNumber());
            session.setAttribute("email",user.getEmail());

            resp.sendRedirect(req.getContextPath() +"/");

        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/login.jsp?error=Something went wrong.");
        }
    }
}
