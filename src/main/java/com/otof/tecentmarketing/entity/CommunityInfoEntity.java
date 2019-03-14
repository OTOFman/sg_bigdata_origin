package com.otof.tecentmarketing.entity;

public class CommunityInfoEntity {

    private String communityName;
    private String buildYear;
    private String buildingAmount;
    private String apartmentAmount;
    private String price;

    public CommunityInfoEntity() {
    }

    public CommunityInfoEntity(String communityName, String buildYear, String buildingAmount, String apartmentAmount, String price) {
        this.communityName = communityName;
        this.buildYear = buildYear;
        this.buildingAmount = buildingAmount;
        this.apartmentAmount = apartmentAmount;
        this.price = price;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getBuildingAmount() {
        return buildingAmount;
    }

    public void setBuildingAmount(String buildingAmount) {
        this.buildingAmount = buildingAmount;
    }

    public String getApartmentAmount() {
        return apartmentAmount;
    }

    public void setApartmentAmount(String apartmentAmount) {
        this.apartmentAmount = apartmentAmount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

