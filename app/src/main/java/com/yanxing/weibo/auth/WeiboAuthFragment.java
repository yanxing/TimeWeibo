package com.yanxing.weibo.auth;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;

import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.util.PermissionUtil;
import com.yanxing.weibo.view.ConfirmDialog;

import de.greenrobot.event.EventBus;
import rx.Observable;

/**
 * 微博授权
 * Created by lishuangxiang on 2016/12/23.
 */
public class WeiboAuthFragment extends BaseFragment<WeiboView, WeiboAuthPresenter>
        implements WeiboView {

    private static final int QUESTION_LOCATION = 1;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_weibo_auth;
    }

    @Override
    protected void afterInstanceView() {
        checkPermission();
        mPresenter.auth(getActivity());
    }

    /**
     * 检查并申请定位权限
     */
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionUtil.checkSelfPermission(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                    , Manifest.permission.READ_EXTERNAL_STORAGE}, QUESTION_LOCATION);
        }
    }

    @Override
    protected WeiboAuthPresenter initPresenter() {
        return new WeiboAuthPresenter(this);
    }

    @Override
    public void onSuccess() {
        showToast(getString(R.string.auth_success));
        EventBus.getDefault().post("auth");
    }
     /**
     * 提示再次授权
     */
    public void showConfirmDialog() {
        final ConfirmDialog confirmDialog = new ConfirmDialog(getActivity(), getString(R.string.auth_tip));
        confirmDialog.setConfirmButton(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.auth(getActivity());
                confirmDialog.dismiss();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults) {
        if (requestCode == QUESTION_LOCATION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                for (String permission : permissions) {
                    PermissionUtil.getPermissionTip(permission);
                }
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 发起 SSO 登陆的 Activity 必须重写 onActivityResults
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.authorizeCallBack(requestCode, resultCode, data);
    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public void setError(String error) {
        showToast(error);
    }

    @Override
    public Observable.Transformer rxLifecycle() {
        return null;
    }
}
