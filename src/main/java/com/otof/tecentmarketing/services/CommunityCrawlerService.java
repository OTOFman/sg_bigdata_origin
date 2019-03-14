package com.otof.tecentmarketing.services;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CommunityCrawlerService extends WebCrawler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WebCrawlerService.class);
    public static List<String> communitiesUrl;

    public CommunityCrawlerService() {
        communitiesUrl = new ArrayList<>();
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = referringPage.getWebURL().getURL();
        return href.endsWith(".fang.com");
    }

    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();

            Document document = Jsoup.parse(html);
            String communityName = document.select("span.alias").get(0).text();
            String price = document.select("span.prib").text();
            Elements basicInfoElements = document.selectFirst("div.Rinfolist ul").children();
            String buildYear = basicInfoElements.get(0).text();
            String apartmentAmount = basicInfoElements.get(4).text();
            String buildingAmount = basicInfoElements.get(6).text();


            logger.info("the communityName is " + communityName );
            logger.info("the price is " + price );
            logger.info("the buildYear is " + buildYear );
            logger.info("the apartmentAmount is " + apartmentAmount );
            logger.info("the buildingAmount is " + buildingAmount );
        }
    }
}
