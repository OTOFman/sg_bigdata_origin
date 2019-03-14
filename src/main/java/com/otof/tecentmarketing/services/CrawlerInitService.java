package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.factories.CrawlerFactory;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrawlerInitService {

    private static final String CRAWLSTORAGEFOLDER = "src/main/resources/";
    private static final int CRAWLERNUMBER = 7;
    private static final int POLITENESSDELAY = 100;
    private static final int NUMBEROFCRAWLER = 1;
    private static final int MAXSEARCHDEPTH = 0;

    @Autowired
    private CrawlerFactory crawlerFactory;
    private CrawlConfig crawlConfig;
    private CrawlController crawlController;

    public CrawlerInitService() throws Exception {
        this.crawlConfig = initCrawlConfig();
//        this.crawlController = initCrawlController(crawlConfig);
    }

    public void startCrawl() throws Exception {
        CrawlConfig crawlConfig = initCrawlConfig();
        CrawlController crawlController = initCrawlController(crawlConfig);
        crawlController.addSeed("https://de.wikipedia.org/wiki/Java_Database_Connectivity");
//        for (int i=1; i<=100; i++) {
//            crawlController.addSeed("https://wuhan.esf.fang.com/housing/__0_0_0_0_" + Integer.toString(i) + "_0_0_0/");
//        }
//        crawlController.start(crawlerFactory, NUMBEROFCRAWLER);
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

    public CrawlController getCrawlController() {
        return crawlController;
    }

//    public void setCrawlerFactory(CrawlController.WebCrawlerFactory crawlerFactory) {
//        this.crawlerFactory = crawlerFactory;
//    }
}
