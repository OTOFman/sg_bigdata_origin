package com.otof.tecentmarketing.controller;

import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.entity.display.ThreeDimensionRadar;
import com.otof.tecentmarketing.services.HandleMapService;
import com.otof.tecentmarketing.services.SiteSelectionStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Controller
public class SiteSelectionController {
    @Autowired
    private SiteSelectionStatisticService siteSelectionStatisticService;
    @Autowired
    private HandleMapService handleMapService;

    @RequestMapping(path = "/hello/{name}",method = RequestMethod.GET)
    public String hello(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "site_selection";
    }

    @GetMapping(path = "/site_selection")
    public String getSiteSelectionPage(Model model) {
        model.addAttribute("radar_result", new ThreeDimensionRadar());
        return "site_selection/site_selection_index";
    }

    @GetMapping(path = "/site_selection_radar")
    public String getSiteSelectionRadar(@RequestParam String instituteName, Model model) throws URISyntaxException, InterruptedException {
        List<GeoCodeResponseEntity.GeocodesEntity> geocodesEntityList = handleMapService.getGeoCodeByName(instituteName, "武汉").getBody().getGeocodes();
        if (geocodesEntityList.isEmpty()) {
            return null;
        }
        model.addAttribute("radar_result", siteSelectionStatisticService.getThreeDimensionResult(geocodesEntityList.get(0).getLocation()));
        return "site_selection/site_selection_index";
    }
}
