package com.yanxing.weibo.home;

import com.yanxing.weibo.base.BaseView;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

/**
 * Created by 李双祥 on 2016/12/24.
 */
public interface HomeMainView extends BaseView<FriendTimeLine>{

    void updateNotifyItemChanged(int position);
}
