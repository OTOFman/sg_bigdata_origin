package com.otof.tecentmarketing.factories;

import com.otof.tecentmarketing.services.CommunityCrawlerService;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CrawlCommunityFactory implements CrawlController.WebCrawlerFactory {

    @Autowired
    private CommunityCrawlerService communityCrawlerService;

    public CommunityCrawlerService newInstance() throws Exception {
        return communityCrawlerService;
    }
}
