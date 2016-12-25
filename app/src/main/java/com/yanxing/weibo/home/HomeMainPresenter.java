package com.yanxing.weibo.home;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.trello.rxlifecycle.components.support.RxFragment;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.util.LogUtil;
import com.yanxing.weibo.util.ParseJsonUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.FixedParameterInterceptor;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李双祥 on 2016/12/23.
 */
public class HomeMainPresenter extends BasePresenter<HomeMainView> {

    private HomeMainView mHomeMainView;
    private Retrofit mRetrofit;

    public HomeMainPresenter(HomeMainView homeMainView, Context context) {
        Oauth2AccessToken oauth2AccessToken = AccessTokenUtil.readAccessToken(context);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new FixedParameterInterceptor(oauth2AccessToken.getToken()))
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ConstantAPI.API_SERVER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mHomeMainView = homeMainView;
    }

    /**
     * 获取当前登录用户及其所关注（授权）用户的最新微博
     *
     * @param currentPage          当前页
     * @param pageSize             页大小
     * @param rxFragmentOrActivity
     */
    public void getFollowWeiboList(int currentPage, int pageSize, Object rxFragmentOrActivity) {
        Observable.Transformer<FriendTimeLine, FriendTimeLine> transformer;
        if (rxFragmentOrActivity instanceof RxFragmentActivity) {
            transformer = ((RxFragmentActivity) rxFragmentOrActivity).bindToLifecycle();
        } else if (rxFragmentOrActivity instanceof RxFragment) {
            transformer = ((RxFragment) rxFragmentOrActivity).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("rxFragmentOrActivity must is RxFragmentActivity or" +
                    "RxFragment");
        }
        StatusesApi statusesApi = mRetrofit.create(StatusesApi.class);
        statusesApi.getFriendsTimeline(0, 0, pageSize, currentPage, 0, 0, 0)
                .compose(transformer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FriendTimeLine>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mHomeMainView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(FriendTimeLine friendTimeLine) {
                        mHomeMainView.setData(friendTimeLine);
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
        mHomeMainView.setData(friendTimeLine);
    }
}
