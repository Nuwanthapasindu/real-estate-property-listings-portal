package com.replp.model;

import java.util.List;

public class IndustrialProperty extends Property {
    private String industryType;
    private boolean hasLoadingDock;

    public IndustrialProperty() {

    }

    public IndustrialProperty(String id, String title, String type, String location, double price, double size, String description, List<File> images, String userId, String industryType, boolean hasLoadingDock) {
        super(id, title, type, location, price, size, description, images, userId);
        this.industryType = industryType;
        this.hasLoadingDock = hasLoadingDock;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public boolean isHasLoadingDock() {
        return hasLoadingDock;
    }

    public void setHasLoadingDock(boolean hasLoadingDock) {
        this.hasLoadingDock = hasLoadingDock;
    }

    @Override
    public String toString() {
        return "IndustrialProperty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                ", industryType='" + industryType + '\'' +
                ", hasLoadingDock=" + hasLoadingDock +
                '}';
    }
}
