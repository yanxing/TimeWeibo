package com.yanxing.weibo.weiboapi.interceptor;

import com.yanxing.weibo.weiboapi.ConstantAPI;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 拦截器，微博接口请求添加固定参数（token）
 * Created by 李双祥 on 2016/12/23.
 */

public class FixedParameterInterceptor implements Interceptor {
    private String mToken;

    /**
     * 请求添加token参数
     * @param token
     */
    public FixedParameterInterceptor(String token){
        mToken=token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        // 添加token
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())
                .addQueryParameter(ConstantAPI.ACCESS_TOKEN, mToken);

        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
