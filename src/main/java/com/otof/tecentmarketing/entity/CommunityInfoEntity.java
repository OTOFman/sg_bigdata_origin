package com.otof.tecentmarketing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CommunityInfoEntity {

    private String communityName;
    private String buildYear;
    private int buildingAmount;
    private int apartmentAmount;
    private int price;

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

