package com.otof.tecentmarketing.entity;

import java.util.List;

public class PoiResponseEntity {
    /**
     * status : 1
     * count : 873
     * info : OK
     * infocode : 10000
     * suggestion : {"keywords":[],"cities":[]}
     * pois : [{"id":"B0FFJN8T0Y","parent":"","name":"云水居","type":"商务住宅;商务住宅相关;商务住宅相关","typecode":"120000","biz_type":[],"address":"关山大道328号中杰阳光哈乐城A3幢2层4-5号","location":"114.408928,30.492620","tel":"027-87108986","distance":"18","biz_ext":{"rating":"","cost":""},"pname":"湖北省","cityname":"武汉市","adname":"洪山区","importance":[],"shopid":"","shopinfo":"0","poiweight":[],"photos":[]}]
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
