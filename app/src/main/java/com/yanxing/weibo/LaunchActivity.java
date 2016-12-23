package com.yanxing.weibo;

import android.content.Intent;
import android.view.WindowManager;

import com.yanxing.weibo.auth.WeiboAuthFragment;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 启动页
 * Created by lishuangxiang on 2016/12/23.
 */
public class LaunchActivity extends BaseActivity {

    private WeiboAuthFragment mWeiboAuthFragment = new WeiboAuthFragment();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_launch;
    }

    @Override
    protected void afterInstanceView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Long>bindToLifecycle())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.auth, mWeiboAuthFragment)
                                .commit();
                    }
                });
    }

    public void onEvent(String auth) {
        if (auth.equals("auth")) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mWeiboAuthFragment.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
