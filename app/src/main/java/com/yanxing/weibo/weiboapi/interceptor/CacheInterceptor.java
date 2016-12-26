package com.yanxing.weibo.weiboapi.interceptor;

import android.content.Context;

import com.yanxing.weibo.util.NetworkStateUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 本应用的缓存策略，无网络时使用缓存，有网络时根据mUseCache决定使用缓存数据还是使用网络数据
 * Created by lishuangxiang on 2016/11/25.
 */
public class CacheInterceptor implements okhttp3.Interceptor {

    private Context mContext;
    private boolean mUseCache;

    /**
     * useCache为true时使用缓存数据，false不使用缓存数据，无网络情况下无效
     * @param context
     * @param useCache
     */
    public CacheInterceptor(Context context, boolean useCache) {
        this.mContext = context;
        this.mUseCache=useCache;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response;
        //无网络，超时时间为1周
        if (!NetworkStateUtil.isNetworkConnected(mContext)) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            response = chain.proceed(request);
            int maxStale = 60 * 60 * 24 * 7;
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
        } else {
            // 有网络时
            String cacheControl;
            //使用缓存
            if (mUseCache){
                //使用缓存，参数和无网络参数一样
                int maxStale = 60 * 60 * 24 * 7;
                cacheControl="public, only-if-cached, max-stale=" + maxStale;
            }else {
                cacheControl="public,no-cache";
            }
            response = chain.proceed(request);
            response.newBuilder()
                    .header("Cache-Control",cacheControl)
                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        }
        return response;
    }
}
