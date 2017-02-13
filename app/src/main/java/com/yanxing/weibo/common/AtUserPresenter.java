package com.yanxing.weibo.common;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.FriendshipsApi;
import com.yanxing.weibo.weiboapi.model.Following;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lishuangxiang on 2017/2/13.
 */
public class AtUserPresenter extends BasePresenter<AtUserView> {

    private Context mContext;

    public AtUserPresenter(AtUserView atUserView, Context context) {
        this.mBaseView = atUserView;
        mContext = context;
    }

    /**
     * 获取关注的人
     * @param uid 需要查询的用户UID
     * @param count 单页返回的记录条数，默认为50，最大不超过200。
     * @param cursor 返回结果的游标，下一页用返回值里的next_cursor，上一页用previous_cursor，默认为0。
     */
    public void getFollowing(String uid,int count,int cursor){
        final FriendshipsApi friendshipsApi = RetrofitManage.getInstance().getRetrofit(mContext).create(FriendshipsApi.class);
        friendshipsApi.getFollowing(uid,count,cursor,0)
                .compose(mBaseView.<Following>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Following>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                       mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(Following following) {
                       mBaseView.setData(following);
                    }
                });
    }
}
