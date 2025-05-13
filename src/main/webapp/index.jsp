<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
    <title>Real Estate File Upload</title>
    <style>
        /* Styling for the page */
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

    <!-- Page heading -->
    <h2>Upload Property Image</h2>

    <!-- Form for uploading files -->
    <div class="form-container">
        <form action="<%= request.getContextPath() %>/file-upload" method="post" enctype="multipart/form-data">
            <label>Select Image:</label>
            <!-- Input to choose image file -->
            <input type="file" name="file" accept="image/*" required><br>
            <!-- Submit button -->
            <input type="submit" value="Upload">
        </form>
    </div>

    <!-- Display error or success messages from backend -->
    <% String error = (String) request.getAttribute("error"); %>
    <% String success = (String) request.getAttribute("success"); %>
    <% if (error != null) { %>
        <p class="error"><%= error %></p>
    <% } %>
    <% if (success != null) { %>
        <p class="success"><%= success %></p>
    <% } %>

    <!-- Table to show list of uploaded files -->
    <h3>Uploaded Files</h3>
    <table class="file-table">
        <tr>
            <th>File Name</th>
            <th>Actions</th>
        </tr>

        <%
            // Get the path to the 'uploads' folder in the server
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
            File uploadDir = new File(uploadPath);

            // Check if the directory exists
            if (uploadDir.exists()) {
                // Loop through each file in the folder
                for (File file : uploadDir.listFiles()) {
                    if (file.isFile()) {
        %>
        <tr>
            <!-- Show file name -->
            <td><%= file.getName() %></td>
            <td>
                <!-- Download link -->
                <a href="../PropertyController?action=download&file=<%= file.getName() %>">Download</a> |
                <!-- Delete link with confirmation -->
                <a href="../PropertyController?action=delete&file=<%= file.getName() %>"
                   onclick="return confirm('Are you sure you want to delete this file?');">Delete</a>
            </td>
        </tr>
        <%
                    }
                }
            }
        %>
    </table>
</body>
</html>
