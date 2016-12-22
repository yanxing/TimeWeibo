package com.yanxing.weibo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * Created by lishuangxiang on 2016/11/30.
 */

public abstract class BaseFragment<V, T extends BasePresenter<V>> extends RxFragment {

    public T mPresenter;

    protected String TAG=getClass().getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(getLayoutResID(),container,false);
        ButterKnife.bind(this, view);
        mPresenter = initPresenter();
        afterInstanceView();
        return view;
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
        Toast.makeText(getActivity().getApplicationContext(), toast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        Fresco.getImagePipeline().pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        Fresco.getImagePipeline().resume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDestroy();
        }
    }
}
