package com.otof.tecentmarketing.controller;

import com.otof.tecentmarketing.services.SiteSelectionStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@Controller
public class SiteSelectionController {
    @Autowired
    private SiteSelectionStatisticService siteSelectionStatisticService;

    @RequestMapping(path = "/hello/{name}",method = RequestMethod.GET)
    public String hello(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "site_selection";
    }

    @GetMapping(path = "/site_selection")
    public String getSiteSelectionRadar(@RequestParam String location, Model model) throws URISyntaxException, InterruptedException {
        model.addAttribute("radar_result", siteSelectionStatisticService.getThreeDimensionResult(location));
        return "site_selection";
    }
}
