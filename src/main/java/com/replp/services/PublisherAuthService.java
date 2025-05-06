package com.replp.services;


import com.replp.dao.UserDAO;
import com.replp.model.User;

public class PublisherAuthService {
    private final UserDAO userDAO =new UserDAO();

    public boolean registerUser(User user) throws Exception{
//        Check email is exists
        if (userDAO.findByEmail(user.getEmail()).isPresent()){
            throw new Exception("User all ready exists..");
        }

        return userDAO.writeUser(user);
    }


}
