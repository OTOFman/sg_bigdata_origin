package com.otof.tecentmarketing.services;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerInitService {

    private static final String CRAWLSTORAGEFIRSTFOLDER = "src/main/resources/crawler_first";
    private static final String CRAWLSTORAGESECONDFOLDER = "src/main/resources/crawler_second";
    private static final int POLITENESSDELAY = 100;
    private static final int NUMBEROFCRAWLER = 5;
    private static final int MAXSEARCHDEPTH = 0;
    private static final String SEEDPREFIX = "https://wuhan.esf.fang.com/housing/__0_0_0_0_";
    private static final String SEEDSUFFIX = "_0_0_0";

    public void startCrawl(CrawlController.WebCrawlerFactory webCrawlerFactory) throws Exception {
        CrawlConfig crawlConfig = initCrawlConfig();

        CrawlController crawlController = buildHomepageController(crawlConfig);

        crawlController.start(webCrawlerFactory, NUMBEROFCRAWLER);
    }

    private CrawlController buildHomepageController(CrawlConfig crawlConfig) throws Exception {
        crawlConfig.setCrawlStorageFolder(CRAWLSTORAGEFIRSTFOLDER);
        CrawlController crawlController = initCrawlController(crawlConfig);
        return buildHomepageSeeds(crawlController);

    }

    private CrawlConfig initCrawlConfig() {
        CrawlConfig config = new CrawlConfig();
        config.setPolitenessDelay(POLITENESSDELAY);
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

    private CrawlController buildHomepageSeeds(CrawlController crawlController) {
        for (int i = 1; i<=100; i++) {
            crawlController.addSeed(SEEDPREFIX + Integer.toString(i) + SEEDSUFFIX);
        }
        return crawlController;
    }

}
