package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
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

    public SiteSelectionResultEntity getSiteSelectionResult(String location) throws URISyntaxException, InterruptedException {
        SiteSelectionResultEntity siteSelectionResultEntity = new SiteSelectionResultEntity();
        siteSelectionResultEntity.setCompetitorEvaluation(competitorStatisticService.getCompetitorEvaluation(location));
        siteSelectionResultEntity.setCooperatorEvaluation(cooperatorStatisticService.getCooperatorEvaluation(location));
        return siteSelectionResultEntity;
    }
}
