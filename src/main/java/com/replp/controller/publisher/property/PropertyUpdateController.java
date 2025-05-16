package com.replp.controller.publisher.property;

import com.replp.model.CommercialProperty;
import com.replp.model.Property;
import com.replp.services.PropertyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth/publisher/property/update")
public class PropertyUpdateController extends HttpServlet {
    PropertyService propertyService = new PropertyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }


        String id = req.getParameter("id");

        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=ID is required");
            return;
        }


       Optional<Property> propertyOptional = propertyService.findByID(id);
        if (propertyOptional.isPresent()) {
            Property property = propertyOptional.get();
//            req.setAttribute("id",p.getId());
//            req.setAttribute("title",p.getTitle());
//            req.setAttribute("location",p.getLocation());
//            req.setAttribute("price",p.getPrice());
//            req.setAttribute("size",p.getSize());
//            req.setAttribute("sizeType",p.getSizeType());
//            req.setAttribute("description",p.getDescription());
//
//            if (p instanceof CommercialProperty){
//                CommercialProperty commercialProperty = (CommercialProperty) p;
//                req.setAttribute("businessType",commercialProperty.getBusinessType());
//                req.setAttribute("hasParking",commercialProperty.isHasParking());
//            }
            req.setAttribute("property", property);
            req.getRequestDispatcher("/WEB-INF/jsp/propertyDetails.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Property not found");
            return;
        }

    }
}
