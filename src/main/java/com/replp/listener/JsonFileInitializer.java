package com.replp.listener;

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
        System.out.println("Properties.json Create: " + jsonFileActions.dataStorageInitialization("properties.json"));
        System.out.println("Users.json Create: " + jsonFileActions.dataStorageInitialization("users.json"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Closing data storage...");
    }
}
