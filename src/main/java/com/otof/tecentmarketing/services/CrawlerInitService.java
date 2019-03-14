package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.factories.CrawlerFactory;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class CrawlerInitService {

    private static final String CRAWLSTORAGEFOLDER = "src/main/resources/";
    private static final int POLITENESSDELAY = 100;
    private static final int NUMBEROFCRAWLER = 5;
    private static final int MAXSEARCHDEPTH = 0;

    public void startCrawl() throws Exception {
        CrawlConfig crawlConfig = initCrawlConfig();
        CrawlController crawlController = initCrawlController(crawlConfig);
        crawlController.addSeed("https://wuhan.esf.fang.com/housing/__0_0_0_0_1_0_0_0/");
        crawlController.addSeed("https://wuhan.esf.fang.com/housing/__0_0_0_0_2_0_0_0/");
        crawlController.addSeed("https://wuhan.esf.fang.com/housing/__0_0_0_0_3_0_0_0/");
        crawlController.start(new CrawlerFactory(), NUMBEROFCRAWLER);
    }

    private CrawlConfig initCrawlConfig() {
        CrawlConfig config = new CrawlConfig();
        config.setPolitenessDelay(POLITENESSDELAY);
        config.setCrawlStorageFolder(CRAWLSTORAGEFOLDER);
        config.setMaxDepthOfCrawling(MAXSEARCHDEPTH);
        return config;
    }

    private CrawlController initCrawlController(CrawlConfig config) throws Exception {
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        return controller;
    }
}
