package com.yanxing.weibo.common;

import android.support.v4.view.ViewPager;

/**
 * Created by lishuangxiang on 2016/12/22.
 */
public abstract class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public abstract void onPageSelected(int position);

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
