package com.otof.tecentmarketing.controller;

import com.otof.tecentmarketing.configuration.MapConfiguration;
import com.otof.tecentmarketing.entity.BusinessResponseEntity;
import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.entity.SiteSelectionResultEntity;
import com.otof.tecentmarketing.services.HandleBusinessService;
import com.otof.tecentmarketing.services.HandleMapService;
import com.otof.tecentmarketing.services.SiteSelectionStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("businessInfo")
public class BusinessInfoController {

    @Autowired
    private HandleMapService handleMapService;
    @Autowired
    private HandleBusinessService handleBusinessService;
    @Autowired
    private SiteSelectionStatisticService siteSelectionStatisticService;

    @GetMapping(path = "/surrounding")
    public ResponseEntity<BusinessResponseEntity> getSurroundBusiness(@RequestParam String instituteName,
                                                                      @RequestParam String city,
                                                                      @RequestParam int radius,
                                                                      @RequestParam int page) throws URISyntaxException, IOException, NoSuchAlgorithmException {
        List<GeoCodeResponseEntity.GeocodesEntity> geocodesEntityList = handleMapService.getGeoCodeByName(instituteName, city).getBody().getGeocodes();
        if (geocodesEntityList.isEmpty()) {
            return new ResponseEntity("Cannot find business", HttpStatus.OK);
        }
        String location = geocodesEntityList.get(0).getLocation();

        float latitude = getLatitudeFromLocation(location);
        float longitude = getLongitudeFromLocation(location);
        return handleBusinessService.getSurroundBusiness(latitude, longitude, radius, page);
    }

    @GetMapping(path = "/site_selection_statistic")
    public ResponseEntity<SiteSelectionResultEntity> getSiteSelectionResult(@RequestParam String location) throws URISyntaxException, InterruptedException {
        return new ResponseEntity<>(siteSelectionStatisticService.getSiteSelectionResult(location), HttpStatus.OK);
    }

    private float getLatitudeFromLocation(String location) {
        return Float.parseFloat(location.substring(0, location.indexOf(',')));
    }

    private float getLongitudeFromLocation(String location) {
        return Float.parseFloat(location.substring(location.indexOf(',') + 1));
    }
}
