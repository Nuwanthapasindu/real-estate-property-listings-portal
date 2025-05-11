package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.DSA.PropertyBST;
import com.replp.model.Property;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;


import java.util.List;

public class PropertyDao {
    private final String FILE_PATH;
    private final JsonFileActions jsonFileActions;
    private final PropertyBST propertyBST;

    public PropertyDao() {
        FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.PROPERTIES;
        jsonFileActions = new JsonFileActions(FILE_PATH);
        propertyBST=new PropertyBST();
        List<Property> properties= jsonFileActions.readJsonFile(new TypeReference<List<Property>>() {});
        for (Property property:properties){
            propertyBST.insert(property);
        }
    }

    public List<Property> getAllProperties() {
       return propertyBST.inOrderTraversal();
    }




    public boolean writeProperty(Property property){
        propertyBST.insert(property);
        return  jsonFileActions.writeJsonFile(property);
    }
    public boolean deleteProperty( int index,String ID){
        propertyBST.deleteById(ID);

        return  jsonFileActions.deleteJsonFile(index);
    }


}
