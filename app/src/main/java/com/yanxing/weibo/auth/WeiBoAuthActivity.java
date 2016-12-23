package com.yanxing.weibo.auth;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;

/**
 * 微博授权
 * Created by lishuangxiang on 2016/12/23.
 */
public class WeiBoAuthActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_weibo_auth;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
