package com.yanxing.weibo.base;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;
import com.yanxing.weibo.util.CommonUtil;

import butterknife.ButterKnife;

/**
 * Created by lishuangxiang on 2016/9/13.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends RxFragmentActivity {

    public T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonUtil.setStatusBarDarkMode(true, this);
        initImmersionStatus();
        setContentView(getLayoutResID());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        afterInstanceView();
    }

    /**
     * 子类布局ID
     */
    protected abstract int getLayoutResID();

    /**
     * 实例化控件之后操作
     */
    protected abstract void afterInstanceView();

    protected abstract T initPresenter();

    /**
     * 显示toast消息
     *
     * @param toast
     */
    public void showToast(String toast) {
        Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        //列表快速滑动时暂停加载
        Fresco.getImagePipeline().pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Fresco.getImagePipeline().resume();
        super.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestroy();
        }
    }

    /**
     * 使用沉浸式状态栏
     */
    public void initImmersionStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}
