package com.replp.controller.publisher;

import com.replp.model.Property;
import com.replp.services.PropertyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/auth/publisher/property")
public class PropertyReadController extends HttpServlet {
private  final PropertyService propertyService = new PropertyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("id");
        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }


       try {
           List<Property> properties = propertyService.getPropertiesByUser(userId);
           req.setAttribute("properties", properties);
           req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp").forward(req, resp);
       }catch (Exception e){
           req.getRequestDispatcher("/WEB-INF/jsp/dashboard.jsp?error=Something went wrong").forward(req, resp);
       }
    }
}
