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

    public static class PoisEntity {
        /**
         * id : B0FFJN8T0Y
         * parent :
         * name : 云水居
         * type : 商务住宅;商务住宅相关;商务住宅相关
         * typecode : 120000
         * biz_type : []
         * address : 关山大道328号中杰阳光哈乐城A3幢2层4-5号
         * location : 114.408928,30.492620
         * tel : 027-87108986
         * distance : 18
         * biz_ext : {"rating":"","cost":""}
         * pname : 湖北省
         * cityname : 武汉市
         * adname : 洪山区
         * importance : []
         * shopid :
         * shopinfo : 0
         * poiweight : []
         * photos : []
         */

        private String id;
        private Object parent;
        private String name;
        private String type;
        private String typecode;
        private Object address;
        private String location;
        private Object tel;
        private String distance;
        private BizExtEntity biz_ext;
        private String pname;
        private String cityname;
        private String adname;
        private Object shopid;
        private String shopinfo;
        private Object biz_type;
        private List<?> importance;
        private List<?> poiweight;
        private List<?> photos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getParent() {
            return parent;
        }

        public void setParent(Object parent) {
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypecode() {
            return typecode;
        }

        public void setTypecode(String typecode) {
            this.typecode = typecode;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Object getTel() {
            return tel;
        }

        public void setTel(Object tel) {
            this.tel = tel;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public BizExtEntity getBiz_ext() {
            return biz_ext;
        }

        public void setBiz_ext(BizExtEntity biz_ext) {
            this.biz_ext = biz_ext;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getCityname() {
            return cityname;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }

        public String getAdname() {
            return adname;
        }

        public void setAdname(String adname) {
            this.adname = adname;
        }

        public Object getShopid() {
            return shopid;
        }

        public void setShopid(Object shopid) {
            this.shopid = shopid;
        }

        public String getShopinfo() {
            return shopinfo;
        }

        public void setShopinfo(String shopinfo) {
            this.shopinfo = shopinfo;
        }

        public Object getBiz_type() {
            return biz_type;
        }

        public void setBiz_type(Object biz_type) {
            this.biz_type = biz_type;
        }

        public List<?> getImportance() {
            return importance;
        }

        public void setImportance(List<?> importance) {
            this.importance = importance;
        }

        public List<?> getPoiweight() {
            return poiweight;
        }

        public void setPoiweight(List<?> poiweight) {
            this.poiweight = poiweight;
        }

        public List<?> getPhotos() {
            return photos;
        }

        public void setPhotos(List<?> photos) {
            this.photos = photos;
        }

        public static class BizExtEntity {
            /**
             * rating :
             * cost :
             */

            private Object rating;
            private Object cost;

            public Object getRating() {
                return rating;
            }

            public void setRating(Object rating) {
                this.rating = rating;
            }

            public Object getCost() {
                return cost;
            }

            public void setCost(Object cost) {
                this.cost = cost;
            }
        }
    }
}
