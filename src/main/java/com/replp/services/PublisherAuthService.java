package com.replp.services;


import com.replp.dao.UserDAO;
import com.replp.model.User;
import com.replp.util.PasswordHash;

import java.util.Optional;

public class PublisherAuthService {
    private final UserDAO userDAO =new UserDAO();

    public boolean registerUser(User user) throws Exception{
//        Check email is exists
        if (userDAO.findByEmail(user.getEmail()).isPresent()){
            throw new Exception("User all ready exists..");
        }

        return userDAO.writeUser(user);
    }

    public Optional<User> authenticate(String email, String plainPassword) {
        Optional<User> isEmailExists = userDAO.findByEmail(email);
        if (isEmailExists.isPresent()){
            User user = isEmailExists.get();

            if (PasswordHash.checkPassword(plainPassword, user.getPassword())){
                return Optional.of(user);
            }

        }
             return Optional.empty();
    }


}
