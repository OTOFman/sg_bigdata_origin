package com.otof.tecentmarketing.entity;

import java.util.List;

public class BusinessResponseEntity {

    /**
     * code : 200
     * msg : success
     * data : {"records":[{"decoration_grade":68,"regions":["瑞丽市其他"],"distance":0,"city":"瑞丽市","online_reservation_url":"","latitude":24.013454,"taste":6.8,"review_count":1,"avg_price":0,"business_hour":"周一至周日 12:00-22:00","service_grade":68,"province":"云南","avg_rating":3,"branch_name":"","has_hui":0,"has_online_reservation":0,"deal_count":0,"photo_list_url":"http://m.dianping.com/shop/67340325/photos?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=zpym","business_url":"http://m.dianping.com/shop/67340325?from=openplatform&utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=shxq","categories":["茶饮果汁","饮品店","美食"],"decoration":6.8,"popular":0,"introduction":"","longitude":97.85081,"traffic":"","review_list_url":"http://m.dianping.com/shop/67340325/review_all?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=wydp","address":"南卯路与民族街交叉口","telephone":"","has_deal":0,"openshopid":"01t6NXCqqf6bsUEOpz4Aeg","photo_urls":"http://p0.meituan.net/waimaipoi/68db140c1b1df62cacce7e93d5c701dc26624.jpg","photo_count":1,"has_takeaway":0,"product_grade":68,"has_coupon":0,"s_photo_urls":"","service":6.8,"district":"瑞丽市其他","name":"瑞丽茶点子","business_id":67340325,"status":1}],"headlineList":[],"rankingList":[],"page_size":25,"total_number":936,"current_page":6}
     */

    private int code;
    private String msg;
    private DataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * records : [{"decoration_grade":68,"regions":["瑞丽市其他"],"distance":0,"city":"瑞丽市","online_reservation_url":"","latitude":24.013454,"taste":6.8,"review_count":1,"avg_price":0,"business_hour":"周一至周日 12:00-22:00","service_grade":68,"province":"云南","avg_rating":3,"branch_name":"","has_hui":0,"has_online_reservation":0,"deal_count":0,"photo_list_url":"http://m.dianping.com/shop/67340325/photos?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=zpym","business_url":"http://m.dianping.com/shop/67340325?from=openplatform&utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=shxq","categories":["茶饮果汁","饮品店","美食"],"decoration":6.8,"popular":0,"introduction":"","longitude":97.85081,"traffic":"","review_list_url":"http://m.dianping.com/shop/67340325/review_all?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=wydp","address":"南卯路与民族街交叉口","telephone":"","has_deal":0,"openshopid":"01t6NXCqqf6bsUEOpz4Aeg","photo_urls":"http://p0.meituan.net/waimaipoi/68db140c1b1df62cacce7e93d5c701dc26624.jpg","photo_count":1,"has_takeaway":0,"product_grade":68,"has_coupon":0,"s_photo_urls":"","service":6.8,"district":"瑞丽市其他","name":"瑞丽茶点子","business_id":67340325,"status":1}]
         * headlineList : []
         * rankingList : []
         * page_size : 25
         * total_number : 936
         * current_page : 6
         */

        private int page_size;
        private int total_number;
        private int current_page;
        private List<RecordsEntity> records;
        private List<?> headlineList;
        private List<?> rankingList;

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public int getTotal_number() {
            return total_number;
        }

        public void setTotal_number(int total_number) {
            this.total_number = total_number;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public List<RecordsEntity> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsEntity> records) {
            this.records = records;
        }

        public List<?> getHeadlineList() {
            return headlineList;
        }

        public void setHeadlineList(List<?> headlineList) {
            this.headlineList = headlineList;
        }

        public List<?> getRankingList() {
            return rankingList;
        }

        public void setRankingList(List<?> rankingList) {
            this.rankingList = rankingList;
        }

        public static class RecordsEntity {
            /**
             * decoration_grade : 68
             * regions : ["瑞丽市其他"]
             * distance : 0
             * city : 瑞丽市
             * online_reservation_url :
             * latitude : 24.013454
             * taste : 6.8
             * review_count : 1
             * avg_price : 0
             * business_hour : 周一至周日 12:00-22:00
             * service_grade : 68
             * province : 云南
             * avg_rating : 3
             * branch_name :
             * has_hui : 0
             * has_online_reservation : 0
             * deal_count : 0
             * photo_list_url : http://m.dianping.com/shop/67340325/photos?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=zpym
             * business_url : http://m.dianping.com/shop/67340325?from=openplatform&utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=shxq
             * categories : ["茶饮果汁","饮品店","美食"]
             * decoration : 6.8
             * popular : 0
             * introduction :
             * longitude : 97.85081
             * traffic :
             * review_list_url : http://m.dianping.com/shop/67340325/review_all?utm_source=opf&utm_medium=9047286&utm_term=qp&utm_campaign=wydp
             * address : 南卯路与民族街交叉口
             * telephone :
             * has_deal : 0
             * openshopid : 01t6NXCqqf6bsUEOpz4Aeg
             * photo_urls : http://p0.meituan.net/waimaipoi/68db140c1b1df62cacce7e93d5c701dc26624.jpg
             * photo_count : 1
             * has_takeaway : 0
             * product_grade : 68
             * has_coupon : 0
             * s_photo_urls :
             * service : 6.8
             * district : 瑞丽市其他
             * name : 瑞丽茶点子
             * business_id : 67340325
             * status : 1
             */

