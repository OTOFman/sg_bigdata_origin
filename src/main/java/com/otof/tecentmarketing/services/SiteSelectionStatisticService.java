package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
import com.otof.tecentmarketing.rules.TrafficStatisticRules;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

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
}
