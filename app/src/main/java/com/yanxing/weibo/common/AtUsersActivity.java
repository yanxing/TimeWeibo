package com.yanxing.weibo.common;


import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.weiboapi.model.Following;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;

/**
 * @ 人列表，这里获取的是登录用户的关注人
 * Created by lishuangxiang on 2017/2/13.
 */
public class AtUsersActivity extends BaseActivity<AtUserView, AtUserPresenter>
    implements AtUserView{

    @BindView(R.id.ptrFrameLayout)
    PtrClassicFrameLayout mPtrFrameLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_at_users;
    }

    @Override
    protected void afterInstanceView() {
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

            }
        });
        mPtrFrameLayout.autoRefresh(true);
    }

    @Override
    protected AtUserPresenter initPresenter() {
        return new AtUserPresenter(this,getApplicationContext());
    }

    @Override
    public void setData(Following data) {
          
    }

    @Override
    public void setError(String error) {
        showToast(error);
    }

    @Override
    public <V> Observable.Transformer<V, V> rxLifecycle() {
        return this.bindToLifecycle();
    }
}
