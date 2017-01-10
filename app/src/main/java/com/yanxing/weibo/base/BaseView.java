package com.yanxing.weibo.base;

import rx.Observable;

/**
 * Created by lishuangxiang on 2017/1/10.
 */
public interface BaseView<T> {

    /**
     * 请求数据成功
     * @param data
     */
    void setData(T data);

    void setError(String error);

    /**
     * 取消Rx中的订阅
     * @return
     */
    <V> Observable.Transformer<V, V> rxLifecycle();
}
