package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
import com.otof.tecentmarketing.entity.display.ThreeDimensionBar;
import com.otof.tecentmarketing.entity.evaluation.CommunityEvaluation;
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
    @Autowired
    CommunityStatisticService communityStatisticService;

    public SiteSelectionResultEntity getSiteSelectionResult(String location) throws URISyntaxException, InterruptedException {
        SiteSelectionResultEntity siteSelectionResultEntity = new SiteSelectionResultEntity();
        siteSelectionResultEntity.setCompetitorEvaluation(competitorStatisticService.getCompetitorEvaluation(location));
        siteSelectionResultEntity.setCooperatorEvaluation(cooperatorStatisticService.getCooperatorEvaluation(location));
        siteSelectionResultEntity.setTrafficEvaluation(trafficStatisticService.getTrafficEvaluation(location));

        return siteSelectionResultEntity;
    }

    public ThreeDimensionBar getThreeDimensionResult(String location) throws URISyntaxException, InterruptedException {
        ThreeDimensionBar threeDimensionBar = new ThreeDimensionBar();
        List<Integer> dataList = new ArrayList<>();
        CompetitorEvaluation competitorEvaluation = competitorStatisticService.getCompetitorEvaluation(location);
        CooperatorEvaluation cooperatorEvaluation = cooperatorStatisticService.getCooperatorEvaluation(location);
        TrafficEvaluation trafficEvaluation = trafficStatisticService.getTrafficEvaluation(location);
        CommunityEvaluation communityEvaluation = communityStatisticService.getCommunityInfos(location, "3000", "120000");

        dataList.add(trafficEvaluation.getEvaluation());
        dataList.add(competitorEvaluation.getEvaluation());
        dataList.add(cooperatorEvaluation.getEvaluation());
        dataList.add(communityEvaluation.getEvaluation());

        threeDimensionBar.getBarData().setData(dataList);
        threeDimensionBar.setCompetitorEvaluation(competitorEvaluation);
        threeDimensionBar.setCooperatorEvaluation(cooperatorEvaluation);
        threeDimensionBar.setTrafficEvaluation(trafficEvaluation);
        threeDimensionBar.setCommunityEvaluation(communityEvaluation);
        return threeDimensionBar;
    }
}
