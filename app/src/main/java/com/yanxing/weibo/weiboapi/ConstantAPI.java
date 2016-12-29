package com.yanxing.weibo.weiboapi;

/**
 * 微博API常量
 * Created by 李双祥 on 2016/12/23.
 */

public class ConstantAPI {

    /**
     * 微博API基地址
     */
    public static final String API_SERVER = "https://api.weibo.com/2/";

    public static final String ACCESS_TOKEN = "access_token";

    /**
     * 获取当前登录用户及其所关注（授权）用户的最新微博
     */
    public static final String STATUSES_FRIENDS_TIMELINE = "statuses/friends_timeline.json";

    /**
     * 根据地理信息坐标返回实际地址
     */
    public static final String GEO_TO_ADDRESS = "geo_to_address.json";

}
