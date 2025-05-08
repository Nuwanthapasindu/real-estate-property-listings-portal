package com.replp.model;

import java.util.List;

public class Property {
    protected String id;
    protected String title;
    protected String type;
    protected String location;
    protected double price;
    protected double size;
    protected String description;
    protected List<File> images;
    protected String userId;

    public Property() {
    }

    public Property(String id, String title, String type, String location, double price, double size, String description, List<File> images, String userId) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.location = location;
        this.price = price;
        this.size = size;
        this.description = description;
        this.images = images;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                '}';
    }
}
