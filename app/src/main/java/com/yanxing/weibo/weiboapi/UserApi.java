package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.User;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 用户相关
 * Created by lishuangxiang on 2017/1/10.
 */
public interface UserApi{

    /**
     * 用户相关
     * @return
     */
    @GET(value = ConstantAPI.USER)
    Observable<User> getUserInfo(@Path("path") String path, @QueryMap Map<String, String> map);
}
