package com.replp.util;


import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// This is a helper class to work with files
public class FileUtil {
    // This method gets the name of the file from the upload
    public static String extractFileName(Part part) {
        // Get the file info from the request
        String contentDisposition = part.getHeader("content-disposition");
        // Split the info into parts to find the filename
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // Extract the filename from the string
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return ""; // Return empty if no filename is found
    }

    // This method saves the uploaded file to the server
    public static void uploadFile(Part filePart, String uploadPath, String fileName) throws IOException {
        // Open the file from the user and a new file on the server
        try (InputStream input = filePart.getInputStream();
             FileOutputStream output = new FileOutputStream(uploadPath + File.separator + fileName)) {
            // Create a buffer to move the file data
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Keep reading and writing until the file is fully saved
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }
    }
}