package com.yanxing.weibo.common;


import android.os.Bundle;
import android.view.View;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.yanxing.sortlistviewlibrary.CityListFragment;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.weiboapi.model.Following;

import java.util.ArrayList;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import rx.Observable;
import rx.functions.Action1;

/**
 * @ 人列表，这里获取的是登录用户的关注人
 * Created by lishuangxiang on 2017/2/13.
 */
public class AtUsersActivity extends BaseActivity<AtUserView, AtUserPresenter>
    implements AtUserView,CityListFragment.Callback {

    @BindView(R.id.load)
    View mLoad;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_at_users;
    }

    @Override
    protected void afterInstanceView() {
        Oauth2AccessToken oauth2AccessToken=AccessTokenUtil.readAccessToken(getApplicationContext());
        mPresenter.getFollowing(oauth2AccessToken.getUid(),50,0);
    }

    @Override
    protected AtUserPresenter initPresenter() {
        return new AtUserPresenter(this,getApplicationContext());
    }

    @Override
    public void setData(Following data) {
        mLoad.setVisibility(View.GONE);
        final ArrayList<String> list=new ArrayList<>();
        Observable.from(data.getUsers())
                .subscribe(new Action1<Following.UsersBean>() {
                    @Override
                    public void call(Following.UsersBean usersBean) {
                        list.add(usersBean.getName()+","+usersBean.getAvatar_large());
                    }
                });
        CityListFragment cityListFragment=new CityListFragment();
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("user",list);
        cityListFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content,cityListFragment)
                .commit();
    }

    @Override
    public void setError(String error) {
        mLoad.setVisibility(View.GONE);
        showToast(error);
    }

    @Override
    public <V> Observable.Transformer<V, V> rxLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void select(String name) {
        EventBus.getDefault().post(name);
        finish();
    }
}
