package com.otof.tecentmarketing.rules;

import com.otof.tecentmarketing.configuration.RuleConfiguration;
import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.evaluation.CompetitorEvaluation;
import com.otof.tecentmarketing.enums.StarInstitutesEnum;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Component
public class CompetitorStatisticRules {

    private final int STARTHREASHHOLD = 6;
    private final int COMMONTHREASHHOLD = 40;
    private final int ONEKILOMETER = 1000;
    @Autowired
    private RuleConfiguration ruleConfiguration;
    private int competitorAmount;
    private int starCompetitorAmount;
    private int competitorAmountWithOneKm;

    public CompetitorEvaluation analysisCompetitors(List<PoisEntity> poisEntityList) {
        initBasicData(poisEntityList);
        return new CompetitorEvaluation(competitorAmount, starCompetitorAmount, evaluateCompetitor(poisEntityList));
    }

    private void initBasicData(List<PoisEntity> poisEntityList) {
        competitorAmount = poisEntityList.size();
        starCompetitorAmount = getStarInstituteAmount(poisEntityList);
    }

    private int evaluateCompetitor(List<PoisEntity> poisEntityList) {
        competitorAmountWithOneKm = 0;

        if (starCompetitorAmount >= STARTHREASHHOLD || competitorAmount >= COMMONTHREASHHOLD) {
            return ruleConfiguration.getBadness();
        }

        if (competitorAmount == 0) {
            return ruleConfiguration.getExcellent();
        }

        if (poisEntityList.stream().anyMatch(v-> isStarCompetitorInOneKm(v) || isAtLeastTwoMoreCompetitorInOneKm(v))) {
            return ruleConfiguration.getNotbad();
        }

        return ruleConfiguration.getGood();
    }

    private boolean isStarInstitute(String name) {
        return Arrays.stream(StarInstitutesEnum.values()).anyMatch(v -> name.contains(v.getName()));
    }

    private int getStarInstituteAmount(List<PoisEntity> poisEntityList) {
        List starInstituteList = poisEntityList.stream()
                .filter(v -> isStarInstitute(v.getName()))
                .collect(Collectors.toList());
        return starInstituteList.size();
    }

    private boolean isStarCompetitorInOneKm(PoisEntity poisEntity) {
        if (Arrays.stream(StarInstitutesEnum.values()).anyMatch( v -> poisEntity.getName().contains(v.toString()))) {
            return Integer.parseInt(poisEntity.getDistance()) <= ONEKILOMETER;
        }
        return false;
    }

    private boolean isAtLeastTwoMoreCompetitorInOneKm(PoisEntity poisEntity) {
        if (Integer.parseInt(poisEntity.getDistance()) <= ONEKILOMETER) {
            return ++competitorAmountWithOneKm > 2 ? true : false;
        }
        return false;
    }
}
