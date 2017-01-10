package com.yanxing.weibo.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.AccessTokenUtil;
import com.yanxing.weibo.util.ConstantValue;

/**
 * 授权处理
 * Created by lishuangxiang on 2016/12/23.
 */
public class WeiboAuthPresenter extends BasePresenter<WeiboView> {

    private WeiboView mWeiboView;
    private SsoHandler mSsoHandler;

    public WeiboAuthPresenter(WeiboView weiboView) {
        this.mWeiboView = weiboView;
    }

    /**
     * SSO授权,如果手机安装了微博客户端则使用客户端授权,没有则进行网页授权
     *
     * @param context
     */
    public void auth(final Context context) {
        AuthInfo authInfo = new AuthInfo(context, ConstantValue.APP_KEY
                , ConstantValue.REDIRECT_URL, ConstantValue.SCOPE);
        mSsoHandler = new SsoHandler((Activity) context, authInfo);
        mSsoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle values) {
                Oauth2AccessToken oauth2AccessToken = Oauth2AccessToken.parseAccessToken(values);
                if (oauth2AccessToken.isSessionValid()) {
                    AccessTokenUtil.writeAccessToken(context, oauth2AccessToken);
                    mWeiboView.onSuccess();
                } else {
                    String code = values.getString("code");
                    mWeiboView.setError(context.getString(R.string.auth_error)+Integer.valueOf(code));
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {
                mWeiboView.setError(context.getString(R.string.auth_error)+e.getMessage());
            }

            @Override
            public void onCancel() {
                mWeiboView.setError(context.getString(R.string.auth_cancel));
            }
        });

    }

    /**
     * 此方法需要在onActivityResult方法中调用。
     * SSO 授权时，需要在onActivityResult中调用SsoHandler#authorizeCallBack后，
     * WeiboAuthListener该回调才会被执行。
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void authorizeCallBack(int requestCode, int resultCode, Intent data) {
        mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
    }
}
