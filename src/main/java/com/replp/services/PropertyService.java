package com.replp.services;

import com.replp.dao.PropertyDao;
import com.replp.model.Property;

import java.util.List;
import java.util.Optional;

public class PropertyService {
    private final PropertyDao propertyDao;

    public PropertyService(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
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
        return propertyDao.deleteProperty(index,ID);
   }
   public Optional<Property> findByID(String ID){
       List<Property>properties=propertyDao.getAllProperties();
       return properties.stream().filter(property -> property.getId().equalsIgnoreCase(ID)).findFirst();
   }
}
