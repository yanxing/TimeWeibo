package com.yanxing.weibo.auth;

import com.sina.weibo.sdk.exception.WeiboException;

/**
 * Created by lishuangxiang on 2016/12/23.
 */
public interface WeiboView {

    /**
     * 授权信息
     * @param code 授权结果码 -1代表成功，0取消，1异常
     * @param e 可能为null
     */
   void setAuth(int code, WeiboException e);
}
