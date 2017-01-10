package com.yanxing.weibo.me;

import com.yanxing.weibo.base.BaseView;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.User;

/**
 * Created by lishuangxiang on 2017/1/10.
 */
public interface MeMainView extends BaseView<User>{

    void setUserTimeLine(FriendTimeLine userTimeLine);

}
