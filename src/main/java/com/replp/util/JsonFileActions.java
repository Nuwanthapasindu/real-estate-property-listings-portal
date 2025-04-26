package com.replp.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonFileActions {
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    private  String filePath;

    public JsonFileActions() {
    }

    public JsonFileActions(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Initializes the data storage for the application. This includes creating the directory to store the data files
     * and writing an empty list to the file.
     *
     * @param fileName the name of the file to be created
     * @return true if the initialization was successful, false otherwise
     */
    public boolean dataStorageInitialization(String fileName) {
        File file = new File(System.getProperty("user.home") + "/.replp/" + fileName);
        File directory = file.getParentFile();

        try {
            // create the directory if it does not exist
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // if the directory could not be created, throw an exception
            if (!directory.exists()) {
                throw new IOException("Could not create directory: " + directory);
            }
            // if the file does not exist, write an empty list to it
            if (!file.exists()) {
                OBJECT_MAPPER.writeValue(file, Collections.emptyList());
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }





    /**
     * Reads the contents of a JSON file into a list of objects of type T. If the file does not exist,
     * an empty list is returned.
     *
     * @param typeReference the type reference for the list of objects
     * @return the list of objects of type T
     */
    public <T> List<T> readJsonFile(TypeReference<List<T>> typeReference) {
        try {
            File file = new File(filePath);

            // if the file does not exist, return an empty list
            if (!file.exists()) {
                return new ArrayList<>();
            }

            // read the file into a list of objects of type T
            return OBJECT_MAPPER.readValue(file, typeReference);
        } catch (IOException e) {
            // if there is an error reading the file, wrap it in a RuntimeException
            throw new RuntimeException(e);
        }
    }


    /**
     * Write new data to a JSON file. If the file does not exist, a RuntimeException will be thrown.
     * @param newData the data to be written to the file
     * @return true if the data was written successfully
     */
    public <T> boolean writeJsonFile( T newData) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException(file.getName() + "File does not exist");
        }
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
        try {
            // read the file into a list of objects of type T
            List<T> data = readJsonFile(typeReference);
            // add the new data to the list
            data.add(newData);
            // write the modified list back to the file
            OBJECT_MAPPER.writeValue(file, data);
            // if the data was written successfully, return true
            return true;
        } catch (RuntimeException | IOException e) {
            // if there is an error writing the file, wrap it in a RuntimeException
            throw new RuntimeException(e);
        }
    }

    /**
     * Deletes an object from a JSON file by its index. If the file does not exist, a RuntimeException will be thrown.
     *
     * @param indexToRemove the index of the object to be deleted
     * @return true if the object was deleted successfully, false otherwise
     */
    public <T> boolean deleteJsonFile(int indexToRemove) {
        // Create a File object with the specified file path
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            // Throw an exception if the file does not exist
            throw new RuntimeException(file.getName() + "File does not exist");
        }

        try {
            // Read the contents of the file into a list of objects of type T
            List<T> data = readJsonFile(new TypeReference<List<T>>() {});

//            // Remove the objectToRemove from the list
            data.remove(indexToRemove);

            // Write the modified list back to the file
            OBJECT_MAPPER.writeValue(file, data);

            // If the data was written successfully, return true
            return true;
        } catch (RuntimeException | IOException e) {
            // If there is an error writing the file, wrap it in a RuntimeException
            throw new RuntimeException(e);
        }
    }


    /**
     * Updates an object in a JSON file. If the file does not exist, a RuntimeException will be thrown.
     * @param updatedData the updated object to be written to the file
     * @param indexToRemove the index of the object to be updated
     * @return true if the object was updated successfully
     */
    public <T> boolean updateJsonFile(T updatedData, int indexToRemove) {

        // Create a File object with the specified file path
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            // Throw an exception if the file does not exist
            throw new RuntimeException(file.getName() + "File does not exist");
        }

        // Create a TypeReference for the list of objects of type T
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};

        try {
            // Read the contents of the file into a list of objects of type T
            List<T> data = readJsonFile(typeReference);

            // If the indexToRemove is out of bounds, return false
            if (indexToRemove < 0 || indexToRemove >= data.size()) {
                return false;
            }

            // Update the object in the list
            data.set(indexToRemove, updatedData);

            // Write the modified list back to the file
            OBJECT_MAPPER.writeValue(file, data);

            // If the data was written successfully, return true
            return true;

        } catch (RuntimeException | IOException e) {
            // If there is an error writing the file, wrap it in a RuntimeException
            throw new RuntimeException(e);
        }
    }





}