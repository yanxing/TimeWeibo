package com.yanxing.weibo.home;

import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

/**
 * Created by 李双祥 on 2016/12/24.
 */
public interface HomeMainView {

    void setData(FriendTimeLine friendTimeLine);

    void setError(String error);
}
