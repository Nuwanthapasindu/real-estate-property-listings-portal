package com.replp.controller.publisher;

import com.replp.model.Publisher;
import com.replp.model.User;
import com.replp.services.PublisherAuthService;
import com.replp.util.PasswordHash;
import com.replp.util.UUIDGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = {"/auth/publisher/register"}, name = "PublisherAuthController", description = "Publisher Authentication Controller")
public class PublisherAuthController extends HttpServlet {

    final PublisherAuthService publisherAuthService = new PublisherAuthService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");


        if (firstName == null || firstName.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/signup.jsp?error=First Name is required");
            return;
        }

        if (lastName == null || lastName.isEmpty()) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/signup.jsp?error=Last Name is required");
            return;
        }

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/signup.jsp?error=Invalid Email");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            resp.getWriter().write("Contact number must be 10 digits");
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/signup.jsp?error=Contact number must be 10 digits");
            return;
        }

        if (!password.equals(confirmPassword)){
            resp.sendRedirect(req.getContextPath() +"/auth/publisher/signup.jsp?error=Password mis match");
            return;
        }

        Publisher user = new Publisher(UUIDGenerator.generate(),firstName,lastName,phone,email, PasswordHash.hashPassword(password), LocalDateTime.now(),"PUBLISHER");
        try {
            boolean isRegisterSuccess = publisherAuthService.registerUser(user);
            if (isRegisterSuccess){
                resp.sendRedirect(req.getContextPath()+"/auth/publisher/login.jsp");
            }
        } catch (Exception e) {
            resp.sendRedirect("auth/signup.jsp?error = Something Went wrong" );
        }


    }
}
