package com.yanxing.weibo.me;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.UserApi;
import com.yanxing.weibo.weiboapi.model.User;

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
     * 获取登录用户信息
     * @param uid
     */
    public void getMeInfo(String uid){
        UserApi userApi= RetrofitManage.getInstance().getRetrofit(mContext).create(UserApi.class);
        userApi.getUserInfo(uid)
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

}
