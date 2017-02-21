package com.yanxing.weibo.common;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.CommentsApi;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.model.CreateComment;
import com.yanxing.weibo.weiboapi.model.StatusRepost;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lishuangxiang on 2017/2/15.
 */
public class SendWeiboPresenter extends BasePresenter<SendWeiboView>{

    private Context mContext;

    public SendWeiboPresenter(SendWeiboView sendWeiboView, Context context) {
        this.mBaseView = sendWeiboView;
        mContext = context;
    }

    /**
     * 创建一个微博评论，不含图片
     * @param id         需要评论的微博ID
     * @param comment    评论内容，必须做URLencode，内容不超过140个汉字。
     * @param commentOri 当评论转发微博时，是否评论给原微博，0：否、1：是，默认为0。
     */
    public void createComment(long id,String comment,int commentOri){
        CommentsApi commentsApi= RetrofitManage.getInstance().getRetrofit(mContext).create(CommentsApi.class);
        commentsApi.createComments(comment,id,0)
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
     * @param id         需要评论的微博ID
     * @param content    添加的转发文本，必须做URLencode，内容不超过140个汉字，不填则默认为“转发微博”。
     * @param commentOri 是否在转发的同时发表评论，0：否、1：评论给当前微博、2：评论给原微博、3：都评论，默认为0 。
     */
    public void repostWeibo(long id,String content,int commentOri){
        final StatusesApi statusesApi=RetrofitManage.getInstance().getRetrofit(mContext).create(StatusesApi.class);
        statusesApi.repostWeibo(id,content,commentOri)
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
}
