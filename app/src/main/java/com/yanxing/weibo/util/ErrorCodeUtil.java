package com.yanxing.weibo.util;

import android.text.TextUtils;

/**
 * 错误代码
 * Created by lishuangxiang on 2016/11/22.
 */

public class ErrorCodeUtil {

    public static final int SUCCESS_CODE = 200;
    public static final String UNKNOWN_ERROR="未知错误";

    /**
     * 错误代码为SUCCESS_CODE,代表响应成功
     * @param code
     * @return
     */
    public static boolean isErrorSuccess(int code){
        return code==SUCCESS_CODE;
    }

    /**
     * 返回错误代码代表的意思
     *
     * @param code 错误代码
     * @return
     */
    public static String getErrorCodeTip(int code) {
        switch (code) {
            //参数错误
            case 10024:
                return "请求已经超过限制";
            case 20019:
                return "内容重复";
            default:
                return UNKNOWN_ERROR;
        }
    }

}
