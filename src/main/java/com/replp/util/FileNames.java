package com.replp.util;

public class FileNames {
    public static final String USERS = "PublicUsers.json";
    public static final String PUBLISHERS = "Publishers.json";
    public static final String PROPERTIES = "properties.json";

    public static String generatePath(String fileName) {
        return System.getProperty("user.home") + "/.replp/"+ fileName;
    }
}