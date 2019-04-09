package com.otof.tecentmarketing.entity;

import com.otof.tecentmarketing.entity.evaluation.CompetitorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.SurroundEvaluation;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteSelectionResultEntity {
    private SurroundEvaluation surroundEvaluate;
    private TrafficEvaluation trafficEvaluation;
    private CooperatorEvaluation cooperatorEvaluation;
    private CompetitorEvaluation competitorEvaluation;
}


