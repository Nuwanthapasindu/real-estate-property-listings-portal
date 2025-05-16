package com.replp.util;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;

import java.io.IOException;
import java.nio.file.Paths;


public class FileUtil {
    public static String saveUploadedFile(HttpServletRequest req, Part filePart, String uploadDir) throws IOException {
        String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String sanitizedFileName = sanitizeFileName(originalFileName);
        String uniqueFileName = UUIDGenerator.generate()+ "_" + sanitizedFileName;

        File uploadPath = new File(uploadDir);
        if (!uploadPath.exists()) uploadPath.mkdirs();

        File file = new File(uploadPath, uniqueFileName);
        filePart.write(file.getAbsolutePath());

        return req.getContextPath() +"/uploads/" + uniqueFileName;
    }

    private static String sanitizeFileName(String fileName) {
        return fileName.replaceAll("[^a-zA-Z0-9\\.\\-_]", "_");
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}