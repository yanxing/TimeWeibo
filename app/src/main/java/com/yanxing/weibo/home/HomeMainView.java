package com.yanxing.weibo.home;

import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import rx.Observable;

/**
 * Created by 李双祥 on 2016/12/24.
 */
public interface HomeMainView {

    void setData(FriendTimeLine friendTimeLine);

    void upateNotifyItemChanged(int position);

    void setError(String error);

    /**
     * 取消Rx中的订阅
     * @return
     */
    <T> Observable.Transformer<T, T> rxLifecycle();
}
