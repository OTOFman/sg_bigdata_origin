package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CooperatorEvaluation implements Evaluation {
    int cooperatorAmount;
    int evaluation;

    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
