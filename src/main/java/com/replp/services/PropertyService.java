package com.replp.services;

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
                if ("images[]".equals(part.getName())&& part.getSize() >0){

                String path = FileUtil.saveUploadedFile(req, part, UPLOAD_FOLDER);
                files.add(new SystemFile(UUIDGenerator.generate(), part.getSubmittedFileName(), path, part.getSize(), part.getContentType(), LocalDateTime.now()));
                }
            }

            property.setImages(files);
            return propertyDao.writeProperty(property);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteProperty(String ID) throws Exception {
        List<Property>properties=propertyDao.getAllProperties();
        int index=-1;
        for (int i = 0; i < properties.size(); i++) {
            if(properties.get(i).getId().equalsIgnoreCase(ID)){
                index=i;
            }
        }
        if (index==-1)throw new Exception("Property not found.");
//        return propertyDao.deleteProperty(index,ID);
        return false;
   }
   public Optional<Property> findByID(String ID){
       List<Property>properties=propertyDao.getAllProperties();
       return properties.stream().filter(property -> property.getId().equalsIgnoreCase(ID)).findFirst();
   }

   public List<Property>getAllProperties(){
        return propertyDao.getAllProperties();
   }

   public List<Property>getPropertiesByUser(String userId){
       List<Property>properties= getAllProperties();
       return properties.stream().filter(property -> property.getUserId().equalsIgnoreCase(userId)).collect(Collectors.toList());
   }
}
