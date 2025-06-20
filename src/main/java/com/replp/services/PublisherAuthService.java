package com.replp.services;


import com.replp.dao.UserDAO;
import com.replp.model.Publisher;
import com.replp.model.User;
import com.replp.util.EmailSender;
import com.replp.util.PasswordHash;

import java.util.Optional;
import java.util.Random;

public class PublisherAuthService {
    private final UserDAO userDAO =new UserDAO();

    public boolean registerUser(Publisher user) throws Exception{
//        Check email is exists
        if (userDAO.findByEmail(user.getEmail()).isPresent()){
            throw new Exception("User all ready exists..");
        }

        return userDAO.writeUser(user);
    }

    public Optional<Publisher> authenticate(String email, String plainPassword) {
        Optional<Publisher> isEmailExists = userDAO.findByEmail(email);
        if (isEmailExists.isPresent()){
            Publisher user = isEmailExists.get();

            if (PasswordHash.checkPassword(plainPassword, user.getPassword())){
                return Optional.of(user);
            }

        }
             return Optional.empty();
    }

    public String generateAndSendOtp(String email) {
        Optional<Publisher> userOpt = userDAO.findByEmail(email);
        if (!userOpt.isPresent()) {
            return null; // email not found
        }

        String otp = String.format("%06d", new Random().nextInt(999999));
        String subject = "Your OTP for password Reset";
        String message = "Hello.\n\n Your OTP for password reset is: " + otp + "\n\n Please use this OTP to  reset your password";

        boolean emailSent = EmailSender.sendEmail(email, subject, message);

        if (emailSent) {
            return otp;
        }else {
            return null;
        }

    }

    public boolean verifyOtp(String email, String inputOtp, String sessionOtp) {
        return inputOtp != null && inputOtp.equals(sessionOtp);
    }
    public boolean updatePassword(String email, String newPassword) {
        return
                userDAO.updatePassword(email,newPassword);
    }

    public Optional<Publisher> findById(String id) {
        return userDAO.findUserById(id);
    }

    public boolean updateProfile(Publisher publisher) {
        return userDAO.updateProfile(publisher);
    }

    public boolean deleteProfile(String id) {
        Optional<Publisher> userOpt = userDAO.findUserById(id);
        if (userOpt.isPresent()) {
            return userDAO.deleteUser(id);
        }
        else return false;
    }
}
