package com.replp.model;

public class PublicUser extends User {
    private String type;

    public PublicUser() {
        super();
    }

    public PublicUser(String id, String firstName, String lastName, String contactNumber, String email, String password, String type) {
        super(id, firstName, lastName, contactNumber, email, password);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PublicUser{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
