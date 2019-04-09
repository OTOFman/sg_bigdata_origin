package com.otof.tecentmarketing.rules;

import com.otof.tecentmarketing.configuration.RuleConfiguration;
import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.evaluation.CooperatorEvaluation;
import com.otof.tecentmarketing.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CooperatorStatisticRules {
    private final int NEARBY = 1000;
    private final int MIDDLEDISTANCE = 2000;

    @Autowired
    private RuleConfiguration ruleConfiguration;
    private int cooperatorAmount;
    private Map<String, List<PoisEntity>> distancePoiMap;

    public CooperatorStatisticRules() {
        distancePoiMap = new HashMap<String, List<PoisEntity>>(){{
            put("nearby", new ArrayList<>());
            put("middleDistance", new ArrayList<>());
            put("faraway", new ArrayList<>());
        }};
    }

    public CooperatorEvaluation analysisCooperators(List<PoisEntity> poisEntityList) {
        initBasicData(poisEntityList);
        return new CooperatorEvaluation(cooperatorAmount, evaluateCooperator());
    }

    private void initBasicData(List<PoisEntity> poisEntityList) {
        cooperatorAmount = poisEntityList.size();
        poisEntityList.stream().forEach( v -> {
            if (Float.parseFloat(v.getDistance()) <= NEARBY) {
                distancePoiMap.get("nearby").add(v);
            }else if (Float.parseFloat(v.getDistance()) <= MIDDLEDISTANCE && Float.parseFloat(v.getDistance()) > NEARBY) {
                distancePoiMap.get("middleDistance").add(v);
            }else {
                distancePoiMap.get("faraway").add(v);
            }
        });
    }

    private int evaluateCooperator() {
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
        return distancePoiMap.get("nearby").size() >= 300 || cooperatorAmount > 800;
    }

    private boolean isGood() {
        return NumberUtil.isBetween(distancePoiMap.get("nearby").size(), 100, 300);
    }

    private boolean isNotBad() {
        return NumberUtil.isBetween(distancePoiMap.get("nearby").size(), 50, 100);
    }
}
