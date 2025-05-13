package com.replp.controller.publisher;

import com.replp.model.CommercialProperty;
import com.replp.model.IndustrialProperty;
import com.replp.model.Property;
import com.replp.model.ResidentialProperty;
import com.replp.services.PropertyService;
import com.replp.util.UUIDGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/auth/publisher/property/create")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,     // 10MB
        maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class PublisherCreateController extends HttpServlet {

    private final PropertyService propertyService = new PropertyService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // check uses is Authenticated
        HttpSession session = req.getSession();
        if (session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }
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

        int bedrooms = bedroomsStr != null ? Integer.parseInt(bedroomsStr) : 0;
        int bathrooms = bathroomsStr != null ? Integer.parseInt(bathroomsStr) : 0;

        Collection<Part> fileParts = req.getParts();
        Property property;


    try{
        switch (type) {
            case "commercial":
                property = new CommercialProperty(UUIDGenerator.generate(),title,location,price,size,sizeType,description,null,req.getSession().getAttribute("id").toString(),businessType,Boolean.parseBoolean(hasParking));
                break;
            case "industrial":
                property = new IndustrialProperty(UUIDGenerator.generate(),title,location,price,size,sizeType,description,null,req.getSession().getAttribute("id").toString(),industryType,Boolean.parseBoolean(hasLoadingDock));
                break;
            case "residential":
                property = new ResidentialProperty(UUIDGenerator.generate(),title,location,price,size,sizeType,description,null,req.getSession().getAttribute("id").toString(),bedrooms,bathrooms,Boolean.parseBoolean(hasGarage));
                break;
            default:
                throw new IllegalArgumentException("Invalid property type: " + type);
        }


      boolean success =  propertyService.addProperty(req, property, fileParts);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property");
            return;
        }else{
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/property/create?error=Failed to create property");
            return;
        }


    } catch (Exception e) {
        resp.sendRedirect(req.getContextPath() + "/auth/publisher/property/create?error="+  e.getMessage());
    }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // check uses is Authenticated
        HttpSession session = req.getSession();
        if (session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }else{
            req.getRequestDispatcher("/WEB-INF/jsp/createProperty.jsp").forward(req, resp);
            return;
        }
    }
}
