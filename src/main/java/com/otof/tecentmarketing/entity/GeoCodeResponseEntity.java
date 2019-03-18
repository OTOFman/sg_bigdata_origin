package com.otof.tecentmarketing.entity;

import java.util.List;

public class GeoCodeResponseEntity {

    /**
     * status : 1
     * info : OK
     * infocode : 10000
     * count : 1
     * geocodes : [{"formatted_address":"北京市朝阳区方恒国际中心|A座","country":"中国","province":"北京市","citycode":"010","city":"北京市","district":"朝阳区","township":[],"neighborhood":{"name":[],"type":[]},"building":{"name":[],"type":[]},"adcode":"110105","street":[],"number":[],"location":"116.480656,39.989677","level":"门牌号"}]
     */

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<GeocodesEntity> geocodes;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<GeocodesEntity> getGeocodes() {
        return geocodes;
    }

    public void setGeocodes(List<GeocodesEntity> geocodes) {
        this.geocodes = geocodes;
    }

    public static class GeocodesEntity {
        /**
         * formatted_address : 北京市朝阳区方恒国际中心|A座
         * country : 中国
         * province : 北京市
         * citycode : 010
         * city : 北京市
         * district : 朝阳区
         * township : []
         * neighborhood : {"name":[],"type":[]}
         * building : {"name":[],"type":[]}
         * adcode : 110105
         * street : []
         * number : []
         * location : 116.480656,39.989677
         * level : 门牌号
         */

        private String formatted_address;
        private String country;
        private String province;
        private String citycode;
        private String city;
        private String district;
        private NeighborhoodEntity neighborhood;
        private BuildingEntity building;
        private String adcode;
        private String location;
        private String level;
        private List<?> township;
        private List<?> street;
        private List<?> number;

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCitycode() {
            return citycode;
        }

        public void setCitycode(String citycode) {
            this.citycode = citycode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public NeighborhoodEntity getNeighborhood() {
            return neighborhood;
        }

        public void setNeighborhood(NeighborhoodEntity neighborhood) {
            this.neighborhood = neighborhood;
        }

        public BuildingEntity getBuilding() {
            return building;
        }

        public void setBuilding(BuildingEntity building) {
            this.building = building;
        }

        public String getAdcode() {
            return adcode;
        }

        public void setAdcode(String adcode) {
            this.adcode = adcode;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public List<?> getTownship() {
            return township;
        }

        public void setTownship(List<?> township) {
            this.township = township;
        }

        public List<?> getStreet() {
            return street;
        }

        public void setStreet(List<?> street) {
            this.street = street;
        }

        public List<?> getNumber() {
            return number;
        }

        public void setNumber(List<?> number) {
            this.number = number;
        }

        public static class NeighborhoodEntity {
            private List<?> name;
            private List<?> type;

            public List<?> getName() {
                return name;
            }

            public void setName(List<?> name) {
                this.name = name;
            }

            public List<?> getType() {
                return type;
            }

            public void setType(List<?> type) {
                this.type = type;
            }
        }

        public static class BuildingEntity {
            private List<?> name;
            private List<?> type;

            public List<?> getName() {
                return name;
            }

            public void setName(List<?> name) {
                this.name = name;
            }

            public List<?> getType() {
                return type;
            }

            public void setType(List<?> type) {
                this.type = type;
            }
        }
    }
}
