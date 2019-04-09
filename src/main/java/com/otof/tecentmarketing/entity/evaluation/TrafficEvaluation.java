package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.Evaluation;

public class TrafficEvaluation implements Evaluation {
    int metroAmount;
    int busAmount;
    int evaluation;

    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
