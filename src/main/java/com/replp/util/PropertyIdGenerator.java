package com.replp.util;

import com.replp.dao.PropertyDao;
import com.replp.model.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyIdGenerator {
    private static PropertyDao propertyDao = new PropertyDao();


    /**
     * Returns the next id that should be used when creating a new Property.
     *
     * The next id is determined by querying the database for all Properties, and
     * then returning the size of the list plus one. If the list is empty, the
     * method returns one.
     *
     * @return the next id that should be used when creating a new Property
     */
    public static int nextId() {
        // GET ALL PROPERTIES FROM DATABASE
        List<Property> properties = propertyDao.getAllProperties();
        return properties.isEmpty() ? 1 : properties.size() + 1;

    }

}
