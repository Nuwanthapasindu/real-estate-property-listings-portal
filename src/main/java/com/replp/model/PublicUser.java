package com.replp.model;

import java.util.List;

public class PublicUser extends User {
    private String type;
    private List<Property> wishList;

    public PublicUser() {
        super();
    }


    public PublicUser(String id, String firstName, String lastName, String contactNumber, String email, String password, String type, List<Property> wishList) {
        super(id, firstName, lastName, contactNumber, email, password);
        this.type = type;
        this.wishList = wishList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Property> getWishList() {
        return wishList;
    }

    public void setWishList(List<Property> wishList) {
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
                ", wishList=" + wishList +
                ", type='" + type + '\'' +
                '}';
    }
}
