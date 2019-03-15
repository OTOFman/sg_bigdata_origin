package com.otof.tecentmarketing;

import com.otof.tecentmarketing.factories.CrawlerFactory;
import com.otof.tecentmarketing.services.CrawlerInitService;
import com.otof.tecentmarketing.services.JsoupCrawlerService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan("com.otof.tecentmarketing.mapper")
public class Application {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

    @Autowired
    private JsoupCrawlerService jsoupCrawlerService;

    @PostConstruct
    public void startClawer() throws Exception {

        new CrawlerInitService().startCrawl(new CrawlerFactory());
        logger.info("Finish crawl information from home page!");
        jsoupCrawlerService.getCommunityInfo();
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
