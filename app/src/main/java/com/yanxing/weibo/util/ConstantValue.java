package com.yanxing.weibo.util;

import com.facebook.common.util.ByteConstants;

/**
 * Created by lishuangxiang on 2016/11/22.
 */

public class ConstantValue {

    public static final String APP_KEY="1669946568";

    public static final String REDIRECT_URL="https://api.weibo.com/oauth2/default.html";

    public static final String SCOPE = // 应用申请的高级权限
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write," +
                    "statuses_to_me_read";
    /**
     * 一般网页链接
     */
    public static final int URL_TYPE0=0;
    /**
     * 图片链接
     */
    public static final int URL_TYPE1=1;
    /**
     * 视频链接
     */
    public static final int URL_TYPE2=2;






    /*--------------------------------------------------------------fresco配置---------------------------------------------------------*/
    /**
     * 默认图极低磁盘空间缓存的最大值
     */
    public static final int MAX_DISK_CACHE_VERYLOW_SIZE = 10 * ByteConstants.MB;

    /**
     * 默认图低磁盘空间缓存的最大值
     */
    public static final int MAX_DISK_CACHE_LOW_SIZE = 300 * ByteConstants.MB;

    /**
     * 默认图磁盘缓存的最大值
     */
    public static final int MAX_DISK_CACHE_SIZE = 800 * ByteConstants.MB;

    /**
     * 缓存图片文件夹
     */
    public static final String CACHE_IMAGE="timeweibo/image/";

    /**
     * 相机图片文件夹
     */
    public static final String CAMERA="DCIM/Camera/";

    /**
     * 文字缓存文件夹
     */
    public static final String CACHE="timeweibo/cache/";
}
