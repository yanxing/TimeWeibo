package com.yanxing.weibo.me;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.CommonUtil;

/**
 * 个人中心
 * Created by lishuangxiang on 2016/12/22.
 */
public class MeMainFragment extends BaseFragment {

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_me_main;
    }

    @Override
    protected void afterInstanceView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
