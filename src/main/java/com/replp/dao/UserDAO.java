package com.replp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replp.model.User;
import com.replp.util.FileNames;
import com.replp.util.JsonFileActions;

import java.util.List;
import java.util.Optional;

public class UserDAO {
   final JsonFileActions  jsonFileActions = new JsonFileActions(System.getProperty("user.home") + "/.replp/"+ FileNames.USERS);

    public List<User> readUsers() {
        return jsonFileActions.readJsonFile(new TypeReference<List<User>>() {});
    }

    public Optional<User> findUserById(String id) {
        List<User> users = readUsers();
        return users.stream().filter(user -> user.get_id().equals(id)).findFirst();
    }

    public boolean writeUser(User users) {
        return jsonFileActions.writeJsonFile(users, User.class);
    }
}
