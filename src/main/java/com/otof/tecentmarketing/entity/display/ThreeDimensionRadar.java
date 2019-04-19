package com.otof.tecentmarketing.entity.display;

import com.otof.tecentmarketing.entity.evaluation.CompetitorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class ThreeDimensionRadar {

    private RadarData radarData;
    private CompetitorEvaluation competitorEvaluation;
    private TrafficEvaluation trafficEvaluation;
    private CooperatorEvaluation cooperatorEvaluation;

    public ThreeDimensionRadar() {
        radarData = new RadarData();
        competitorEvaluation = new CompetitorEvaluation();
        trafficEvaluation = new TrafficEvaluation();
        cooperatorEvaluation = new CooperatorEvaluation();
    }

    @Setter
    @Getter
    public class RadarData {
        private List<Integer> data;
        private List<String> backgroundColor;
        private List<String> borderColor;
        private int borderWidth;
        private String pointStyle;
        private List<String> pointBackgroundColor;

        public RadarData() {
            backgroundColor = Arrays.asList("rgba(255, 99, 132, 0.2)");
            borderColor = Arrays.asList("rgba(255, 99, 132, 1)");
            borderWidth = 2;
            pointStyle = "star";
            pointBackgroundColor = Arrays.asList("rgba(54, 162, 235, 1)");
        }
    }
}


