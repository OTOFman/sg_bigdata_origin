package com.otof.tecentmarketing.controller;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.CommunityStatisticEntity;
import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.services.CommunityInfoService;
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
    private CommunityInfoService communityInfoService;

    @GetMapping(produces = "application/json")
    public Set<CommunityInfoEntity> getCommunitiesInfo(@NotNull @NotBlank @RequestParam String city,
                                                       @NotNull @NotBlank @RequestParam String name) throws URISyntaxException {

        ResponseEntity<GeoCodeResponseEntity> geoCodeEntity = handleMapService.getGeoCodeByName(name,city);
        String location = geoCodeEntity.getBody().getGeocodes().get(0).getLocation();
        return communityInfoService.getCommunityInfos(location, RADIUS, APARTMENTTYPE);
    }

    @GetMapping(path = "/statistics")
    public CommunityStatisticEntity getCommunityStatistic(@NotNull @NotBlank @RequestParam String city,
                                                        @NotNull @NotBlank @RequestParam String name) throws URISyntaxException {
        ResponseEntity<GeoCodeResponseEntity> geoCodeEntity = handleMapService.getGeoCodeByName(name,city);
        String location = geoCodeEntity.getBody().getGeocodes().get(0).getLocation();
        return communityInfoService.getCommunityStatistic(location, RADIUS, APARTMENTTYPE);
    }
}
