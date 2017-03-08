package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.StatusRepost;
import com.yanxing.weibo.weiboapi.model.StatusesUpdate;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
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

    /**
     * 获取某个用户最新发表的微博列表，接口升级后：uid与screen_name只能为当前授权用户；
     * @param uid 需要查询的用户ID
     * @param screenName 需要查询的用户昵称,参数uid与screen_name二者必选其一，且只能选其一
     * @param since_id 若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
     * @param max_id   若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
     * @param count    单页返回的记录条数，最大不超过100，默认为20。
     * @param page     返回结果的页码，默认为1。
     * @param base_app 是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
     * @param feature  过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
     * @param trim_user 返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
     * @return
     */
    @GET(ConstantAPI.STATUSES_USERS_TIMELINE)
    Observable<FriendTimeLine> getUserTimeline(@QueryMap Map<String,String> map);

    /**
     * 转发一条微博 必须post方法
     * @param id        要转发的微博ID
     * @param content   添加的转发文本，必须做URLencode，内容不超过140个汉字，不填则默认为“转发微博”
     * @param isComment 是否在转发的同时发表评论，0：否、1：评论给当前微博、2：评论给原微博、3：都评论，默认为0 。
     * @param rip       开发者上报的操作用户真实IP，形如：211.156.0.1。
     * @return
     */
    @FormUrlEncoded
    @POST(ConstantAPI.STATUSES_REPOST)
    Observable<StatusRepost> repostWeibo(@Field("id") long id, @Field(value = "status" ,encoded = true) String content
            ,@Field("is_comment") int isComment);

    /**
     * 发微博，不带图片 post
     * @param content 要发布的微博文本内容，必须做URLencode，内容不超过140个汉字。
     * @param visible 微博的可见性，0：所有人能看，1：仅自己可见，2：密友可见，3：指定分组可见，默认为0。
     * @param list_id 微博的保护投递指定分组ID，只有当visible参数为3时生效且必选。
     * @param lat     纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
     * @param longitude 经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
     * @param annotations 元数据，主要是为了方便第三方应用记录一些适合于自己使用的信息，每条微博可以包含一个或者多个元数据，必须以json字串的形式提交，字串长度不超过512个字符，具体内容可以自定。
     * @param rip       开发者上报的操作用户真实IP，形如：211.156.0.1。
     * @return
     */
    @FormUrlEncoded
    @POST(ConstantAPI.STATUSES_UPDATE)
    Observable<StatusesUpdate> sendWeibo(@Field(value = "status" ,encoded = true) String content,@Field("visible") int visible
            ,@Field("list_id") String list_id,@Field("lat") float lat,@Field("long") float longitude
            ,@Field("annotations") String annotations);

    @GET(ConstantAPI.STATUSES_GO)
    Observable<String> goWeibo(@Query("uid")long uid,@Query("id") long id);
}
