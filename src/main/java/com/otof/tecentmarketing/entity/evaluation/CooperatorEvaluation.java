package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CooperatorEvaluation implements Evaluation {
    int cooperatorAmount;
    int evaluation;

    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
