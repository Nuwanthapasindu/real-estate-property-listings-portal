package com.replp.model;

import java.time.LocalDateTime;
import java.util.List;

public class PublicUser extends User {
    private String type;
    private List<String> wishList;

    public PublicUser() {
        super();
    }


    public PublicUser(String id, String firstName, String lastName, String contactNumber, String email, String password, LocalDateTime createdAt, String type, List<String> wishList) {
        super(id, firstName, lastName, contactNumber, email, password, createdAt);
        this.type = type;
        this.wishList = wishList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
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
                ", wishList=" + wishList +
                ", createdAt=" + createdAt +
                '}';
    }
}
