package com.yanxing.weibo.home;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.util.ParseJsonUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.LocationApi;
import com.yanxing.weibo.weiboapi.interceptor.CacheInterceptor;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.GeoToAddress;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
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
                .compose(mView.<FriendTimeLine>rxLifecycle())
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

    public void getGeoToAddress(List<FriendTimeLine.StatusesBean> weiboList){
        final int[] indexOfWeiboList = {0};
        Observable.from(weiboList)
                .filter(new Func1<FriendTimeLine.StatusesBean, Boolean>() {
                    @Override
                    public Boolean call(FriendTimeLine.StatusesBean statusesBean) {
                        indexOfWeiboList[0]++;
                        return statusesBean.getGeo()!=null&&statusesBean.getGeo().getCoordinates()!=null;
                    }
                }).subscribe(new Action1<FriendTimeLine.StatusesBean>() {
            @Override
            public void call(FriendTimeLine.StatusesBean statusesBean) {
                   test(statusesBean,indexOfWeiboList[0]);
            }
        });

    }

    public void test(final FriendTimeLine.StatusesBean statusesBean , final int index){
        List<Double> coordinates=statusesBean.getGeo().getCoordinates();
        LocationApi locationApi = mRetrofitManage.initRetrofit(mContext).create(LocationApi.class);
        locationApi.getGeoToAddress(ConstantAPI.GEO_TO_ADDRESS,coordinates.get(1)+
                ","+coordinates.get(0))
                .compose(mView.<GeoToAddress>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GeoToAddress>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(GeoToAddress geoToAddress) {
                        if (geoToAddress.getGeos()!=null&&geoToAddress.getGeos().size()>0){
                            if (statusesBean.getAnnotations()!=null&&statusesBean.getAnnotations().size()>0){
                                String detailAddress=statusesBean.getAnnotations().get(0).getPlace().getTitle();
                                statusesBean.setLocation(geoToAddress.getGeos().get(0).getCity_name()+"·"+detailAddress);
                                mView.upateNotifyItemChanged(index);
                            }
                        }

//                        mView.setData(geoToAddress);
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
