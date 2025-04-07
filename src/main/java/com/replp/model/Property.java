package com.replp.model;

import java.util.List;

public class Property {
    private int _id;
    private String location;
    private double price;
    private double size;
    private String description;
    private List<File> images;
    private String userId;

    public Property() {
    }

    public Property(int _id, String location, double price, double size, String description, List<File> images, String userId) {
        this._id = _id;
        this.location = location;
        this.price = price;
        this.size = size;
        this.description = description;
        this.images = images;
        this.userId = userId;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<File> getImages() {
        return images;
    }

    public void setImages(List<File> images) {
        this.images = images;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Property{" +
                "_id='" + _id + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                '}';
    }
}
