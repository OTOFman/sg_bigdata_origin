package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
import com.otof.tecentmarketing.entity.display.ThreeDimensionRadar;
import com.otof.tecentmarketing.entity.evaluation.CompetitorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
@NoArgsConstructor
public class SiteSelectionStatisticService {

    @Autowired
    CompetitorStatisticService competitorStatisticService;
    @Autowired
    CooperatorStatisticService cooperatorStatisticService;
    @Autowired
    TrafficStatisticService trafficStatisticService;

    public SiteSelectionResultEntity getSiteSelectionResult(String location) throws URISyntaxException, InterruptedException {
        SiteSelectionResultEntity siteSelectionResultEntity = new SiteSelectionResultEntity();
        siteSelectionResultEntity.setCompetitorEvaluation(competitorStatisticService.getCompetitorEvaluation(location));
        siteSelectionResultEntity.setCooperatorEvaluation(cooperatorStatisticService.getCooperatorEvaluation(location));
        siteSelectionResultEntity.setTrafficEvaluation(trafficStatisticService.getTrafficEvaluation(location));

        return siteSelectionResultEntity;
    }

    public ThreeDimensionRadar getThreeDimensionResult(String location) throws URISyntaxException, InterruptedException {
        ThreeDimensionRadar threeDimensionRadar = new ThreeDimensionRadar();
        List<Integer> dataList = new ArrayList<>();
        CompetitorEvaluation competitorEvaluation = competitorStatisticService.getCompetitorEvaluation(location);
        CooperatorEvaluation cooperatorEvaluation = cooperatorStatisticService.getCooperatorEvaluation(location);
        TrafficEvaluation trafficEvaluation = trafficStatisticService.getTrafficEvaluation(location);

        dataList.add(competitorEvaluation.getEvaluation());
        dataList.add(cooperatorEvaluation.getEvaluation());
        dataList.add(trafficEvaluation.getEvaluation());

        threeDimensionRadar.getRadarData().setData(dataList);
        threeDimensionRadar.getRadarData().setLabel("交通-竞业-异业评估");
        threeDimensionRadar.setCompetitorEvaluation(competitorEvaluation);
        threeDimensionRadar.setCooperatorEvaluation(cooperatorEvaluation);
        threeDimensionRadar.setTrafficEvaluation(trafficEvaluation);
        return threeDimensionRadar;
    }
}
