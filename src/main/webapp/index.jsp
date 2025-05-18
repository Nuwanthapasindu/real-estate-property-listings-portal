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
<jsp:include page="components/navbar-dark.jsp" />
<h2>Hello World!</h2>
</body>
</html>
