package com.replp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/auth/publisher/register"}, name = "PublisherAuthController", description = "Publisher Authentication Controller")
public class PublisherAuthController extends HttpServlet {

    final PublisherAuthService publisherAuthService = new PublisherAuthService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
