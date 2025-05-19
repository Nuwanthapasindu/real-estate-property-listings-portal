package com.replp.services.publicAuthService;

import com.replp.model.PublicUser;

import java.util.Optional;

public interface PublicAuthService {

    /**
     * Registers a new user and creates a new entry in the users.json file.
     * @param user the user to be registered
     * @return true if the user was registered successfully, otherwise false
     * @throws Exception if there is an error registering the user
     */
    public boolean registerUser(PublicUser user) throws Exception;

    /**
     * Authenticates a user based on their email and password.
     * @param email the email of the user to authenticate
     * @param plainPassword the password of the user to authenticate
     * @return an Optional containing the user if authenticated successfully, otherwise an empty Optional
     */
    public Optional<PublicUser> authenticate(String email, String plainPassword);

    /**
     * Generates a One-Time Password (OTP) and sends it to the specified email address.
     *
     * @param email the email address to which the OTP will be sent
     * @return the generated OTP as a string
     */
    public String generateAndSendOtp(String email);

    /**
     * Verifies the OTP of the user.
     *
     * @param email       the email address of the user to verify
     * @param inputOtp    the OTP entered by the user
     * @param sessionOtp  the OTP stored in the session
     * @return true if the OTP is valid, otherwise false
     */
    public boolean verifyOtp(String email, String inputOtp, String sessionOtp);

    /**
     * Updates the password of a user.
     *
     * @param email       the email address of the user to update
     * @param newPassword the new password to set for the user
     * @return true if the password was updated successfully, otherwise false
     */
    public boolean updatePassword(String email, String newPassword);

    /**
     * Updates the password of a user.
     *
     * @param id       the id of the user to find
     * @return true  if the user was found, otherwise false
     */
    public Optional<PublicUser> findById(String id);
}
