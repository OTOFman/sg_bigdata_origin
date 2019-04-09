package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.Evaluation;

public class SurroundEvaluation implements Evaluation {
    int apartmentAmount;
    String purchasingPower;
    String averageYear;
    int evaluation;

    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
