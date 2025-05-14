package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.DSA.PropertyBST;
import com.replp.model.CommercialProperty;
import com.replp.model.IndustrialProperty;
import com.replp.model.Property;
import com.replp.model.ResidentialProperty;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;


import java.util.ArrayList;
import java.util.List;

public class PropertyDao {

    // --- Singleton Setup ---
    private static PropertyDao instance;

    public static synchronized PropertyDao getInstance() {
        if (instance == null) {
            instance = new PropertyDao();
        }
        return instance;
    }

    private final String COMMERCIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.COMMERCIAL_PROPERTY;
    private final String INDUSTRIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.INDUSTRIAL_PROPERTY;
    private final String RESIDENTIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.RESIDENTIAL_PROPERTY;
    private final JsonFileActions jsonFileActionsForCommercial;
    private final JsonFileActions jsonFileActionsForIndustrial;
    private final JsonFileActions jsonFileActionsForResidential;
    private final PropertyBST propertyBST;

    public PropertyDao() {
        propertyBST=new PropertyBST();
        jsonFileActionsForCommercial = new JsonFileActions(COMMERCIAL_PROPERTY_FILE_PATH);
        jsonFileActionsForIndustrial = new JsonFileActions(INDUSTRIAL_PROPERTY_FILE_PATH);
        jsonFileActionsForResidential = new JsonFileActions(RESIDENTIAL_PROPERTY_FILE_PATH);

        List<CommercialProperty> commercialProperties = jsonFileActionsForCommercial.readJsonFile(new TypeReference<List<CommercialProperty>>() {});
        List<IndustrialProperty> industrialProperties = jsonFileActionsForIndustrial.readJsonFile(new TypeReference<List<IndustrialProperty>>() {});
        List<ResidentialProperty> residentialProperties = jsonFileActionsForResidential.readJsonFile(new TypeReference<List<ResidentialProperty>>() {});

        List<Property> properties = new ArrayList<>();
        properties.addAll(commercialProperties);
        properties.addAll(industrialProperties);
        properties.addAll(residentialProperties);

        for (Property property : properties) {
            propertyBST.insert(property);
        }
    }

    public List<Property> getAllProperties() {
       return  propertyBST.inOrderTraversal();
    }

    public boolean writeProperty(Property property) throws Exception {
        if (property instanceof CommercialProperty) {
            propertyBST.insert(property);
            return  jsonFileActionsForCommercial.writeJsonFile(property);
        } else if (property instanceof IndustrialProperty) {
            propertyBST.insert(property);
            return  jsonFileActionsForIndustrial.writeJsonFile(property);
        } else if (property instanceof ResidentialProperty) {
            propertyBST.insert(property);
            return  jsonFileActionsForResidential.writeJsonFile(property);
        }else throw new Exception("Invalid property type");
    }


//    public boolean deleteCommercialProperty( int index,String ID){
//        propertyBST.deleteById(ID);
//        return  jsonFileActions.deleteJsonFile(index);
//    }
//
//    public boolean deleteResidentialProperty( int index,String ID){
//        propertyBST.deleteById(ID);
//
//        return  jsonFileActions.deleteJsonFile(index);
//    }
//
//    public boolean deleteIndustrialProperty( int index,String ID){
//        propertyBST.deleteById(ID);
//
//        return  jsonFileActions.deleteJsonFile(index);
//    }


}
