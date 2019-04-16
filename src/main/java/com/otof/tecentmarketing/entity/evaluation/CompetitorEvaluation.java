package com.otof.tecentmarketing.entity.evaluation;

import com.otof.tecentmarketing.entity.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompetitorEvaluation implements Evaluation {
    int competitorAmount;
    int starCompetitorAmount;
    int evaluation;


    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
