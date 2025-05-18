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
import java.util.Optional;

public class PropertyDao {

    private final static String COMMERCIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.COMMERCIAL_PROPERTY;
    private final static String INDUSTRIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.INDUSTRIAL_PROPERTY;
    private final static String RESIDENTIAL_PROPERTY_FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.RESIDENTIAL_PROPERTY;
    private static final JsonFileActions jsonFileActionsForCommercial;
    private static final JsonFileActions jsonFileActionsForIndustrial;
    private static final JsonFileActions jsonFileActionsForResidential;

    static {
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
            PropertyBST.insert(property);
        }

    }

    public List<Property> getAllProperties() {
       return  PropertyBST.inOrderTraversal();
    }

    public boolean writeProperty(Property property) throws Exception {
        if (property instanceof CommercialProperty) {
            PropertyBST.insert(property);
            return  jsonFileActionsForCommercial.writeJsonFile(property);
        } else if (property instanceof IndustrialProperty) {
            PropertyBST.insert(property);
            return  jsonFileActionsForIndustrial.writeJsonFile(property);
        } else if (property instanceof ResidentialProperty) {
            PropertyBST.insert(property);
            return  jsonFileActionsForResidential.writeJsonFile(property);
        }else throw new Exception("Invalid property type");
    }

    public Optional<Property> findPropertyByID(String ID) {
        return Optional.ofNullable(PropertyBST.findById(ID));
    }


    public boolean deleteProperty(Property property,String ID) throws  Exception{
             int index = -1;
         if (property instanceof CommercialProperty) {
             List<CommercialProperty> commercialProperties = commercialProperties();
             for (int i = 0; i < commercialProperties.size(); i++) {
                 if (commercialProperties.get(i).getId().equals(ID)) {
                     index = i;
                     break;
                 }
             }
             if (index != -1) {
                 PropertyBST.deleteById(ID);
                 return  jsonFileActionsForCommercial.deleteJsonFile(index);

             } else {
                 throw new Exception("Property not found");
             }
         } else if (property instanceof IndustrialProperty) {
             List<IndustrialProperty> industrialProperties = industrialProperties();

             for (int i = 0; i < industrialProperties.size(); i++) {
                 if (industrialProperties.get(i).getId().equals(ID)) {
                     index = i;
                     break;
                 }
             }
             if (index != -1) {
                 PropertyBST.deleteById(ID);
                 return  jsonFileActionsForIndustrial.deleteJsonFile(index);
             } else {
                 throw new Exception("Property not found");
             }
         }else if (property instanceof ResidentialProperty) {
             List<ResidentialProperty> residentialProperties = residentialProperties();
             for (int i = 0; i < residentialProperties.size(); i++) {
                 if (residentialProperties.get(i).getId().equals(ID)) {
                     index = i;
                     break;
                 }
             }
             if (index != -1) {
                 PropertyBST.deleteById(ID);
                 return  jsonFileActionsForResidential.deleteJsonFile(index);
             } else {
                 throw new Exception("Property not found");
             }
         }else throw new Exception("Invalid property type");
    }

    private List<CommercialProperty> commercialProperties(){
        return jsonFileActionsForCommercial.readJsonFile(new TypeReference<List<CommercialProperty>>() {});
    }

    private List<IndustrialProperty> industrialProperties(){
        return jsonFileActionsForIndustrial.readJsonFile(new TypeReference<List<IndustrialProperty>>() {});
    }

    private List<ResidentialProperty> residentialProperties(){
        return jsonFileActionsForResidential.readJsonFile(new TypeReference<List<ResidentialProperty>>() {});
    }

    public boolean updateProperty(Property property) throws Exception {
        if (property instanceof CommercialProperty) {
            int index = -1;
            List<CommercialProperty> commercialProperties = commercialProperties();
            for (int i = 0; i < commercialProperties.size(); i++) {
                if (commercialProperties.get(i).getId().equals(property.getId())) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new Exception("Property not found");
            }
            PropertyBST.updateById(property.getId(), property);
            return  jsonFileActionsForCommercial.updateJsonFile(property,index);
        } else if (property instanceof IndustrialProperty) {
            int index = -1;
            List<IndustrialProperty> industrialProperties = industrialProperties();
            for (int i = 0; i < industrialProperties.size(); i++) {
                if (industrialProperties.get(i).getId().equals(property.getId())) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new Exception("Property not found");
            }
            PropertyBST.updateById(property.getId(), property);
            return  jsonFileActionsForIndustrial.updateJsonFile(property,index);
        } else if (property instanceof ResidentialProperty) {
            int index = -1;
            List<ResidentialProperty> residentialProperties = residentialProperties();
            for (int i = 0; i < residentialProperties.size(); i++) {
                if (residentialProperties.get(i).getId().equals(property.getId())) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new Exception("Property not found");
            }
            PropertyBST.updateById(property.getId(), property);
            return jsonFileActionsForResidential.updateJsonFile(property, index);
        }else  throw new Exception("Invalid property type");
    }


}
