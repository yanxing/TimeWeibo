package com.yanxing.weibo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.TextView;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.yanxing.weibo.auth.WeiboAuthFragment;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.util.LogUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 启动页
 * Created by lishuangxiang on 2016/12/23.
 */
public class LaunchActivity extends BaseActivity {

    @BindView(R.id.weibo)
    TextView mWeibo;

    private WeiboAuthFragment mWeiboAuthFragment = new WeiboAuthFragment();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_launch;
    }

    @Override
    protected void afterInstanceView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EventBus.getDefault().register(this);
        ObjectAnimator
                .ofFloat(mWeibo, "alpha", 0.0F, 1.0F)
                .setDuration(2000)
                .start();
        final Oauth2AccessToken oauth2AccessToken = AccessTokenUtil.readAccessToken(this);
        LogUtil.d(TAG,oauth2AccessToken.getToken()+" "+oauth2AccessToken.getUid());
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Long>bindToLifecycle())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        //token没有过期
                        if (oauth2AccessToken.getExpiresTime() > System.currentTimeMillis()) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .add(R.id.auth, mWeiboAuthFragment)
                                    .commit();
                        }
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

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
