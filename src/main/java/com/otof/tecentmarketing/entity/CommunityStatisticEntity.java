package com.otof.tecentmarketing.entity;

public class CommunityStatisticEntity {

    private int apartmentAmount;
    private int buildingAmount;
    private double radius;
    private double avgPrice;

    public CommunityStatisticEntity(int apartmentAmount, int buildingAmount, double radius, double avgPrice) {
        this.apartmentAmount = apartmentAmount;
        this.buildingAmount = buildingAmount;
        this.radius = radius;
        this.avgPrice = avgPrice;
    }

    public CommunityStatisticEntity() {
    }

    public int getApartmentAmount() {
        return apartmentAmount;
    }

    public void setApartmentAmount(int apartmentAmount) {
        this.apartmentAmount = apartmentAmount;
    }

    public int getBuildingAmount() {
        return buildingAmount;
    }

    public void setBuildingAmount(int buildingAmount) {
        this.buildingAmount = buildingAmount;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public void add(CommunityStatisticEntity other) {
        if (other != null) {
            this.apartmentAmount += other.apartmentAmount;
            this.buildingAmount += other.buildingAmount;
            this.avgPrice = (this.avgPrice + other.avgPrice) / 2;
        }
    }
}
