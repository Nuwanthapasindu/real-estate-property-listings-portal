package com.replp.model;

import java.util.List;

public class IndustrialProperty extends Property {
    private String industryType;
    private boolean hasLoadingDock;

    public IndustrialProperty() {

    }

    public IndustrialProperty(String id, String title, String location, double price, double size, String sizeType, String description, List<SystemFile> images, String userId, String industryType, boolean hasLoadingDock) {
        super(id, title, location, price, size, sizeType, description, images, userId);
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
                "industryType='" + industryType + '\'' +
                ", hasLoadingDock=" + hasLoadingDock +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", sizeType='" + sizeType + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", userId='" + userId + '\'' +
                '}';
    }
}
