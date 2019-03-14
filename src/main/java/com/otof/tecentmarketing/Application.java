package com.otof.tecentmarketing;

import com.otof.tecentmarketing.factories.CrawlCommunityFactory;
import com.otof.tecentmarketing.factories.CrawlerFactory;
import com.otof.tecentmarketing.services.CommunityCrawlerService;
import com.otof.tecentmarketing.services.CrawlerInitService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@SpringBootApplication
@MapperScan("com.otof.tecentmarketing.mapper")
public class Application {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

    @Autowired
    private CrawlerInitService crawlerInitService;
    @Autowired
    private CrawlCommunityFactory crawlCommunityFactory;
    @Autowired
    private CrawlerFactory crawlerFactory;

    @PostConstruct
    public void startClawer() throws Exception {
//        for (int i=1; i<=100; i++) {
//                crawlerInitService.getCrawlController().addSeed("https://wuhan.esf.fang.com/housing/__0_0_0_0_" + Integer.toString(i) + "_0_0_0/");
//        }
//        crawlerInitService.setCrawlerFactory(crawlerFactory);
//        crawlerInitService.startCrawl();
        new CrawlerInitService().startCrawl();
        logger.info("Finish crawl information from home page!");
//        CommunityCrawlerService.communitiesUrl.stream().forEach(
//                v -> {
//                    crawlerInitService.getCrawlController().addSeed(v);
//                    crawlerInitService.setCrawlerFactory(crawlCommunityFactory);
//        });
//        crawlerInitService.startCrawl();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