            private int decoration_grade;
            private int distance;
            private String city;
            private String online_reservation_url;
            private double latitude;
            private double taste;
            private int review_count;
            private int avg_price;
            private String business_hour;
            private int service_grade;
            private String province;
            private int avg_rating;
            private String branch_name;
            private int has_hui;
            private int has_online_reservation;
            private int deal_count;
            private String photo_list_url;
            private String business_url;
            private double decoration;
            private int popular;
            private String introduction;
            private double longitude;
            private String traffic;
            private String review_list_url;
            private String address;
            private String telephone;
            private int has_deal;
            private String openshopid;
            private String photo_urls;
            private int photo_count;
            private int has_takeaway;
            private int product_grade;
            private int has_coupon;
            private String s_photo_urls;
            private double service;
            private String district;
            private String name;
            private int business_id;
            private int status;
            private List<String> regions;
            private List<String> categories;

            public int getDecoration_grade() {
                return decoration_grade;
            }

            public void setDecoration_grade(int decoration_grade) {
                this.decoration_grade = decoration_grade;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getOnline_reservation_url() {
                return online_reservation_url;
            }

            public void setOnline_reservation_url(String online_reservation_url) {
                this.online_reservation_url = online_reservation_url;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getTaste() {
                return taste;
            }

            public void setTaste(double taste) {
                this.taste = taste;
            }

            public int getReview_count() {
                return review_count;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public int getAvg_price() {
                return avg_price;
            }

            public void setAvg_price(int avg_price) {
                this.avg_price = avg_price;
            }

            public String getBusiness_hour() {
                return business_hour;
            }

            public void setBusiness_hour(String business_hour) {
                this.business_hour = business_hour;
            }

            public int getService_grade() {
                return service_grade;
            }

            public void setService_grade(int service_grade) {
                this.service_grade = service_grade;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public int getAvg_rating() {
                return avg_rating;
            }

            public void setAvg_rating(int avg_rating) {
                this.avg_rating = avg_rating;
            }

            public String getBranch_name() {
                return branch_name;
            }

            public void setBranch_name(String branch_name) {
                this.branch_name = branch_name;
            }

            public int getHas_hui() {
                return has_hui;
            }

            public void setHas_hui(int has_hui) {
                this.has_hui = has_hui;
            }

            public int getHas_online_reservation() {
                return has_online_reservation;
            }

            public void setHas_online_reservation(int has_online_reservation) {
                this.has_online_reservation = has_online_reservation;
            }

            public int getDeal_count() {
                return deal_count;
            }

            public void setDeal_count(int deal_count) {
                this.deal_count = deal_count;
            }

            public String getPhoto_list_url() {
                return photo_list_url;
            }

            public void setPhoto_list_url(String photo_list_url) {
                this.photo_list_url = photo_list_url;
            }

            public String getBusiness_url() {
                return business_url;
            }

            public void setBusiness_url(String business_url) {
                this.business_url = business_url;
            }

            public double getDecoration() {
                return decoration;
            }

            public void setDecoration(double decoration) {
                this.decoration = decoration;
            }

            public int getPopular() {
                return popular;
            }

            public void setPopular(int popular) {
                this.popular = popular;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getTraffic() {
                return traffic;
            }

            public void setTraffic(String traffic) {
                this.traffic = traffic;
            }

            public String getReview_list_url() {
                return review_list_url;
            }

            public void setReview_list_url(String review_list_url) {
                this.review_list_url = review_list_url;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public int getHas_deal() {
                return has_deal;
            }

            public void setHas_deal(int has_deal) {
                this.has_deal = has_deal;
            }

            public String getOpenshopid() {
                return openshopid;
            }

            public void setOpenshopid(String openshopid) {
                this.openshopid = openshopid;
            }

            public String getPhoto_urls() {
                return photo_urls;
            }

            public void setPhoto_urls(String photo_urls) {
                this.photo_urls = photo_urls;
            }

            public int getPhoto_count() {
                return photo_count;
            }

            public void setPhoto_count(int photo_count) {
                this.photo_count = photo_count;
            }

            public int getHas_takeaway() {
                return has_takeaway;
            }

            public void setHas_takeaway(int has_takeaway) {
                this.has_takeaway = has_takeaway;
            }

            public int getProduct_grade() {
                return product_grade;
            }

            public void setProduct_grade(int product_grade) {
                this.product_grade = product_grade;
            }

            public int getHas_coupon() {
                return has_coupon;
            }

            public void setHas_coupon(int has_coupon) {
                this.has_coupon = has_coupon;
            }

            public String getS_photo_urls() {
                return s_photo_urls;
            }

            public void setS_photo_urls(String s_photo_urls) {
                this.s_photo_urls = s_photo_urls;
            }

            public double getService() {
                return service;
            }

            public void setService(double service) {
                this.service = service;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getBusiness_id() {
                return business_id;
            }

            public void setBusiness_id(int business_id) {
                this.business_id = business_id;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<String> getRegions() {
                return regions;
            }

            public void setRegions(List<String> regions) {
                this.regions = regions;
            }

            public List<String> getCategories() {
                return categories;
            }

            public void setCategories(List<String> categories) {
                this.categories = categories;
            }
        }
    }
}
