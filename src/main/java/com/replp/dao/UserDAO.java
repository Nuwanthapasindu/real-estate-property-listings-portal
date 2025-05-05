package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.model.User;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;

import java.util.List;
import java.util.Optional;

public class UserDAO {
   final JsonFileActions  jsonFileActions = new JsonFileActions(System.getProperty("user.home") + "/.replp/"+ FileNames.USERS);

    /**
     * Reads the list of users from the file containing the list of users.
     *
     * @return the list of users
     */
    public List<User> readUsers() {
        return jsonFileActions.readJsonFile(new TypeReference<List<User>>() {});
    }

    /**
     * Finds a user by the given id.
     *
     * @param id the id of the user to find
     * @return an Optional containing the user if found, empty otherwise
     */
    public Optional<User> findUserById(String id) {
        List<User> users = readUsers();
        User findUuser = users.stream().filter(user -> user.get_id().equals(id)).findFirst().orElse(null);
        return Optional.ofNullable(findUuser);
    }

    /**
     * Writes the given user to the file containing the list of users.
     *
     * @param users the user to write
     * @return true if the write is successful, false otherwise
     */
    public boolean writeUser(User users) {
        return jsonFileActions.writeJsonFile(users);
    }
}
