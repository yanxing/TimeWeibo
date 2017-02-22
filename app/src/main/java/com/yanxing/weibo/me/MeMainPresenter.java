package com.yanxing.weibo.me;

import android.content.Context;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.StatusesApi;
import com.yanxing.weibo.weiboapi.UserApi;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.User;
import com.yanxing.weibo.weiboapi.model.UserTimeLine;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lishuangxiang on 2017/1/10.
 */
public class MeMainPresenter extends BasePresenter<MeMainView> {

    private Context mContext;

    public MeMainPresenter(MeMainView meMainView, Context context){
        this.mBaseView =meMainView;
        mContext=context;
    }

    /**
     * 获取用户信息
     * 参数uid与screen_name二者必选其一，且只能选其一；
     * 接口升级后，对未授权本应用的uid，将无法获取其个人简介、认证原因、粉丝数、关注数、微博数及最近一条微博内容。
     */
    public void getMeInfo(String uid,String screenName){
        UserApi userApi= RetrofitManage.getInstance().getRetrofit(mContext).create(UserApi.class);
        Map<String,String> map=new HashMap<>();
        if (uid!=null){
            map.put("uid",uid);
        }else {
            map.put("screen_name",screenName);
        }
        userApi.getUserInfo(ConstantAPI.SHOW,map)
                .compose(mBaseView.<User>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                       mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(User s) {
                      mBaseView.setData(s);
                    }
                });
    }

    /**
     * 获取用户微博，接口限制最多只能获取10条 参数uid与screen_name二者必选其一，且只能选其一；
     * @param currentPage
     * @param pageSize
     */
    public void getMeWeiboList(String uid,String screenName,int currentPage, int pageSize){
        StatusesApi statusesApi=RetrofitManage.getInstance().getRetrofit(mContext).create(StatusesApi.class);
        Map<String,String> map=new HashMap<>();
        if (uid!=null){
            map.put("uid",uid);
        }else {
            map.put("screen_name",screenName);
        }
        map.put("page",String.valueOf(currentPage));
        map.put("count",String.valueOf(pageSize));
        statusesApi.getUserTimeline(map)
                .compose(mBaseView.<FriendTimeLine>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<FriendTimeLine>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(FriendTimeLine s) {
                        mBaseView.setUserTimeLine(s);
                    }
                });
    }

}
