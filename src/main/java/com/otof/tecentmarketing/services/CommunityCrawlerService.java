package com.otof.tecentmarketing.services;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class CommunityCrawlerService extends WebCrawler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WebCrawlerService.class);
    public static List<String> communitiesUrl = new ArrayList<>();

    public CommunityCrawlerService() {

    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = referringPage.getWebURL().getURL();
        return href.contains(".fang.com");
    }

    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();

            Document document = Jsoup.parse(html);

            try {
                String price = new String(document.select("span.prib").text().getBytes("UTF-8"), "GB2312");
                Elements basicInfoElements = document.selectFirst("div.Rinfolist ul").children();
                String buildYear =new String(basicInfoElements.get(0).text().getBytes("UTF-8"), "GB2312") ;
                String apartmentAmount = basicInfoElements.get(4).text();
                String buildingAmount = basicInfoElements.get(6).text();
//                String communityName = document.select("Rbigbt h1 b").get(0).text();



//                logger.info("the communityName is " + communityName );
                logger.info("the price is " + price );
                logger.info("the buildYear is " + buildYear );
                logger.info("the apartmentAmount is " + apartmentAmount );
                logger.info("the buildingAmount is " + buildingAmount );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }
}
