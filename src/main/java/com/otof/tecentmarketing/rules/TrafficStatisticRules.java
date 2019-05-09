package com.otof.tecentmarketing.rules;

import com.otof.tecentmarketing.configuration.RuleConfiguration;
import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.evaluation.TrafficEvaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TrafficStatisticRules {

    private final List<String> metroTypeCodes = Stream.of("150500").collect(Collectors.toList());
    private final List<String> busStationTypeCodes = Stream.of("150700", "150701","150702", "150703").collect(Collectors.toList());
    private final List<String> parkingTypeCodes = Stream.of("150904", "150906").collect(Collectors.toList());
    private Map<String, List<PoisEntity>> trafficPoisMap;

    @Autowired
    private RuleConfiguration ruleConfiguration;

    public TrafficEvaluation analysisTraffic(List<PoisEntity> poisEntityList) {
        trafficPoisMap = new HashMap<String, List<PoisEntity>>(){{
            put("metro", new ArrayList<>());
            put("busStation", new ArrayList<>());
            put("parking", new ArrayList<>());
        }};

        initBasicData(poisEntityList);
        return new TrafficEvaluation(
                trafficPoisMap.get("metro").size(),
                trafficPoisMap.get("busStation").size(),
                trafficPoisMap.get("parking").size(),
                evaluateCooperator()
        );
    }

    private void initBasicData(List<PoisEntity> poisEntityList) {
        poisEntityList.stream().forEach(v -> {
            if (metroTypeCodes.contains(v.getTypecode())) {
                trafficPoisMap.get("metro").add(v);
                return;
            }
            if (busStationTypeCodes.contains(v.getTypecode())) {
                trafficPoisMap.get("busStation").add(v);
                return;
            }

            if (parkingTypeCodes.contains(v.getTypecode())) {
                trafficPoisMap.get("parking").add(v);
                return;
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
        if (isNotbad()) {
            return ruleConfiguration.getNotbad();
        }
        return ruleConfiguration.getBadness();
    }

    private boolean isExcellent() {
        return (trafficPoisMap.get("metro").size() > 0 && trafficPoisMap.get("metro").stream().anyMatch(v -> Integer.parseInt(v.getDistance()) <= 500))
                || (trafficPoisMap.get("busStation").size() >= 15 && trafficPoisMap.get("busStation").stream().anyMatch(v -> Integer.parseInt(v.getDistance()) <= 500));
    }

    private boolean isGood() {
        return trafficPoisMap.get("metro").size() > 0 && trafficPoisMap.get("metro").stream().anyMatch(v -> Integer.parseInt(v.getDistance()) > 500)
                || (trafficPoisMap.get("busStation").size() >= 5 && trafficPoisMap.get("busStation").size() < 15 && trafficPoisMap.get("busStation").stream().anyMatch(v -> Integer.parseInt(v.getDistance()) <= 500));
    }

    private boolean isNotbad() {
        return (trafficPoisMap.get("metro").size() > 0 || trafficPoisMap.get("busStation").size() > 0) && trafficPoisMap.get("parking").size() > 0;
    }

    private boolean isBadness() {
        return trafficPoisMap.get("metro").size() == 0 && trafficPoisMap.get("busStation").size() == 0;
    }
}
