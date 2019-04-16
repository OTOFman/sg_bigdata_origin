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
public class TrafficEvaluation implements Evaluation {
    int metroAmount;
    int busStationAmount;
    int parkingAmount;
    int evaluation;

    @Override
    public int getEvaluation() {
        return evaluation;
    }
}
