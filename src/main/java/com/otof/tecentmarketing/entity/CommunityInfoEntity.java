package com.otof.tecentmarketing.entity;

import java.util.Objects;

public class CommunityInfoEntity {

    private String communityName;
    private String buildYear;
    private int buildingAmount;
    private int apartmentAmount;
    private int price;

    public CommunityInfoEntity() {
    }

    public CommunityInfoEntity(String communityName, String buildYear, int buildingAmount, int apartmentAmount, int price) {
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

    public int getBuildingAmount() {
        return buildingAmount;
    }

    public void setBuildingAmount(int buildingAmount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityInfoEntity that = (CommunityInfoEntity) o;
        return Objects.equals(communityName, that.communityName) &&
                Objects.equals(buildYear, that.buildYear) &&
                buildingAmount == that.buildingAmount &&
                apartmentAmount == apartmentAmount &&
                price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(communityName, buildYear, buildingAmount, apartmentAmount, price);
    }
}

