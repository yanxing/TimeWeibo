package com.yanxing.weibo.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 微博正文
 * Created by lishuangxiang on 2016/12/29.
 */
public class WeiboDetailActivity extends BaseActivity {

    @BindView(R.id.simple_drawee_view)
    SimpleDraweeView mSimpleDraweeView;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.time)
    TextView mTime;

    @BindView(R.id.weibo)
    TextView mWeibo;

    @BindView(R.id.atWeibo)
    TextView mAtWeibo;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_weibo_detail;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @OnClick({R.id.simple_drawee_view, R.id.atWeibo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_drawee_view:

                break;
            case R.id.atWeibo:
                break;
        }
    }
}
