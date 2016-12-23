package com.yanxing.weibo;

import android.content.Intent;
import android.os.Handler;

import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;

/**
 * 启动页
 * Created by lishuangxiang on 2016/12/23.
 */
public class LaunchActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_launch;
    }

    @Override
    protected void afterInstanceView() {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                finish();
//            }
//        },4000);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
