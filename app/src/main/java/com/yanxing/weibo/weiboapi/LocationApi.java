package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.GeoToAddress;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 地理信息接口
 * Created by 李双祥 on 2016/12/29.
 */
public interface LocationApi {

    /**
     * 根据地理信息坐标返回实际地址
     * @param path 接口名
     * @param coordinate
     * @return
     */
    @GET(value = ConstantAPI.LOCATION)
    Observable<GeoToAddress>  getGeoToAddress(@Path("path") String path
            ,@Query("coordinate") String coordinate);
}
