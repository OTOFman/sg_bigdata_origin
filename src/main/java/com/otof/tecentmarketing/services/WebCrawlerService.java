package com.otof.tecentmarketing.services;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;

import java.util.Set;
import java.util.regex.Pattern;

public class WebCrawlerService extends WebCrawler {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(WebCrawlerService.class);

    private static Pattern FILE_ENDING_EXCLUSION_PATTERN = Pattern.compile(".*(\\.(" +
            "css|js" +
            "|bmp|gif|jpe?g|JPE?G|png|tiff?|ico|nef|raw" +
            "|mid|mp2|mp3|mp4|wav|wma|flv|mpe?g" +
            "|avi|mov|mpeg|ram|m4v|wmv|rm|smil" +
            "|pdf|doc|docx|pub|xls|xlsx|vsd|ppt|pptx" +
            "|swf" +
            "|zip|rar|gz|bz2|7z|bin" +
            "|xml|txt|java|c|cpp|exe" +
            "))$");

    public WebCrawlerService() {
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = referringPage.getWebURL().getURL().toLowerCase();
        logger.info("url is " + href + " and " + (!FILE_ENDING_EXCLUSION_PATTERN.matcher(href).matches() || href.endsWith(".fang.com")));

        return !FILE_ENDING_EXCLUSION_PATTERN.matcher(href).matches() || href.endsWith(".fang.com");
    }

    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            Document document = Jsoup.parse(html);
            Elements communities = document.select("a.plotTit");
            communities.stream().filter( v -> v.attr("href").contains("fang.com"))
                    .forEach( v -> JsoupCrawlerService.communitiesUrl.add("https:" + v.attr("href")));
        }
    }
}
