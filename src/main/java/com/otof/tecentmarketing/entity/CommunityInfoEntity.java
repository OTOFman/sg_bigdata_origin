package com.otof.tecentmarketing.entity;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityInfoEntity that = (CommunityInfoEntity) o;
        return Objects.equals(communityName, that.communityName) &&
                Objects.equals(buildYear, that.buildYear) &&
                Objects.equals(buildingAmount, that.buildingAmount) &&
                Objects.equals(apartmentAmount, that.apartmentAmount) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(communityName, buildYear, buildingAmount, apartmentAmount, price);
    }
}

