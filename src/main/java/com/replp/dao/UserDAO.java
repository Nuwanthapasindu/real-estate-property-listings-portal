package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.model.Publisher;
import com.replp.model.User;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;
import com.replp.util.PasswordHash;

import java.util.List;
import java.util.Optional;

public class UserDAO {
   final JsonFileActions  jsonFileActions = new JsonFileActions(System.getProperty("user.home") + "/.replp/"+ FileNames.PUBLISHERS);

    /**
     * Reads the list of users from the file containing the list of users.
     *
     * @return the list of users
     */
    public List<Publisher> readUsers() {
        return jsonFileActions.readJsonFile(new TypeReference<List<Publisher>>() {});
    }

    /**
     * Finds a user by the given id.
     *
     * @param id the id of the user to find
     * @return an Optional containing the user if found, empty otherwise
     */
    public Optional<Publisher> findUserById(String id) {
        List<Publisher> users = readUsers();
        Publisher findUuser = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        return Optional.ofNullable(findUuser);
    }

    /**
     * Writes the given user to the file containing the list of users.
     *
     * @param users the user to write
     * @return true if the write is successful, false otherwise
     */
    public boolean writeUser(Publisher users) {
        return jsonFileActions.writeJsonFile(users);
    }

    public Optional<Publisher> findByEmail(String email){
        List<Publisher> users = readUsers();
        Publisher findUuser = users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        return Optional.ofNullable(findUuser);

    }
    /**
     * Updates the password of a user.
     * @param email the email of the user to update
     * @param newPassword the new password to set for the user
     * @return true if the password was updated successfully, false otherwise
     */
    public boolean updatePassword(String email, String newPassword) {
        // Find the user by email
        Publisher selectedUser = null;
        int selectedUserIndex = -1;

        // Read the list of users from the users.json file
        List<Publisher> users = readUsers();

        // Iterate over the list of users and find the user by email
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                selectedUser = users.get(i);
                selectedUserIndex = i;
                break;
            }
        }

        // If the user is not found, return false
        if (selectedUser == null) {
            return false;
        }

        // Set the new password for the user
        selectedUser.setPassword(PasswordHash.hashPassword(newPassword));

        // Write the modified user back to the users.json file
        return jsonFileActions.updateJsonFile(selectedUser, selectedUserIndex);
    }

    public boolean updateProfile(Publisher publisher) {
        // Find the user by email
        Publisher selectedUser = null;
        int selectedUserIndex = -1;

        // Read the list of users from the users.json file
        List<Publisher> users = readUsers();

        // Iterate over the list of users and find the user by email
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(publisher.getId())) {
                selectedUser = users.get(i);
                selectedUserIndex = i;
                break;
            }
        }

        // If the user is not found, return false
        if (selectedUser == null) {
            return false;
        }

        return jsonFileActions.updateJsonFile(publisher, selectedUserIndex);
    }
}
