package com.yanxing.weibo.discover;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.BasePresenterImpl;

/**
 * 发现，搜索一些微博（热门微博，好像没有开放）
 * Created by lishuangxiang on 2016/12/22.
 */
public class DiscoverMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_discover_main;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenterImpl initPresenter() {
        return null;
    }
}
