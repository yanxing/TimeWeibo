package com.yanxing.weibo.weiboapi.model;

import java.util.List;

/**
 * Created by 李双祥 on 2016/12/29.
 */
public class GeoToAddress {


    private List<GeosBean> geos;

    public List<GeosBean> getGeos() {
        return geos;
    }

    public void setGeos(List<GeosBean> geos) {
        this.geos = geos;
    }

    public static class GeosBean {
        /**
         * longitude : 121.49860864
         * latitude : 31.117314637
         * city : 0021
         * province : 31
         * city_name : 上海市
         * province_name : 上海
         * district_name : 闵行区
         * address : 上海上海市闵行区
         */

        private String longitude;
        private String latitude;
        private String city;
        private String province;
        private String city_name;
        private String province_name;
        private String district_name;
        private String address;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
