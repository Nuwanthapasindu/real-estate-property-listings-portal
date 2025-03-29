package com.replp.services;

import com.replp.dao.UserDAO;
import com.replp.model.User;

import java.util.List;
import java.util.Optional;

public class AuthService {
        UserDAO userDAO = new UserDAO();

    /**
     * Attempts to login a user with the given email and password.
     * <p>
     * This method reads the list of users from the database and checks if the given email and password
     * matches any of the users in the list. If a match is found, the user is returned as an Optional.
     * </p>
     * @param email the email of the user
     * @param password the password of the user
     * @return an Optional of type User if the login is successful, empty otherwise
     */
    public Optional<User> login(String email, String password) {
        List<User> users = userDAO.readUsers(); // Get the list of users from the database
        User authenticatedUser = null;

        // Iterate over the list of users and check if the given email and password matches any of them
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                authenticatedUser = user;
                break;
            }
        }
        return Optional.ofNullable(authenticatedUser);
    }


}
