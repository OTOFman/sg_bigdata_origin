package com.otof.tecentmarketing;

import com.otof.tecentmarketing.entity.GeoCodeResponseEntity;
import com.otof.tecentmarketing.factories.CrawlerFactory;
import com.otof.tecentmarketing.services.CommunityInfoService;
import com.otof.tecentmarketing.services.HandleMapService;
import com.otof.tecentmarketing.services.JsoupCrawlerService;
import com.otof.tecentmarketing.services.InitCrawlerService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

@SpringBootApplication
@MapperScan("com.otof.tecentmarketing.mapper")
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

//    @PostConstruct
    public void requestGeoInfo() throws URISyntaxException {

//        handleMapService.getGeoCodeByName("锦绣龙城小太阳早教中心","武汉");
//        handleMapService.getCommunitiesByLocation("114.40891,30.492457", "3000","072000");
//        handleMapService.getSurroundInstitutes("114.40891,30.492457", "3000", List.of("早教"));
//        handleMapService.getSurroundInstitutes("114.40891,30.492457", "3000", List.of("幼儿|儿童"));
        ResponseEntity<GeoCodeResponseEntity> geoCodeEntity = handleMapService.getGeoCodeByName("锦绣龙城小太阳早教中心","武汉");
        String location = geoCodeEntity.getBody().getGeocodes().get(0).getLocation();
        communityInfoService.getCommunityInfos(location, "3000", "120000");
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
    }
}
