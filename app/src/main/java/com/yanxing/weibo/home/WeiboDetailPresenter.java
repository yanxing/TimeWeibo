package com.yanxing.weibo.home;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.CommentsApi;
import com.yanxing.weibo.weiboapi.model.WeiboComment;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lishuangxiang on 2017/1/4.
 */
public class WeiboDetailPresenter extends BasePresenter<WeiboDetailView> {

    private Context mContext;

    public WeiboDetailPresenter(WeiboDetailView weiboDetailView, Context context) {
        this.mView = weiboDetailView;
        mContext = context;
    }


    /**
     * 获取微博评论列表
     *
     * @param weiboID
     * @param currentPage 当前页
     * @param pageSize    页条数
     */
    public void getWeiboCommentList(long weiboID, int currentPage, int pageSize) {
        CommentsApi commentsApi = RetrofitManage.getInstance().getRetrofit(mContext).create(CommentsApi.class);
        commentsApi.getWeiboComments(weiboID, 0, 0, pageSize, currentPage, 0)
                .compose(mView.<WeiboComment>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<WeiboComment>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(WeiboComment weiboComment) {
                        mView.setData(weiboComment);
                    }
                });
    }

}
