package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.mapper.CommunityInfoMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsoupCrawlerService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JsoupCrawlerService.class);
    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    private List<CommunityInfoEntity> communities;
    private static int parsedCommunityNumber = 0;
    public static List<String> communitiesUrl = new ArrayList<>();

    public JsoupCrawlerService() {
        this.communities = new ArrayList<>();
    }

    public void getCommunityInfo() {
        communitiesUrl.forEach(v -> {
            try {
                Document document = Jsoup.connect(v).get();

                String buildYear = document.select("li:contains(建筑年代)").size() != 0 ? document.select("li:contains(建筑年代)").get(0).text().replaceAll("[^\\d]+", "") : "";
                String apartmentAmount = document.select("li:contains(房屋总数)").size() != 0 ? document.select("li:contains(房屋总数)").get(0).text().replaceAll("[^\\d]+", "") : "";
                String buildingAmount = document.select("li:contains(楼栋总数)").size() != 0 ? document.select("li:contains(楼栋总数)").get(0).text().replaceAll("[^\\d]+", "") : "";


                String communityName = document.select("div.Rbigbt h1 b").size() !=0 ? document.select("div.Rbigbt h1 b").get(0).text() : "";
                String price = document.select("span.prib").size() !=0 ? document.select("span.prib").text().replaceAll("[^\\d]+", "") : "";

                logger.info("the communityName is " + communityName );
                logger.info("the price is " + price );
                logger.info("the buildYear is " + buildYear );
                logger.info("the apartmentAmount is " + apartmentAmount );
                logger.info("the buildingAmount is " + buildingAmount );
                communities.add(new CommunityInfoEntity(communityName, buildYear, buildingAmount, apartmentAmount, price));
                if (++parsedCommunityNumber == 100) {
                    storeDataToDB();
                    communities.clear();
                    parsedCommunityNumber = 0;
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                logger.warn("The structure of community is uncommon!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (communities.size() != 0) {
            storeDataToDB();
            communities.clear();
            parsedCommunityNumber = 0;
        }
    }

    private void storeDataToDB() {
        if (!communities.isEmpty()) {
            communityInfoMapper.batchInsertCommunityInfo(communities);
        }
        return;
    }
}
