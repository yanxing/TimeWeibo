package com.yanxing.weibo.common;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.util.CommonUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 发评论,发微博
 * Created by lishuangxiang on 2017/2/8.
 */
public class SendWeiboOrCommentActivity extends BaseActivity {

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @BindView(R.id.comment)
    EditText mComment;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_comment;
    }

    @Override
    protected void afterInstanceView() {
        //先隐藏输入法，再停顿200ms关闭当前页，为了防止回到上个界面有一闪空白效果
        mTitleBar.setOnClickBackLayout(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.hideInputKeyBoard(getApplicationContext(),mComment);
                Observable.timer(200, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(SendWeiboOrCommentActivity.this.<Long>bindToLifecycle())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                               finish();
                            }
                        });
            }
        });
        setUI();
    }

    /**
     * 初始界面
     */
    public void setUI(){
        Intent intent=getIntent();
        int type=intent.getIntExtra("type",0);
        if (type==0){//发微博
            mTitleBar.setTitle(getString(R.string.send_weibo));
        }else if (type==1){//发评论
            mTitleBar.setTitle(getString(R.string.send_comment1));
        }else if (type==2){//转发微博
            mTitleBar.setTitle(getString(R.string.forward_weibo));
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
