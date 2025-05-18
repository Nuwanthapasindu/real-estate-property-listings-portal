package com.replp.controller.publisher.property;

import com.replp.services.PropertyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/publisher/property/delete/image")
public class PropertyImageDeleteController extends HttpServlet {
    private final PropertyService propertyService = new PropertyService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String propertyId = req.getParameter("propertyId");
        String imageId = req.getParameter("fileId");
        try{
            propertyService.deletePropertyImage(propertyId,imageId);
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?success=Image deleted successfully");
            return;
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to delete image");
            return;
        }
    }
}
