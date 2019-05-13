package com.otof.tecentmarketing.rules;

import com.otof.tecentmarketing.configuration.RuleConfiguration;
import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.evaluation.CommunityEvaluation;
import com.otof.tecentmarketing.utils.NumberUtil;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

@Component
@NoArgsConstructor
public class CommunityStatisticRules {

    private double totalOfPrice;
    private double totalOfYear;
    private CommunityEvaluation communityEvaluation;
    private final double AVGCHILDRENPERFAMILY = 0.8 * 1.2;
    private final int THISYEAR = 1900 + new Date().getYear();
    private final int FIVEYEARAGO = THISYEAR - 5;

    @Autowired
    private RuleConfiguration ruleConfiguration;

    public CommunityEvaluation analysisCommunities(Set<CommunityInfoEntity> communityInfoEntitySet) {
        communityEvaluation = new CommunityEvaluation();
        totalOfPrice = 0;
        totalOfYear = 0;

        communityInfoEntitySet.stream().forEach( v -> {
            communityEvaluation.setApartmentAmount( communityEvaluation.getApartmentAmount() + v.getApartmentAmount());
            communityEvaluation.setBuildingAmount( communityEvaluation.getBuildingAmount() + v.getBuildingAmount());
            totalOfPrice += v.getPrice() * v.getApartmentAmount();
            totalOfYear += Double.parseDouble("".equals(v.getBuildYear()) ? "0" : v.getBuildYear()) * v.getApartmentAmount();
        });

        communityEvaluation.setAvgPrice( getAveragePrice() );
        communityEvaluation.setAvgBuildYear( getAverageBuildYear() );
        communityEvaluation.setChildrenAmount( communityEvaluation.getApartmentAmount() * AVGCHILDRENPERFAMILY);
        communityEvaluation.setEvaluation(evaluateCommunity());
        return communityEvaluation;
    }

    private double getAveragePrice() {
        double avgPrice = totalOfPrice / communityEvaluation.getApartmentAmount();
        BigDecimal bd=new BigDecimal(avgPrice);

        return bd.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private String getAverageBuildYear() {
        double avgYear = totalOfYear / communityEvaluation.getApartmentAmount();
        return new DecimalFormat("#").format(avgYear);
    }

    private int evaluateCommunity() {
        if (isExcellent()) {
            return ruleConfiguration.getExcellent();
        }

        if (isGood()) {
            return ruleConfiguration.getGood();
        }

        if (isNotBad()) {
            return ruleConfiguration.getNotbad();
        }

        return ruleConfiguration.getBadness();
    }

    private boolean isExcellent() {
        return NumberUtil.isBetween(getAveragePrice(), 20000, 1000000)
                && NumberUtil.isBetween(Double.parseDouble(getAverageBuildYear()), FIVEYEARAGO, THISYEAR)
                && communityEvaluation.getChildrenAmount() >= 40000;
    }

    private boolean isGood() {
        return NumberUtil.isBetween(getAveragePrice(), 20000, 1000000)
                || NumberUtil.isBetween(Double.parseDouble(getAverageBuildYear()), FIVEYEARAGO, THISYEAR)
                || communityEvaluation.getChildrenAmount() >= 30000;
    }

    private boolean isNotBad() {
        int tenYearAgo = THISYEAR - 10;
        return NumberUtil.isBetweenMaxExclude(Double.parseDouble(getAverageBuildYear()), tenYearAgo, FIVEYEARAGO)
                && NumberUtil.isBetweenMaxExclude(getAveragePrice(), 10000, 20000)
                && NumberUtil.isBetweenMaxExclude(communityEvaluation.getChildrenAmount(), 0, 20000);
    }

}
