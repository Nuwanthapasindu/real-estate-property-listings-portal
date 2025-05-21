package com.replp.controller;

import com.replp.services.PublisherAuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth/publisher/delete")
public class PublisherProfileDeleteController extends HttpServlet {

    private final PublisherAuthService publisherAuthService = new PublisherAuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String id = session.getAttribute("id") == null ? null : session.getAttribute("id").toString();

        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
            return;
        }

        try{
            if(publisherAuthService.deleteProfile(id)){
                session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/auth/publisher/login.jsp");
                return;
            }
            else{
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=User not found");
            return;
            }
        }
        catch (Exception e){
            resp.sendRedirect(req.getContextPath() + "/auth/publisher/profile?error=User not found");
            return;
        }
    }
}
