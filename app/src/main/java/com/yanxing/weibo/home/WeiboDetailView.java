package com.yanxing.weibo.home;

import com.yanxing.weibo.weiboapi.model.WeiboComment;

import rx.Observable;

/**
 * Created by lishuangxiang on 2017/1/4.
 */
public interface WeiboDetailView {

    void setData(WeiboComment weiboComment);

    void setError(String error);

    /**
     * 取消Rx中的订阅
     * @return
     */
    <T> Observable.Transformer<T, T> rxLifecycle();
}
