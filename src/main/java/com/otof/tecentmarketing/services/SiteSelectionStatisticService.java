package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
import com.otof.tecentmarketing.entity.display.ThreeDimensionRadar;
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
        dataList.add(competitorStatisticService.getCompetitorEvaluation(location).getEvaluation());
        dataList.add(cooperatorStatisticService.getCooperatorEvaluation(location).getEvaluation());
        dataList.add(trafficStatisticService.getTrafficEvaluation(location).getEvaluation());
        threeDimensionRadar.setData(dataList);
        threeDimensionRadar.setLabel("交通-竞业-异业评估");
        return threeDimensionRadar;
    }
}
