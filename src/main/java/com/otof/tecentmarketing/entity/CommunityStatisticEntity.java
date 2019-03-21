package com.otof.tecentmarketing.entity;

public class CommunityStatisticEntity {

    private int avgApartmentAmount;
    private int avgBuildingAmount;
    private double radius;
    private double avgPrice;

    public CommunityStatisticEntity(int avgApartmentAmount, int avgBuildingAmount, double radius, double avgPrice) {
        this.avgApartmentAmount = avgApartmentAmount;
        this.avgBuildingAmount = avgBuildingAmount;
        this.radius = radius;
        this.avgPrice = avgPrice;
    }

    public CommunityStatisticEntity() {
    }

    public int getAvgApartmentAmount() {
        return avgApartmentAmount;
    }

    public void setAvgApartmentAmount(int avgApartmentAmount) {
        this.avgApartmentAmount = avgApartmentAmount;
    }

    public int getAvgBuildingAmount() {
        return avgBuildingAmount;
    }

    public void setAvgBuildingAmount(int avgBuildingAmount) {
        this.avgBuildingAmount = avgBuildingAmount;
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
            this.avgApartmentAmount += other.avgApartmentAmount;
            this.avgBuildingAmount += other.avgBuildingAmount;
            this.avgPrice = (this.avgPrice + other.avgPrice) / 2;
        }
    }
}
