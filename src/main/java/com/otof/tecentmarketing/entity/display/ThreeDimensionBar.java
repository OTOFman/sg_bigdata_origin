package com.otof.tecentmarketing.entity.display;

import com.otof.tecentmarketing.entity.evaluation.CommunityEvaluation;
import com.otof.tecentmarketing.entity.evaluation.CompetitorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class ThreeDimensionBar {

    private BarData barData;
    private CompetitorEvaluation competitorEvaluation;
    private TrafficEvaluation trafficEvaluation;
    private CooperatorEvaluation cooperatorEvaluation;
    private CommunityEvaluation communityEvaluation;

    public ThreeDimensionBar() {
        barData = new BarData();
        competitorEvaluation = new CompetitorEvaluation();
        trafficEvaluation = new TrafficEvaluation();
        cooperatorEvaluation = new CooperatorEvaluation();
        communityEvaluation = new CommunityEvaluation();
    }

    @Setter
    @Getter
    public class BarData {
        private List<Integer> data;
        private List<String> backgroundColor;
        private List<String> borderColor;
        private int borderWidth;

        public BarData() {
            backgroundColor = Arrays.asList("rgba(54, 162, 235, 0.2)", "rgba(255, 206, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(105, 92, 187, 0.2)");
            borderColor = Arrays.asList("rgba(54, 162, 235, 0.2)", "rgba(255, 206, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(105, 92, 187, 0.2)");
            borderWidth = 1;
        }
    }
}


