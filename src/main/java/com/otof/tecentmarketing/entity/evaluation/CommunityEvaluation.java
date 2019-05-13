package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class CommunityEvaluation {

    private int apartmentAmount;
    private int buildingAmount;
    private String avgBuildYear;
    private double childrenAmount;
    private int potentialUserAmount;
    private double radius;
    private double avgPrice;
    private int evaluation;
    private Map<String, CommunityInfoEntity> communityInfoEntityMap;

    public CommunityEvaluation() {
        this.communityInfoEntityMap = new HashMap<>();
    }
}
