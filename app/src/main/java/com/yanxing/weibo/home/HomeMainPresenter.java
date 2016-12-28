package com.yanxing.weibo.home;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.util.ParseJsonUtil;
import com.yanxing.weibo.weiboapi.interceptor.CacheInterceptor;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李双祥 on 2016/12/23.
 */
public class HomeMainPresenter extends BasePresenter<HomeMainView> {

    private RetrofitManage mRetrofitManage;
    private Context mContext;

    public HomeMainPresenter(HomeMainView homeMainView, Context context) {
        mRetrofitManage = RetrofitManage.getInstance();
        this.mView = homeMainView;
        mContext = context;
    }

    /**
     * 获取当前登录用户及其所关注（授权）用户的最新微博
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     */
    public void getFollowWeiboList(int currentPage, int pageSize) {
        getFollowWeiboList(currentPage, pageSize, false);
    }

    /**
     * 获取当前登录用户及其所关注（授权）用户的最新微博，useCache为true时使用的是本地缓存数据，没有返回为null
     *
     * @param currentPage 当前页
     * @param pageSize    页大小
     * @param useCache    true 使用缓存数据，false不使用
     */
    public void getFollowWeiboList(int currentPage, int pageSize, boolean useCache) {
        CacheInterceptor cacheInterceptor = new CacheInterceptor(mContext, useCache);
        mRetrofitManage.setCacheInterceptor(cacheInterceptor);
        final StatusesApi statusesApi = mRetrofitManage.initRetrofit(mContext).create(StatusesApi.class);
        statusesApi.getFriendsTimeline(0, 0, pageSize, currentPage, 0, 0, 0)
                .compose(mView.rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FriendTimeLine>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(FriendTimeLine friendTimeLine) {
                        mView.setData(friendTimeLine);
                    }
                });
    }

    /**
     * 加载测试数据
     *
     * @param context
     */
    public void loadTestData(Context context) {
        FriendTimeLine friendTimeLine = ParseJsonUtil.convertJson(
                ParseJsonUtil.getJsonFileString(context, "weibotest.json")
                , FriendTimeLine.class);
        mView.setData(friendTimeLine);
    }
}
