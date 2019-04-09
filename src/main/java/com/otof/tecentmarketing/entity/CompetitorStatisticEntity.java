package com.otof.tecentmarketing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CompetitorStatisticEntity {

    private int competitorAmountWith1Km;
    private int competitorAmountWith2Km;
    private int competitorAmountWith3Km;
    private double competitionEvaluate;
    private List<Institute> instituteList;

}

@AllArgsConstructor
@Getter
class Institute {
    String name;
    boolean isStar;
    String address;
}