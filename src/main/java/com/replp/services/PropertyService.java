package com.replp.services;

import com.replp.DSA.PropertySorter;
import com.replp.dao.PropertyDao;
import com.replp.model.*;
import com.replp.util.FileUtil;
import com.replp.util.UUIDGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PropertyService {
    private final PropertyDao propertyDao = new PropertyDao();


    public boolean addProperty(HttpServletRequest req, Property property, Collection<Part> parts) throws Exception {
        final String UPLOAD_FOLDER = req.getServletContext().getRealPath("/uploads");
        List<SystemFile> files = new ArrayList<>();

        try {

            for (Part part : parts) {
                if ("images[]".equals(part.getName()) && part.getSize() > 0) {

                    String path = FileUtil.saveUploadedFile(req, part, UPLOAD_FOLDER);
                    files.add(new SystemFile(UUIDGenerator.generate(), part.getSubmittedFileName(), path, part.getSize(), part.getContentType(), LocalDateTime.now()));
                }
            }

            property.setImages(files);
            return propertyDao.writeProperty(property);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProperty(String ID) throws Exception {
        Optional<Property> property = findByID(ID);
        if (property.isPresent()) {
            boolean deleted = propertyDao.deleteProperty(property.get(), ID);
            if (deleted) {
                for (SystemFile file : property.get().getImages()) {
                    FileUtil.deleteFile(file.getPath());
                }
            }

        } else throw new Exception("Property not found");
        return true;

    }

    public Optional<Property> findByID(String ID) {
        return propertyDao.findPropertyByID(ID);
    }

    public List<Property> getAllProperties() {
        return propertyDao.getAllProperties();
    }

    public List<Property> filterProperties(String type, String search, String priceOrder) {

        if (priceOrder == null) {
            priceOrder = "ASC";
        }


        if (search != null && !search.isEmpty()) {
            return propertyDao.getPropertiesByTitle(search);
        }

        List <Property> properties = getAllProperties();
        PropertySorter.quickSortByPrice(properties, priceOrder);

        if (type != null && !type.isEmpty()) {
            List<Property> filteredProperties = new ArrayList<>();
            if (type.equalsIgnoreCase("CommercialProperty")) {

                for (Property property : properties) {
                    if (property instanceof CommercialProperty) {
                        filteredProperties.add(property);
                    }
                }
                return filteredProperties;
            }

            if (type.equalsIgnoreCase("IndustrialProperty")) {

                for (Property property : properties) {
                    if (property instanceof IndustrialProperty) {
                        filteredProperties.add(property);
                    }
                }
                return filteredProperties;
            }
            if (type.equalsIgnoreCase("ResidentialProperty")) {

                for (Property property : properties) {
                    if (property instanceof ResidentialProperty) {
                        filteredProperties.add(property);
                    }
                }
                return filteredProperties;
            }
            return properties;


        }
        return properties;

    }

    public List<Property> getPropertiesByUser(String userId) {
        List<Property> properties = getAllProperties();
        return properties.stream().filter(property -> property.getUserId().equalsIgnoreCase(userId)).collect(Collectors.toList());
    }

    public boolean updateProperty(HttpServletRequest req,Property property, Collection<Part> parts) throws Exception {
        final String UPLOAD_FOLDER = req.getServletContext().getRealPath("/uploads");
        try {
            List<SystemFile> images = property.getImages();
            for (Part part : parts) {
                if ("images[]".equals(part.getName()) && part.getSize() > 0) {
                    String path = FileUtil.saveUploadedFile(req, part, UPLOAD_FOLDER);
                    images.add(new SystemFile(UUIDGenerator.generate(), part.getSubmittedFileName(), path, part.getSize(), part.getContentType(), LocalDateTime.now()));
                }

             }

            property.setImages(images);
            return propertyDao.updateProperty(property);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public boolean deletePropertyImage(String propertyId,String imageId) throws Exception {
        Optional<Property> property = findByID(propertyId);
        if(property.isPresent()){
            Property foundProperty = property.get();
            List<SystemFile> images = foundProperty.getImages();
            int index = -1;
            for (int i = 0; i < images.size(); i++) {
                if (images.get(i).getId().equals(imageId)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new Exception("Property not found");
            }

            // Delete the image file
            FileUtil.deleteFile(images.get(index).getPath());
            images.remove(index);
            foundProperty.setImages(images);
            return propertyDao.updateProperty(foundProperty);
        }
        else throw new Exception("Property not found");

    }
}