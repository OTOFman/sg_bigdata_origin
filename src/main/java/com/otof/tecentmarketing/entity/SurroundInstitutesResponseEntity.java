package com.otof.tecentmarketing.entity;

import java.util.List;

public class SurroundInstitutesResponseEntity {
    /**
     * status : 1
     * count : 6
     * info : OK
     * infocode : 10000
     * suggestion : {"keywords":[],"cities":[]}
     * pois : [{"id":"B0FFFFNMNH","parent":[],"name":"花园宝贝亲子生活馆","type":"生活服务;婴儿服务场所;婴儿游泳馆","typecode":"072001","biz_type":[],"address":"关山一路哈乐城A3-103(金地太阳城对面,哈乐城与保利时代之间小路往里200米,保利时代北门)","location":"114.408973,30.492614","tel":"15327173270","distance":"72","biz_ext":{"rating":"3.0","cost":[]},"pname":"湖北省","cityname":"武汉市","adname":"洪山区","importance":[],"shopid":[],"shopinfo":"0","poiweight":[],"photos":[{"url":"http://store.is.autonavi.com/showpic/fab7b4ddbb930e564fd24422a14189cc","title":[],"provider":[]}]}]
     */

    private String status;
    private String count;
    private String info;
    private String infocode;
    private SuggestionEntity suggestion;
    private List<PoisEntity> pois;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public SuggestionEntity getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionEntity suggestion) {
        this.suggestion = suggestion;
    }

    public List<PoisEntity> getPois() {
        return pois;
    }

    public void setPois(List<PoisEntity> pois) {
        this.pois = pois;
    }

    public static class SuggestionEntity {
        private List<?> keywords;
        private List<?> cities;

        public List<?> getKeywords() {
            return keywords;
        }

        public void setKeywords(List<?> keywords) {
            this.keywords = keywords;
        }

        public List<?> getCities() {
            return cities;
        }

        public void setCities(List<?> cities) {
            this.cities = cities;
        }
    }
}
