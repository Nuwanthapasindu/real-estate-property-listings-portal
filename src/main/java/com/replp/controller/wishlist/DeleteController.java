package com.replp.controller.wishlist;

import com.replp.services.wishlist.WishlistService;
import com.replp.services.wishlist.WishlistServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/public/wishlist/remove")
public class DeleteController extends HttpServlet {
    private final WishlistService wishlistService = new WishlistServiceImpl();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getSession().getAttribute("userId") == null ? null : req.getSession().getAttribute("userId").toString();
        String propertyId = req.getParameter("propertyId");

        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/public/login.jsp");
            return;
        }

        // Get the referer (previous URL)
        String referer = req.getHeader("Referer");
        // Use a default URL as fallback if referer is not available
        String redirectURL = (referer != null) ? referer : req.getContextPath() + "/";
        try{wishlistService.removeWishlistFromUser(userId, propertyId);
            resp.sendRedirect(redirectURL);
            return;
        }catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            resp.sendRedirect(redirectURL);
            return;
        }

    }
}
