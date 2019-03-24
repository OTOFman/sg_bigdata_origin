package com.otof.tecentmarketing;

import com.otof.tecentmarketing.services.CommunityInfoService;
import com.otof.tecentmarketing.services.HandleMapService;
import com.otof.tecentmarketing.services.JsoupCrawlerService;
import com.otof.tecentmarketing.utils.GenerateMeituanSign;
import org.apache.coyote.Request;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private GenerateMeituanSign generateMeituanSign;

//    @PostConstruct
//    public void startClawer() throws Exception {
//
//        new InitCrawlerService().startCrawl(new CrawlerFactory());
//        logger.info("Finish crawl information from home page!");
//        jsoupCrawlerService.getCommunityInfo();
//    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);

//        Map<String, String> param = new HashMap<String, String>(){{
//            put("app_key", "1000055");
//            put("deviceId", "JH-289");
//            put("category", "亲子照");
//            put("timestamp", "2019-03-24 11:30:00");
//            put("format", "json");
//            put("v", "1");
//            put("open_points", "{\"latitude\":114.3,\"longitude\":30.4}");
//            put("radius", "1000");
//            put("sign_method", "MD5");
//            put("page", "1");
//            put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");
//        }};
//
//        String signKey = GenerateMeituanSign.signTopRequest(param, "4e0d1be81540c4d1f0868d329b3229467f071f6c", "MD5");
//        System.out.println(signKey);
    }
}
