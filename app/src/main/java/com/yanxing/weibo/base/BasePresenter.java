package com.yanxing.weibo.base;

/**
 * Created by lishuangxiang on 2016/9/13.
 */
public abstract class BasePresenter<T extends BaseView> {

    public T mBaseView;

    /**
     * 销毁持有的View
     */
    public void onDestroy() {
        this.mBaseView = null;
    }

}
