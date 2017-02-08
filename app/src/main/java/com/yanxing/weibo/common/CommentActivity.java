package com.yanxing.weibo.common;

import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;

import butterknife.BindView;

/**
 * 发评论
 * Created by lishuangxiang on 2017/2/8.
 */
public class CommentActivity extends BaseActivity {

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_comment;
    }

    @Override
    protected void afterInstanceView() {
//        mTitleBar.set

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
