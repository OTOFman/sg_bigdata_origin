package com.otof.tecentmarketing.entity;

import java.util.List;

public class PoisEntity {
    /**
     * id : B0FFFFNMNH
     * parent : []
     * name : 花园宝贝亲子生活馆
     * type : 生活服务;婴儿服务场所;婴儿游泳馆
     * typecode : 072001
     * biz_type : []
     * address : 关山一路哈乐城A3-103(金地太阳城对面,哈乐城与保利时代之间小路往里200米,保利时代北门)
     * location : 114.408973,30.492614
     * tel : 15327173270
     * distance : 72
     * biz_ext : {"rating":"3.0","cost":[]}
     * pname : 湖北省
     * cityname : 武汉市
     * adname : 洪山区
     * importance : []
     * shopid : []
     * shopinfo : 0
     * poiweight : []
     * photos : [{"url":"http://store.is.autonavi.com/showpic/fab7b4ddbb930e564fd24422a14189cc","title":[],"provider":[]}]
     */

    private String id;
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
    private String shopinfo;
    private Object parent;
    private Object biz_type;
    private Object importance;
    private Object shopid;
    private Object poiweight;
    private List<PhotosEntity> photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getShopinfo() {
        return shopinfo;
    }

    public void setShopinfo(String shopinfo) {
        this.shopinfo = shopinfo;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Object getBiz_type() {
        return biz_type;
    }

    public void setBiz_type(Object biz_type) {
        this.biz_type = biz_type;
    }

    public Object getImportance() {
        return importance;
    }

    public void setImportance(Object importance) {
        this.importance = importance;
    }

    public Object getShopid() {
        return shopid;
    }

    public void setShopid(Object shopid) {
        this.shopid = shopid;
    }

    public Object getPoiweight() {
        return poiweight;
    }

    public void setPoiweight(Object poiweight) {
        this.poiweight = poiweight;
    }

    public List<PhotosEntity> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosEntity> photos) {
        this.photos = photos;
    }

    public static class BizExtEntity {
        /**
         * rating : 3.0
         * cost : []
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

    public static class PhotosEntity {
        /**
         * url : http://store.is.autonavi.com/showpic/fab7b4ddbb930e564fd24422a14189cc
         * title : []
         * provider : []
         */

        private String url;
        private Object title;
        private List<?> provider;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public List<?> getProvider() {
            return provider;
        }

        public void setProvider(List<?> provider) {
            this.provider = provider;
        }
    }
}