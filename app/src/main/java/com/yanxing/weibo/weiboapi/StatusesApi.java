package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <a href="http://t.cn/8F3e7SE">微博接口</a>
 * Created by 李双祥 on 2016/12/23.
 */
public interface StatusesApi {

    /**
     * 获取当前登录用户及其所关注用户的最新微博
     * @param since_id 若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
     * @param max_id   若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
     * @param count    单页返回的记录条数，最大不超过100，默认为20。
     * @param page     返回结果的页码，默认为1。
     * @param base_app 是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
     * @param feature  过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
     * @param trim_user 返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
     * @return
     */
    @GET(ConstantAPI.STATUSES_FRIENDS_TIMELINE)
    Observable<FriendTimeLine> getFriendsTimeline(@Query("since_id") int since_id
            , @Query("max_id") int max_id
            , @Query("count") int count
            , @Query("page") int page
            , @Query("base_app") int base_app
            , @Query("feature") int feature
            , @Query("trim_user") int trim_user);
}
