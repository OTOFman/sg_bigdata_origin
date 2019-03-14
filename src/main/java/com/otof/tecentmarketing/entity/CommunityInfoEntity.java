package com.otof.tecentmarketing.entity;

public class CommunityInfoEntity {

    private String communityName;
    private String buildYear;
    private String buildingAmount;
    private int apartmentAmount;
    private int price;

    public CommunityInfoEntity() {
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

    public int getApartmentAmount() {
        return apartmentAmount;
    }

    public void setApartmentAmount(int apartmentAmount) {
        this.apartmentAmount = apartmentAmount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

