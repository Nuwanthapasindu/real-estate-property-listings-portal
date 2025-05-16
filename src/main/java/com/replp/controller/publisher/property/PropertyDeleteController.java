package com.replp.controller.publisher.property;

import com.replp.services.PropertyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/auth/publisher/property/delete")
public class PropertyDeleteController extends HttpServlet {
        private final  PropertyService propertyService = new PropertyService();

}
