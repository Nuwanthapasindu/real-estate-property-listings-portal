package com.replp.model;

import java.util.List;

public class CommercialProperty extends Property {
    private String businessType;
    private boolean hasParking;

    public CommercialProperty() {
    }

    public CommercialProperty(int id, String title, String type, String location, double price, double size, String description, List<File> images, String userId, String businessType, boolean hasParking) {
        super(id, title, type, location, price, size, description, images, userId);
        this.businessType = businessType;
        this.hasParking = hasParking;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    @Override
    public String toString() {
        return "CommercialProperty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                ", businessType='" + businessType + '\'' +
                ", hasParking=" + hasParking +
                '}';
    }
}
