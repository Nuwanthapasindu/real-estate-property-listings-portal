package com.replp.controller.publisher.property;

import com.replp.services.PropertyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/publisher/property/delete")
public class PropertyDeleteController extends HttpServlet {
        private final  PropertyService propertyService = new PropertyService();

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                String id = req.getParameter("propertyId");
                if (id == null) {
                        resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=ID is required");
                        return;
                }

            try {
                if (propertyService.deleteProperty(id)) {
                        resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?success=Property deleted successfully");
                        return;
                } else {
                        resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to delete property");
                        return;
                }
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to delete property");
                return;
            }
        }
}
