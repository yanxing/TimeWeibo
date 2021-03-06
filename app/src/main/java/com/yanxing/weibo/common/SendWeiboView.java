package com.yanxing.weibo.common;

import com.yanxing.weibo.base.BaseView;
import com.yanxing.weibo.weiboapi.model.CreateComment;
import com.yanxing.weibo.weiboapi.model.StatusRepost;
import com.yanxing.weibo.weiboapi.model.StatusesUpdate;

/**
 * Created by lishuangxiang on 2017/2/15.
 */
public interface SendWeiboView extends BaseView<CreateComment>{

    void setRepostWeibo(StatusRepost statusRepost);

    void setSendWeibo(StatusesUpdate sendWeibo);
}
