package com.yanxing.weibo.common;

/**
 * Created by lishuangxiang on 2017/2/10.
 */
public enum  WeiboOperate {

    /**
     * 发微博
     */
    SEND_WEIBO(0),
    /**
     * 发评论
     */
    COMMENT(1),
    /**
     * 转发微博
     */
    FORWARD_WEIBO(2);


    private int mIntValue;

    WeiboOperate(int stateInt) {
        mIntValue = stateInt;
    }

    public int getIntValue() {
        return mIntValue;
    }
}
