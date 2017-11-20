package com.yanxing.weibo.base;

/**
 * 默认实现，各个功能Presenter层没有单独写接口，直接继承此类写功能方法
 * @author 李双祥 on 2017/11/20.
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter {

    public T mBaseView;

    @Override
    public void onDestroy() {
        mBaseView=null;
    }
}
