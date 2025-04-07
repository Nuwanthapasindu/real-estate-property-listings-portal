package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.model.Property;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;


import java.util.List;

public class PropertyDao {
    private final String FILE_PATH;
    private JsonFileActions jsonFileActions;

    public PropertyDao() {
        FILE_PATH = System.getProperty("user.home") + "/.replp/"+ FileNames.PROPERTIES;
        jsonFileActions = new JsonFileActions(FILE_PATH);
        System.out.println(FILE_PATH);
    }

    public List<Property> getAllProperties() {
        return jsonFileActions.readJsonFile(new TypeReference<List<Property>>() {});
    }




    public boolean writeProperty(Property property){
        return  jsonFileActions.writeJsonFile(property,Property.class);
    }


}
