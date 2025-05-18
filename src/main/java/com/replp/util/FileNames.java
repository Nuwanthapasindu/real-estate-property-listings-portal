package com.replp.util;

public class FileNames {
    public static final String USERS = "PublicUsers.json";
    public static final String PUBLISHERS = "Publishers.json";
    public static final String COMMERCIAL_PROPERTY = "commercialProperty.json";
    public static final String INDUSTRIAL_PROPERTY = "industrialProperty.json";
    public static final String RESIDENTIAL_PROPERTY = "ResidentialProperty.json";

    public static String generatePath(String fileName) {
        return System.getProperty("user.home") + "/.replp/"+ fileName;
    }
}

