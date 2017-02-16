package com.yanxing.weibo.weiboapi;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 搜索联想
 * Created by lishuangxiang on 2017/2/13.
 */
public interface SearchApi {

    /**
     * @用户时联想建议
     * @param q       搜索的关键字，必须做URLencoding
     * @param count   返回的记录条数，默认为10，粉丝最多1000，关注最多2000
     * @param type    联想类型，0：关注、1：粉丝
     * @param range   联想范围，0：只联想关注人、1：只联想关注人的备注、2：全部，默认为2。
     * @return
     */
    @GET(value = ConstantAPI.AT_USERS)
    Observable getAtUsers(@Query("q") String q,@Query("count") int count,@Query("type") int type
            ,@Query("range") int range);
}
