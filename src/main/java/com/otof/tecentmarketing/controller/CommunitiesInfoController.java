package com.otof.tecentmarketing.controller;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.evaluation.CommunityEvaluation;
import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.services.CommunityStatisticService;
import com.otof.tecentmarketing.services.HandleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping("communitiesInfo")
public class CommunitiesInfoController {

    private final String RADIUS = "3000";
    private final String APARTMENTTYPE = "120000";

    @Autowired
    private HandleMapService handleMapService;
    @Autowired
    private CommunityStatisticService communityStatisticService;

    @GetMapping(produces = "application/json")
    public CommunityEvaluation getCommunitiesInfo(@NotNull @NotBlank @RequestParam String city,
                                                       @NotNull @NotBlank @RequestParam String name) throws URISyntaxException, InterruptedException {

        ResponseEntity<GeoCodeResponseEntity> geoCodeEntity = handleMapService.getGeoCodeByName(name,city);
        if (geoCodeEntity.getBody().getGeocodes().size() != 0) {
            String location = geoCodeEntity.getBody().getGeocodes().get(0).getLocation();
            return communityStatisticService.getCommunityInfos(location, RADIUS, APARTMENTTYPE);
        }
        return null;
    }

    @GetMapping(path = "/statistics")
    public CommunityEvaluation getCommunityStatistic(@NotNull @NotBlank @RequestParam String city,
                                                     @NotNull @NotBlank @RequestParam String name) throws URISyntaxException, InterruptedException {
        ResponseEntity<GeoCodeResponseEntity> geoCodeEntity = handleMapService.getGeoCodeByName(name,city);
        String location = geoCodeEntity.getBody().getGeocodes().get(0).getLocation();
        return communityStatisticService.getCommunityStatistic(location, RADIUS, APARTMENTTYPE);
    }
}
