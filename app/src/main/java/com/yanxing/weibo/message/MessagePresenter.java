package com.yanxing.weibo.message;

import android.content.Context;

import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.base.RetrofitManage;
import com.yanxing.weibo.weiboapi.CommentsApi;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.model.Comment;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李双祥 on 2017/1/12.
 */
public class MessagePresenter extends BasePresenter<MessageView> {
    private Context mContext;

    public MessagePresenter(MessageView messageView, Context context) {
        this.mBaseView = messageView;
        mContext = context;
    }

    /**
     * 获取评论列表
     * @param currentPage 当前页
     * @param pageSize
     */
    public void getComments(int currentPage,int pageSize){
        CommentsApi commentsApi= RetrofitManage.getInstance().getRetrofit(mContext).create(CommentsApi.class);
        Map<String,String> map=new HashMap<>();
        map.put("page",String.valueOf(currentPage));
        map.put("count",String.valueOf(pageSize));
        commentsApi.getComments(ConstantAPI.COMMENT_TO_ME,map)
                .compose(mBaseView.<Comment>rxLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Comment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                         mBaseView.setError(e.getMessage());
                    }

                    @Override
                    public void onNext(Comment comment) {
                        mBaseView.setData(comment);
                    }
                });
    }
}
