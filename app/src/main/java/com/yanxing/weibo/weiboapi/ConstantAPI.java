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
     * 获取某个（授权）用户最新发表的微博列表
     */
    public static final String STATUSES_USERS_TIMELINE = "statuses/user_timeline.json";

    /**
     * 根据地理信息坐标返回实际地址
     */
    public static final String GEO_TO_ADDRESS = "geo_to_address.json";
    /**
     * 获取某条微博的评论列表
     */
    public static final String COMMENTS="comments/show.json";
    /**
     * 地理信息
     */
    public static final String LOCATION="location/geo/{path}";
    /**
     * 用户相关
     */
    public static final String USER="users/{path}";
    /**
     * 根据用户ID获取用户信息
     */
    public static final String SHOW="show.json";
    /**
     * 评论相关
     */
    public static final String COMMENT="comments/{path}";
    /**
     * 我收到的评论列表
     */
    public static final String COMMENT_TO_ME="to_me.json";
    /**
     * @ 用户时的联想建议
     */
    public static final String AT_USERS="search/suggestions/at_users.json";
    /**
     * 获取用户的关注列表
     */
    public static final String FRIENDS="friendships/friends.json";
    /**
     * 对一条微博评论
     */
    public static final String CREATE_COMMENT="comments/create.json";
    /**
     * 转发一条微博
     */
    public static final String STATUSES_REPOST="statuses/repost.json";
    /**
     * 发一条微博
     */
    public static final String STATUSES_UPDATE="statuses/update.json";
    /**
     * 根据ID跳转到单条微博页
     */
    public static final String STATUSES_GO="statuses/go";





    /**
     * 缩略图图片 http://ww1.sinaimg.cn/thumbnail/8c9ef2e9gw1fbcz48b05gj20u00u0dk2.jpg
     */
    public static final String THUMBNAIL_PIC="thumbnail";
    /**
     * 中等图片 http://ww1.sinaimg.cn/thumbnail/8c9ef2e9gw1fbcz48b05gj20u00u0dk2.jpg
     * 替换thumbnail获取的则为中等图片
     */
    public static final String BMIDDLE_PIC="bmiddle";
    /**
     * 原图 http://ww1.sinaimg.cn/thumbnail/8c9ef2e9gw1fbcz48b05gj20u00u0dk2.jpg
     * 替换thumbnail获取的则为原图
     */
    public static final String ORIGINAL_PIC="large";

}
