package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.Following;

import retrofit2.http.Query;
import rx.Observable;

/**
 * 关系相关
 * Created by lishuangxiang on 2017/2/13.
 */
public interface FriendshipsApi {

    /**
     * 获取用户的关注列表
     * @param uid 需要查询的用户UID
     * @param count 单页返回的记录条数，默认为50，最大不超过200。
     * @param cursor 返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0。
     * @param trim_status 返回值中user字段中的status字段开关，0：返回完整status字段、1：status字段仅返回status_id，默认为1。
     * @return
     */
    Observable<Following> getFollowing(@Query("uid") String uid, @Query("count") int count, @Query("cursor") int cursor
                            , @Query("trim_status") int trim_status);

}
