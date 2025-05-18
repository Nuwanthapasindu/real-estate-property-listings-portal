package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.model.PublicUser;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;
import com.replp.util.PasswordHash;

import java.util.List;
import java.util.Optional;

public class PublicUserDao {
    final JsonFileActions jsonFileActions = new JsonFileActions(FileNames.generatePath(FileNames.USERS));


    /**
     * Reads the list of users from the users.json file.
     * If the file does not exist, an empty list is returned.
     * @return the list of users
     */
    public List<PublicUser> readUsers() {
        return jsonFileActions.readJsonFile(new TypeReference<List<PublicUser>>() {});
    }


    /**
     * Finds a user by id.
     * @param id the id of the user to find
     * @return an Optional containing the user if found, otherwise an empty Optional
     */
    public Optional<PublicUser> findUserById(String id) {
        // read the list of users from the users.json file
        List<PublicUser> users = readUsers();
        // use Stream API to find the user by id
        PublicUser findUser = users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        // return an Optional containing the user if found, otherwise an empty Optional
        return Optional.ofNullable(findUser);
    }


    /**
     * Writes a new user to the users.json file.
     * @param users the user to be written to the file
     * @return true if the user was written successfully
     */
    public boolean writeUser(PublicUser users) {
        return jsonFileActions.writeJsonFile(users);
    }

    /**
     * Finds a user by email.
     * @param email the email of the user to find
     * @return an Optional containing the user if found, otherwise an empty Optional
     */
    public Optional<PublicUser> findByEmail(String email){
        // read the list of users from the users.json file
        List<PublicUser> users = readUsers();
        // use Stream API to find the user by email
        PublicUser findUser = users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        // return an Optional containing the user if found, otherwise an empty Optional
        return Optional.ofNullable(findUser);
    }

    /**
     * Updates the password of a user.
     * @param email the email of the user to update
     * @param newPassword the new password to set for the user
     * @return true if the password was updated successfully, false otherwise
     */
    public boolean updatePassword(String email, String newPassword) {
        // Find the user by email
        PublicUser selectedUser = null;
        int selectedUserIndex = -1;

        // Read the list of users from the users.json file
        List<PublicUser> users = readUsers();

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


    /**
     * Updates the wish list of a user.
     * @param user the user whose wish list to update
     * @return true if the wish list was updated successfully, false otherwise
     */
    public boolean updateWishList(PublicUser user){
        int index = -1;
        List<PublicUser> users = readUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        return jsonFileActions.updateJsonFile(user,index);
    }



}
