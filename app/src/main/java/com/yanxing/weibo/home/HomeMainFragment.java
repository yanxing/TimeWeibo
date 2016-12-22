package com.yanxing.weibo.home;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.base.BasePresenter;

/**
 * 微博主页，关注人的微博列表
 * Created by lishuangxiang on 2016/12/22.
 */
public class HomeMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
