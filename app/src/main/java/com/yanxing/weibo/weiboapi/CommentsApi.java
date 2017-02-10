package com.yanxing.weibo.weiboapi;

import com.yanxing.weibo.weiboapi.model.Comment;
import com.yanxing.weibo.weiboapi.model.WeiboComment;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 评论接口相关
 * Created by lishuangxiang on 2017/1/4.
 */
public interface CommentsApi{


    /**
     * 获取某条微博的评论列表
     * @param since_id 若指定此参数，则返回ID比since_id大的评论（即比since_id时间晚的评论），默认为0。
     * @param max_id   若指定此参数，则返回ID小于或等于max_id的评论，默认为0。
     * @param count    单页返回的记录条数，默认为50。
     * @param page     返回结果的页码，默认为1。
     * @param filter_by_author 作者筛选类型，0：全部、1：我关注的人、2：陌生人，默认为0。
     * @return
     */
    @GET(ConstantAPI.COMMENTS)
    Observable<WeiboComment> getWeiboComments(@Query("id") long id
            , @Query("since_id") int since_id
            , @Query("max_id") int max_id
            , @Query("count") int count
            , @Query("page") int page
            , @Query("filter_by_author") int filter_by_author);

    /**
     * 评论相关
     * @param path
     * @param map
     * @return
     */
    @GET(ConstantAPI.COMMENT)
    Observable<Comment> getComments(@Path("path") String path, @QueryMap Map<String,String> map);
}
