package com.replp.services.publicAuthService;

import com.replp.dao.PublicUserDao;
import com.replp.model.PublicUser;
import com.replp.util.EmailSender;
import com.replp.util.PasswordHash;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class PublicAuthServiceImpl implements PublicAuthService {
    private final PublicUserDao  publicUserDao =new PublicUserDao();

    @Override
    public boolean registerUser(PublicUser user) throws Exception {
        if (publicUserDao.findByEmail(user.getEmail()).isPresent()){
            throw new Exception("User all ready exists..");
        }

        return publicUserDao.writeUser(user);
    }

    @Override
    public Optional<PublicUser> authenticate(String email, String plainPassword) {
        Optional<PublicUser> isEmailExists = publicUserDao.findByEmail(email);
        if (isEmailExists.isPresent()){
            PublicUser user = isEmailExists.get();

            if (PasswordHash.checkPassword(plainPassword, user.getPassword())){
                return Optional.of(user);
            }

        }
        return Optional.empty();
    }

    @Override
    public String generateAndSendOtp(String email) {
        Optional<PublicUser> userOpt = publicUserDao.findByEmail(email);
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

    @Override
    public boolean verifyOtp(String email, String inputOtp, String sessionOtp) {
        return inputOtp != null && inputOtp.equals(sessionOtp);
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        return publicUserDao.updatePassword(email, newPassword);
    }

    @Override
    public Optional<PublicUser> findById(String id) {
        List<PublicUser> users = publicUserDao.readUsers();
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
