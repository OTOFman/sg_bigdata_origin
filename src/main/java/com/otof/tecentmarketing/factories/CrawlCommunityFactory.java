package com.otof.tecentmarketing.factories;

import com.otof.tecentmarketing.services.CommunityCrawlerService;
import edu.uci.ics.crawler4j.crawler.CrawlController;

public class CrawlCommunityFactory implements CrawlController.WebCrawlerFactory {

    private CommunityCrawlerService communityCrawlerService = new CommunityCrawlerService();

    public CommunityCrawlerService newInstance() throws Exception {
        return communityCrawlerService;
    }
}
