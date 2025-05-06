<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
    <title>Real Estate File Upload</title>
    <style>
        /* This is CSS to style the page, making it look nice */
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-container { max-width: 500px; margin-bottom: 20px; }
        .form-container input { width: 100%; margin: 5px 0; padding: 8px; }
        .file-table { border-collapse: collapse; width: 100%; max-width: 500px; }
        .file-table th, .file-table td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        .file-table th { background-color: #f2f2f2; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
    <!-- This is a heading to tell users what to do -->
    <h2>Upload Property Image</h2>
    <div class="form-container">
        <!-- This is a form where users can pick a file to upload -->
        <form action="../PropertyController" method="post" enctype="multipart/form-data">
            <label>Select Image:</label>
            <input type="file" name="file" accept="image/*" required><br>
            <!-- This button sends the file to the server -->
            <input type="submit" value="Upload">
        </form>
    </div>

    <!-- This part checks if there’s a message to show the user -->
    <% String error = (String) request.getAttribute("error"); %>
    <% String success = (String) request.getAttribute("success"); %>
    <% if (error != null) { %>
        <!-- If there’s an error, show it in red -->
        <p class="error"><%= error %></p>
    <% } %>
    <% if (success != null) { %>
        <!-- If it worked, show a green success message -->
        <p class="success"><%= success %></p>
    <% } %>

    <!-- This is a table to show all the files that were uploaded -->
    <h3>Uploaded Files</h3>
    <table class="file-table">
        <tr>
            <!-- Table headers to label the columns -->
            <th>File Name</th>
            <th>Actions</th>
        </tr>
        <%
            // This gets the path where files are stored on the server
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()) {
                // Loop through each file in the uploads folder
                for (File file : uploadDir.listFiles()) {
                    if (file.isFile()) {
        %>
        <tr>
            <!-- Show the name of each file -->
            <td><%= file.getName() %></td>
            <td>
                <!-- Link to download the file -->
                <a href="../PropertyController?action=download&file=<%= file.getName() %>">Download</a>
                <!-- Link to delete the file with a confirmation -->
                <a href="../PropertyController?action=delete&file=<%= file.getName() %>"
                   onclick="return confirm('Are you sure you want