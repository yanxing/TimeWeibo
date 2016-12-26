package com.yanxing.weibo.base;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.util.ConstantValue;
import com.yanxing.weibo.util.FileUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.interceptor.CacheInterceptor;
import com.yanxing.weibo.weiboapi.interceptor.FixedParameterInterceptor;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 单例Retrofit，配置缓存、微博token和服务器地址
 * Created by lishuangxiang on 2016/12/26.
 */
public class RetrofitManage {

    private CacheInterceptor mCacheInterceptor;
    private Cache mCache;

    private RetrofitManage() {
        File file = new File(FileUtil.getStoragePath() + ConstantValue.CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        mCache = new Cache(file, ConstantValue.MAX_DISK_CACHE_VERYLOW_SIZE);
    }

    public static RetrofitManage getInstance() {
        return SingletonHolder.retrofitManage;
    }

    private static class SingletonHolder {
        private static final RetrofitManage retrofitManage = new RetrofitManage();
    }

    /**
     * 初始化Retrofit对象，请求添加token参数和默认缓存策略（无网络读取缓存，有网络不使用缓存）
     *
     * @param context
     * @return
     */
    public Retrofit initRetrofit(Context context) {
        if (mCacheInterceptor == null) {
            mCacheInterceptor = new CacheInterceptor(context, false);
        }
        Oauth2AccessToken oauth2AccessToken = AccessTokenUtil.readAccessToken(context);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new FixedParameterInterceptor(oauth2AccessToken.getToken()))
                .addInterceptor(mCacheInterceptor)
                .cache(mCache)
                .build();

        return new Retrofit.Builder()
                .baseUrl(ConstantAPI.API_SERVER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public void setCacheInterceptor(CacheInterceptor cacheInterceptor) {
        mCacheInterceptor = cacheInterceptor;
    }
}
