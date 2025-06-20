package com.replp.listener;

import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JsonFileInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing data storage...");
        JsonFileActions jsonFileActions = new JsonFileActions();
        System.out.println("PublicUsers.json Create: " + jsonFileActions.dataStorageInitialization(FileNames.USERS));
        System.out.println("Publishers.json Create: " + jsonFileActions.dataStorageInitialization(FileNames.PUBLISHERS));
        System.out.println("commercialProperty.json Create: " + jsonFileActions.dataStorageInitialization(FileNames.COMMERCIAL_PROPERTY));
        System.out.println("industrialProperty.json Create: " + jsonFileActions.dataStorageInitialization(FileNames.INDUSTRIAL_PROPERTY));
        System.out.println("ResidentialProperty.json Create: " + jsonFileActions.dataStorageInitialization(FileNames.RESIDENTIAL_PROPERTY));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Closing data storage...");
    }
}