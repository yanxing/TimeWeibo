package com.yanxing.weibo.home;

import android.content.Intent;
import android.os.Bundle;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.me.MeMainFragment;

/**
 * 首页微博流点击头像用户主页
 * Created by lishuangxiang on 2017/2/22.
 */
public class UserDetailActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user_detail;
    }

    @Override
    protected void afterInstanceView() {
        Intent intent=getIntent();
        MeMainFragment meMainFragment=new MeMainFragment();
        Bundle bundle=new Bundle();
        String screenName=intent.getStringExtra("screenName");
        if (screenName!=null){
            bundle.putString("screenName",screenName);
        }else {
            bundle.putString("uid",intent.getStringExtra("uid"));
        }
        bundle.putBoolean("userDetail",true);
        meMainFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content,meMainFragment)
                .commit();

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
