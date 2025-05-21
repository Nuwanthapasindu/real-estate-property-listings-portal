package com.replp.controller.publisher;

import com.replp.model.Publisher;
import com.replp.services.PublisherAuthService;
import com.replp.util.PasswordHash;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth/publisher/profile")
public class PublisherProfileUpdateController extends HttpServlet {

    private final PublisherAuthService publisherAuthService = new PublisherAuthService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// check uses is Authenticated
        HttpSession session = req.getSession();
        if (session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }else{
            req.getRequestDispatcher("/WEB-INF/jsp/profileUpdate.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String id = session.getAttribute("id") == null ? null : session.getAttribute("id").toString();
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String contactNumber = req.getParameter("contactNumber");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");


        try{
        Optional<Publisher> publisherOptional = publisherAuthService.findById(id);
        if (publisherOptional.isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=User not found");
            return;
        }

        Publisher publisher = publisherOptional.get();

        if (!publisher.getFirstName().equals(firstName)) {
            publisher.setFirstName(firstName);
        }
        if (!publisher.getLastName().equals(lastName)) {
            publisher.setLastName(lastName);
        }

        if (!publisher.getContactNumber().equals(contactNumber)) {
            publisher.setContactNumber(contactNumber);
        }

        if (!publisher.getEmail().equals(email)) {
            publisher.setEmail(email);
        }

        // check if password is going to be updated
        if (newPassword != null && confirmPassword != null && !newPassword.isEmpty() && !confirmPassword.isEmpty()) {
            if (!newPassword.equals(confirmPassword)) {
                resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=Passwords do not match");
                return;
            }
        publisher.setPassword(PasswordHash.hashPassword(newPassword));

        }

        if (publisherAuthService.updateProfile(publisher)){
            session.setAttribute("id",publisher.getId());
            session.setAttribute("firstName",publisher.getFirstName());
            session.setAttribute("lastName",publisher.getLastName());
            session.setAttribute("contactNumber",publisher.getContactNumber());
            session.setAttribute("email",publisher.getEmail());
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?success=Profile updated successfully");
            return;
        }else{
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=Something went wrong");
            return;
        }



        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=Something went wrong");
            return;
        }






    }
}
