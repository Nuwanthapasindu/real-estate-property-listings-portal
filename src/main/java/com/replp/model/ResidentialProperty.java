package com.replp.model;

import java.util.List;

public class ResidentialProperty extends Property {
    private int bedrooms;
    private int bathrooms;
    private boolean hasGarage;

    public ResidentialProperty() {
    }

    public ResidentialProperty(String id, String title, String location, double price, double size, String description, List<SystemFile> images, String userId, int bedrooms, int bathrooms, boolean hasGarage) {
        super(id, title, location, price, size, description, images, userId);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.hasGarage = hasGarage;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    @Override
    public String toString() {
        return "ResidentialProperty{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", hasGarage=" + hasGarage +
                ", userId='" + userId + '\'' +
                '}';
    }
}
