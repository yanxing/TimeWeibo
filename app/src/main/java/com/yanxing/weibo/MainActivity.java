package com.yanxing.weibo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.adapter.FragmentAdapter;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.common.MyOnPageChangeListener;
import com.yanxing.weibo.discover.DiscoverMainFragment;
import com.yanxing.weibo.home.HomeMainFragment;
import com.yanxing.weibo.me.MeMainFragment;
import com.yanxing.weibo.message.MessageMainFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @BindView(R.id.home)
    ImageView mHome;

    @BindView(R.id.message)
    ImageView mMessage;

    @BindView(R.id.send)
    ImageView mSend;

    @BindView(R.id.discover)
    ImageView mDiscover;

    @BindView(R.id.me)
    ImageView mMe;

    public static final int HOME = 0;
    public static final int MESSAGE = 1;
    public static final int DISCOVER = 2;
    public static final int ME = 3;


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterInstanceView() {
        addHMDM();
        mViewPager.addOnPageChangeListener(new MyOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                setTab(position);
            }
        });
    }

    /**
     * 添加主页、信息、发现、我
     */
    public void addHMDM() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        HomeMainFragment homeMainFragment = new HomeMainFragment();
        MessageMainFragment messageMainFragment = new MessageMainFragment();
        DiscoverMainFragment discoverMainFragment = new DiscoverMainFragment();
        MeMainFragment meMainFragment = new MeMainFragment();
        fragments.add(homeMainFragment);
        fragments.add(messageMainFragment);
        fragments.add(discoverMainFragment);
        fragments.add(meMainFragment);
        FragmentAdapter fragmentStatePagerAdapter = new
                FragmentAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(fragmentStatePagerAdapter);
        mViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.home, R.id.message, R.id.send, R.id.discover, R.id.me})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                mViewPager.setCurrentItem(HOME);
                break;
            case R.id.message:
                mViewPager.setCurrentItem(MESSAGE);
                break;
            case R.id.send:


                break;
            case R.id.discover:
                mViewPager.setCurrentItem(DISCOVER);
                break;
            case R.id.me:
                mViewPager.setCurrentItem(ME);
                break;
        }
    }

    /**
     * 设置底部导航图片
     *
     * @param index
     */
    private void setTab(int index) {
        mHome.setImageDrawable(getResources().getDrawable(index == HOME ? R.mipmap.home_press : R.mipmap.home));
        mMessage.setImageDrawable(getResources().getDrawable(index == MESSAGE ? R.mipmap.message_press : R.mipmap.message));
        mDiscover.setImageDrawable(getResources().getDrawable(index == DISCOVER ? R.mipmap.discover_press : R.mipmap.discover));
        mMe.setImageDrawable(getResources().getDrawable(index == ME ? R.mipmap.me_press : R.mipmap.me));
        mTitleBar.setVisibility(View.VISIBLE);
        if (index == HOME) {
            mTitleBar.setTitle(getString(R.string.home));
        } else if (index == MESSAGE) {
            mTitleBar.setTitle(getString(R.string.message));
        } else if (index == DISCOVER) {
            mTitleBar.setVisibility(View.GONE);
        } else if (index == ME) {
            mTitleBar.setTitle(getString(R.string.me));
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
