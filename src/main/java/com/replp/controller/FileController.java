package com.replp.controller;


import com.replp.model.SystemFile;
import com.replp.util.FileUtil;
import com.replp.util.UUIDGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;

// This is a special class that handles requests from the website
@WebServlet(urlPatterns ={"/file-upload"} )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB limit for small file parts
                 maxFileSize = 1024 * 1024 * 10,      // 10MB max file size
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB max total request size
public class FileController extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads"; // Folder where files will be saved

    @Override
    // This method runs when a file is uploaded (POST request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath(UPLOAD_DIR);
        try{
            Part filePart = request.getPart("file");
            uploadFile(request,filePart,uploadPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // This method runs for download or delete actions (GET request)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the action (download or delete) and file name from the URL
        String action = request.getParameter("action");
        String fileName = request.getParameter("file");
        // Path where files are stored
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File file = new File(uploadPath + File.separator + fileName);

        if ("download".equals(action)) {
            // Check if the file exists
            if (file.exists()) {
                // Set up the file to be downloaded
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                try (FileInputStream fis = new FileInputStream(file);
                     OutputStream os = response.getOutputStream()) {
                    // Read the file and send it to the user
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
            } else {
                // If file not found, show an error
                request.setAttribute("error", "File not found!");
                request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
            }
        } else if ("delete".equals(action)) {
            // Check if the file exists and delete it
            if (file.exists() && file.delete()) {
                // Tell the user it was deleted
                request.setAttribute("success", "File deleted successfully!");
            } else {
                // If deletion failed, show an error
                request.setAttribute("error", "Failed to delete file!");
            }
            // Go back to the index page
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        }
    }

        protected SystemFile uploadFile(HttpServletRequest req, Part filePart, String filePath) throws IOException {
            String path =   FileUtil.saveUploadedFile(req,filePart,filePath);
            String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            return new SystemFile(UUIDGenerator.generate(),originalFileName,path,filePart.getSize(),filePart.getContentType(),LocalDateTime.now());

        }
}


