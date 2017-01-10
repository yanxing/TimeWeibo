package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.User;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 用户相关
 * Created by lishuangxiang on 2017/1/10.
 */
public interface UserApi{

    /**
     * 根据用户ID获取用户信息
     * @param uid 需要查询的用户ID
     * @return
     */
    @POST(value = ConstantAPI.USER)
    Observable<User> getUserInfo(@Query("uid") String uid);
}
