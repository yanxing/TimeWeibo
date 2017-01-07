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

    /**
     * 获取发微博的位置信息
     * @param weiboList
     */
    public void getGeoToAddress(final List<FriendTimeLine.StatusesBean> weiboList) {
        final int[] indexOfWeiboList = {-1};
        Observable.from(weiboList)
                //只处理有位置信息的微博
                .filter(new Func1<FriendTimeLine.StatusesBean, Boolean>() {
                    @Override
                    public Boolean call(FriendTimeLine.StatusesBean statusesBean) {
                        indexOfWeiboList[0]++;
                        return statusesBean.getGeo() != null && statusesBean.getGeo().getCoordinates() != null;
                    }
                })
                //保持顺序
                .concatMap(new Func1<FriendTimeLine.StatusesBean, Observable<GeoToAddress>>() {

                    @Override
                    public Observable<GeoToAddress> call(FriendTimeLine.StatusesBean statusesBean) {
                        LocationApi locationApi = mRetrofitManage.initRetrofit(mContext).create(LocationApi.class);
                        List<Double> coordinates = statusesBean.getGeo().getCoordinates();
                        return locationApi.getGeoToAddress(ConstantAPI.GEO_TO_ADDRESS, coordinates.get(1)
                                + "," + coordinates.get(0));
                    }
                })
                .compose(mView.<GeoToAddress>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GeoToAddress>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //获取失败，只显示地点名，无城市信息
                        FriendTimeLine.StatusesBean statusesBean=weiboList.get(indexOfWeiboList[0]);
                        if (statusesBean.getAnnotations()!=null&&statusesBean.getAnnotations().size()>0){
                            FriendTimeLine.StatusesBean.AnnotationsBeanX.PlaceBean placeBean=statusesBean
                                    .getAnnotations().get(0).getPlace();
                            if (placeBean!=null){
                                String detailAddress=placeBean.getTitle();
                                statusesBean.setLocation(detailAddress);
                                mView.updateNotifyItemChanged(indexOfWeiboList[0]);
                            }
                        }
                    }

                    @Override
                    public void onNext(GeoToAddress geoToAddress) {
                        if (geoToAddress.getGeos()!=null&&geoToAddress.getGeos().size()>0){
                            FriendTimeLine.StatusesBean statusesBean=weiboList.get(indexOfWeiboList[0]);
                            if (statusesBean.getAnnotations()!=null&&statusesBean.getAnnotations().size()>0){
                                String detailAddress=statusesBean.getAnnotations().get(0).getPlace().getTitle();
                                statusesBean.setLocation(geoToAddress.getGeos().get(0).getCity_name()+"·"+detailAddress);
                                mView.updateNotifyItemChanged(indexOfWeiboList[0]);
                            }
                        }
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
