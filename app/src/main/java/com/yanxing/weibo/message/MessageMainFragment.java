package com.yanxing.weibo.message;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.base.BasePresenter;

/**
 * 消息主界面，私信、@我、评论
 * Created by lishuangxiang on 2016/12/22.
 */
public class MessageMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_message_main;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
