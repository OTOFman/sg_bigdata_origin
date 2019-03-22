package com.otof.tecentmarketing;

import com.otof.tecentmarketing.services.CommunityInfoService;
import com.otof.tecentmarketing.services.HandleMapService;
import com.otof.tecentmarketing.services.JsoupCrawlerService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.otof.tecentmarketing.mapper")
@EnableAsync
public class Application {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

    @Autowired
    private JsoupCrawlerService jsoupCrawlerService;
    @Autowired
    private HandleMapService handleMapService;
    @Autowired
    private CommunityInfoService communityInfoService;

//    @PostConstruct
//    public void startClawer() throws Exception {
//
//        new InitCrawlerService().startCrawl(new CrawlerFactory());
//        logger.info("Finish crawl information from home page!");
//        jsoupCrawlerService.getCommunityInfo();
//    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
