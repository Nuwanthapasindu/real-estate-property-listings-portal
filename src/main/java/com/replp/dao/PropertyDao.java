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
    private final String COMMERCIAL_PROPERTY_FILE_PATH;
    private final String INDUSTRIAL_PROPERTY_FILE_PATH;
    private final String RESIDENTIAL_PROPERTY_FILE_PATH;
    private final JsonFileActions jsonFileActionsForCommercial;
    private final JsonFileActions jsonFileActionsForIndustrial;
    private final JsonFileActions jsonFileActionsForResidential;
    private final PropertyBST propertyBST;

    public PropertyDao() {
        COMMERCIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.COMMERCIAL_PROPERTY;
        INDUSTRIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.INDUSTRIAL_PROPERTY;
        RESIDENTIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.RESIDENTIAL_PROPERTY;

        jsonFileActionsForCommercial = new JsonFileActions(COMMERCIAL_PROPERTY_FILE_PATH);
        jsonFileActionsForIndustrial = new JsonFileActions(INDUSTRIAL_PROPERTY_FILE_PATH);
        jsonFileActionsForResidential = new JsonFileActions(RESIDENTIAL_PROPERTY_FILE_PATH);
        propertyBST=new PropertyBST();

        List<CommercialProperty> commercialProperties= jsonFileActionsForCommercial.readJsonFile(new TypeReference<List<CommercialProperty>>() {});
        List<IndustrialProperty> industrialProperties= jsonFileActionsForCommercial.readJsonFile(new TypeReference<List<IndustrialProperty>>() {});
        List<ResidentialProperty> residentialProperties= jsonFileActionsForCommercial.readJsonFile(new TypeReference<List<ResidentialProperty>>() {});
        List<Property> allProperties = new ArrayList<>();
        allProperties.addAll(commercialProperties);
        allProperties.addAll(industrialProperties);
        allProperties.addAll(residentialProperties);

        for (Property property:allProperties){
            propertyBST.insert(property);
        }
    }

    public List<Property> getAllProperties() {
       return propertyBST.inOrderTraversal();
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
//
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
