package com.replp.controller.publisher.property;

import com.replp.model.CommercialProperty;
import com.replp.model.IndustrialProperty;
import com.replp.model.Property;
import com.replp.model.ResidentialProperty;
import com.replp.services.PropertyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@WebServlet("/auth/publisher/property/update")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,     // 10MB
        maxRequestSize = 1024 * 1024 * 50   // 50MB
)
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
            req.setAttribute("property", property);
            req.getRequestDispatcher("/WEB-INF/jsp/propertyDetails.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Property not found");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Access common fields
        String title = req.getParameter("title");
        String type = req.getParameter("type");
        String location = req.getParameter("location");
        String priceStr = req.getParameter("price");
        String sizeStr = req.getParameter("size");
        String sizeType = req.getParameter("sizeType");
        String description = req.getParameter("description");

        // Convert price and size to numbers (handle null or invalid input)
        double price = priceStr != null ? Double.parseDouble(priceStr) : 0.0;
        double size = sizeStr != null ? Double.parseDouble(sizeStr) : 0.0;

        // Access dynamic fields based on property type
        String businessType = req.getParameter("businessType");
        String hasParking = req.getParameter("hasParking");
        String industryType = req.getParameter("industryType");
        String hasLoadingDock = req.getParameter("hasLoadingDock");
        String bedroomsStr = req.getParameter("bedrooms");
        String bathroomsStr = req.getParameter("bathrooms");
        String hasGarage = req.getParameter("hasGarage");

        Collection<Part> fileParts = req.getParts();

        int bedrooms = bedroomsStr != null ? Integer.parseInt(bedroomsStr) : 0;
        int bathrooms = bathroomsStr != null ? Integer.parseInt(bathroomsStr) : 0;

        if (session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }

        String id = req.getParameter("id");

        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=ID is required");
            return;
        }

        try {
            Property updataedProperty = null;
            // find the property by id
            Optional<Property> propertyOptional = propertyService.findByID(id);
            if (propertyOptional.isPresent()) {
                Property property = propertyOptional.get();
                if (property instanceof CommercialProperty) {
                    CommercialProperty commercialProperty = (CommercialProperty) property;
                    if (!commercialProperty.getTitle().equals(title)) {
                    commercialProperty.setTitle(title);
                    }

                    if (!commercialProperty.getLocation().equals(location)) {
                    commercialProperty.setLocation(location);
                    }

                    if (commercialProperty.getPrice() != price) {
                    commercialProperty.setPrice(price);
                    }

                    if (commercialProperty.getSize() != size) {
                    commercialProperty.setSize(size);
                    }

                    if (!commercialProperty.getSizeType().equals(sizeType)) {
                    commercialProperty.setSizeType(sizeType);
                    }

                    if (!commercialProperty.getDescription().equals(description)) {
                    commercialProperty.setDescription(description);
                    }

                    if (!commercialProperty.getBusinessType().equals(businessType)) {
                    commercialProperty.setBusinessType(businessType);
                    }

                    if (commercialProperty.isHasParking() != Boolean.parseBoolean(hasParking)) {
                    commercialProperty.setHasParking(Boolean.parseBoolean(hasParking));
                    }

                    updataedProperty = commercialProperty;
                } else if (property instanceof IndustrialProperty) {
                    IndustrialProperty industrialProperty = (IndustrialProperty) property;

                    if (!industrialProperty.getTitle().equals(title)) {
                        industrialProperty.setTitle(title);
                    }

                    if (!industrialProperty.getLocation().equals(location)) {
                        industrialProperty.setLocation(location);
                    }

                    if (industrialProperty.getPrice() != price) {
                        industrialProperty.setPrice(price);
                    }

                    if (industrialProperty.getSize() != size) {
                        industrialProperty.setSize(size);
                    }

                    if (!industrialProperty.getSizeType().equals(sizeType)) {
                        industrialProperty.setSizeType(sizeType);
                    }

                    if (!industrialProperty.getDescription().equals(description)) {
                        industrialProperty.setDescription(description);
                    }

                    if (!industrialProperty.getIndustryType().equals(industryType)) {
                        industrialProperty.setIndustryType(industryType);
                    }

                    if (industrialProperty.isHasLoadingDock() != Boolean.parseBoolean(hasLoadingDock)) {
                        industrialProperty.setHasLoadingDock(Boolean.parseBoolean(hasLoadingDock));
                    }

                    updataedProperty = industrialProperty;
                } else if (property instanceof ResidentialProperty) {
                    ResidentialProperty residentialProperty = (ResidentialProperty) property;

                    if (!residentialProperty.getTitle().equals(title)) {
                        residentialProperty.setTitle(title);
                    }

                    if (!residentialProperty.getLocation().equals(location)) {
                        residentialProperty.setLocation(location);
                    }

                    if (residentialProperty.getPrice() != price) {
                        residentialProperty.setPrice(price);
                    }

                    if (residentialProperty.getSize() != size) {
                        residentialProperty.setSize(size);
                    }

                    if (!residentialProperty.getSizeType().equals(sizeType)) {
                        residentialProperty.setSizeType(sizeType);
                    }

                    if (!residentialProperty.getDescription().equals(description)) {
                        residentialProperty.setDescription(description);
                    }

                    if (residentialProperty.getBedrooms() != bedrooms) {
                        residentialProperty.setBedrooms(bedrooms);
                    }

                    if (residentialProperty.getBathrooms() != bathrooms) {
                        residentialProperty.setBathrooms(bathrooms);
                    }

                    if (residentialProperty.isHasGarage() != Boolean.parseBoolean(hasGarage)) {
                        residentialProperty.setHasGarage(Boolean.parseBoolean(hasGarage));
                    }
                    updataedProperty = residentialProperty;
                }else {
                    resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to update property");
                    return;
                }
                if (propertyService.updateProperty(req,updataedProperty, fileParts)) {
                    resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?success=Property updated successfully");
                    return;
                } else {
                    resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to update property");
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property?error=Failed to update property");
            return;
        }

    }
}
