package com.yanxing.weibo.common;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.BasePresenterImpl;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.CommentsApi;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.model.CreateComment;
import com.yanxing.weibo.weiboapi.model.StatusRepost;
import com.yanxing.weibo.weiboapi.model.StatusesUpdate;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lishuangxiang on 2017/2/15.
 */
public class SendWeiboPresenter extends BasePresenterImpl<SendWeiboView> {

    private Context mContext;

    public SendWeiboPresenter(SendWeiboView sendWeiboView, Context context) {
        this.mBaseView = sendWeiboView;
        mContext = context;
    }

    /**
     * 创建一个微博评论，不含图片
     *
     * @param id         需要评论的微博ID
     * @param comment    评论内容，必须做URLencode，内容不超过140个汉字。
     * @param commentOri 当评论转发微博时，是否评论给原微博，0：否、1：是，默认为0。
     */
    public void createComment(long id, String comment, int commentOri) {
        CommentsApi commentsApi = RetrofitManage.getInstance().getRetrofit(mContext).create(CommentsApi.class);
        commentsApi.createComments(comment, id, 0)
                .compose(mBaseView.<CreateComment>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CreateComment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(CreateComment createComment) {
                        mBaseView.setData(createComment);
                    }
                });
    }

    /**
     * 转发一条微博
     *
     * @param id         需要评论的微博ID
     * @param content    添加的转发文本，必须做URLencode，内容不超过140个汉字，不填则默认为“转发微博”。
     * @param commentOri 是否在转发的同时发表评论，0：否、1：评论给当前微博、2：评论给原微博、3：都评论，默认为0 。
     */
    public void repostWeibo(long id, String content, int commentOri) {
        final StatusesApi statusesApi = RetrofitManage.getInstance().getRetrofit(mContext).create(StatusesApi.class);
        statusesApi.repostWeibo(id, content, commentOri)
                .compose(mBaseView.<StatusRepost>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StatusRepost>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusRepost statusRepost) {
                        mBaseView.setRepostWeibo(statusRepost);
                    }
                });
    }

    /**
     * 发微博，不含图片
     *
     * @param content     要发布的微博文本内容，必须做URLencode，内容不超过140个汉字。
     * @param visible     微博的可见性，0：所有人能看，1：仅自己可见，2：密友可见，3：指定分组可见，默认为0。
     * @param listID      微博的保护投递指定分组ID，只有当visible参数为3时生效且必选。long[2~9223372036854775807]
     * @param latitude    纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
     * @param longitude   经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
     * @param annotations 元数据，主要是为了方便第三方应用记录一些适合于自己使用的信息，每条微博可以包含一个或者多个元数据，必须以json字串的形式提交，字串长度不超过512个字符，具体内容可以自定。
     */
    public void sendWeibo(String content, int visible, String listID, float latitude, float longitude, String annotations) {
        final StatusesApi statusesApi = RetrofitManage.getInstance().getRetrofit(mContext).create(StatusesApi.class);
        statusesApi.sendWeibo(content, visible, listID, latitude, longitude, annotations)
                .compose(mBaseView.<StatusesUpdate>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<StatusesUpdate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(StatusesUpdate statusesUpdate) {
                        mBaseView.setSendWeibo(statusesUpdate);
                    }
                });
    }
}
