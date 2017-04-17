package com.yanxing.weibo.home;

import android.content.Intent;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.StatusesApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 微博页，根据ID跳转，用的是原生微博详情页
 * Created by lishuangxiang on 2017/2/22.
 */
public class WeiboDetailWebActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_weibo_detail_web;
    }

    @Override
    protected void afterInstanceView() {
        Intent intent=getIntent();
        long uid=intent.getLongExtra("uid",0);
        long id=intent.getLongExtra("id",0);
        StatusesApi statusesApi= RetrofitManage.getInstance().getRetrofit(getApplicationContext()).create(StatusesApi.class);
        statusesApi.goWeibo(uid,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                showToast(e.getMessage());

            }

            @Override
            public void onNext(String s) {
               showToast(s);
            }
        });


    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
