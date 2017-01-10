package com.yanxing.weibo.me;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.weiboapi.model.User;

import butterknife.BindView;
import rx.Observable;

/**
 * 个人中心
 * Created by lishuangxiang on 2016/12/22.
 */
public class MeMainFragment extends BaseFragment<MeMainView,MeMainPresenter> implements MeMainView{

    @BindView(R.id.user_bg)
    SimpleDraweeView mUserBg;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_me_main;
    }

    @Override
    protected void afterInstanceView() {
        Oauth2AccessToken oauth2AccessToken=AccessTokenUtil.readAccessToken(getActivity());
        mPresenter.getMeInfo(oauth2AccessToken.getUid());
    }

    @Override
    protected MeMainPresenter initPresenter() {
        return new MeMainPresenter(this,getActivity());
    }

    @Override
    public void setData(User data) {

    }

    @Override
    public void setError(String error) {
        showToast(error);
    }

    @Override
    public Observable.Transformer<User, User> rxLifecycle() {
        return this.bindToLifecycle();
    }
}
