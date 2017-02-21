package com.yanxing.weibo.common;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.titlebarlibrary.TitleBar;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.base.BasePresenter;
import com.yanxing.weibo.home.UpdateCount;
import com.yanxing.weibo.util.CommonUtil;
import com.yanxing.weibo.util.EmotionUtil;
import com.yanxing.weibo.util.ErrorCodeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.weiboapi.model.CreateComment;
import com.yanxing.weibo.weiboapi.model.StatusRepost;
import com.yanxing.weibo.weiboapi.model.StatusesUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * 发评论,发微博,转发微博
 * Created by lishuangxiang on 2017/2/8.
 */
public class SendWeiboActivity extends BaseActivity<SendWeiboView,SendWeiboPresenter> implements
    SendWeiboView{

    @BindView(R.id.titleBar)
    TitleBar mTitleBar;

    @BindView(R.id.comment)
    EditText mComment;

    @BindView(R.id.emotionList)
    RecyclerView mEmotionList;

    private long mWeiboID;
    private boolean mShowEmotion = false;
    private boolean mFirst = true;
    private int mType;
    private String ANNOTATIONS="[{\"source\":\"TimeWeiBo\"}]";;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_send_weibo;
    }

    @Override
    protected void afterInstanceView() {
        EventBus.getDefault().register(this);
        //先隐藏输入法，再停顿200ms关闭当前页，为了防止回到上个界面有一闪空白效果
        mTitleBar.setOnClickBackLayout(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtil.hideInputKeyBoard(getApplicationContext(), mComment);
                Observable.timer(200, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .compose(SendWeiboActivity.this.<Long>bindToLifecycle())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                finish();
                            }
                        });
            }
        });
        setUI();
        mComment.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (mShowEmotion){
                    mEmotionList.setVisibility(View.GONE);
                    mShowEmotion=false;
                }
                return false;
            }
        });
    }

    /**
     * 初始界面
     */
    public void setUI() {
        Intent intent = getIntent();
        mType= intent.getIntExtra("type", 0);
        if (mType == WeiboOperate.SEND_WEIBO.getIntValue()) {//发微博
            mTitleBar.setTitle(getString(R.string.send_weibo));
            mComment.setHint(R.string.share_weibo);
        } else if (mType == WeiboOperate.COMMENT.getIntValue()) {//发评论
            mTitleBar.setTitle(getString(R.string.send_comment1));
            mComment.setHint(R.string.write_comment);
            mWeiboID=intent.getLongExtra("ID",0);
        } else if (mType == WeiboOperate.FORWARD_WEIBO.getIntValue()) {//转发微博
            mTitleBar.setTitle(getString(R.string.forward_weibo));
            mComment.setHint(R.string.forward_weibo_hint);
            mWeiboID=intent.getLongExtra("ID",0);
        }
    }

    @Override
    protected SendWeiboPresenter initPresenter() {
        return new SendWeiboPresenter(this,getApplicationContext());
    }

    @Override
    public void finish() {
        CommonUtil.hideInputKeyBoard(getApplicationContext(),mComment);
        super.finish();
        if (getIntent().getBooleanExtra("anim", false)) {
            overridePendingTransition(R.anim.activity_close, 0);
        }
    }

    @OnClick({R.id.select_image, R.id.at, R.id.topic, R.id.emotion, R.id.send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_image:
                break;
            case R.id.at:
                Intent intent = new Intent(getApplicationContext(), AtUsersActivity.class);
                startActivity(intent);
                break;
            case R.id.topic:
                mComment.setText(WeiboTextUtil.formatWeiboText(getApplicationContext()
                        , mComment.getText().toString() + "##", mComment));
                mComment.setSelection(mComment.getText().toString().length() - 1);
                break;
            case R.id.emotion:
                showEmotion();
                break;
            case R.id.send:
                String comment=mComment.getText().toString().trim();
                if (comment.length()<=140){
                    if (mType == WeiboOperate.SEND_WEIBO.getIntValue()) {//发微博
                        if (comment.isEmpty()){
                            showToast(getString(R.string.no_empty));
                        }else {
                            mPresenter.sendWeibo(comment,0,null,0.0f,0.0f,ANNOTATIONS);
                        }
                    } else if (mType == WeiboOperate.COMMENT.getIntValue()) {//发评论
                        if (comment.isEmpty()){
                            showToast(getString(R.string.no_empty));
                        }else {
                            mPresenter.createComment(mWeiboID,comment,0);
                        }
                    } else if (mType == WeiboOperate.FORWARD_WEIBO.getIntValue()) {//转发微博
                        mPresenter.repostWeibo(mWeiboID,comment,0);
                    }
                }else {
                    showToast(getString(R.string.bu_duo_140));
                }
                break;
        }
    }

    /**
     * 显示表情
     */
    public void showEmotion() {
        if (mShowEmotion) {//隐藏表情
            mEmotionList.setVisibility(View.GONE);
            CommonUtil.showInputKeyboard(getApplicationContext());
            mShowEmotion=false;
        } else {
            if (mFirst) {
                mEmotionList.setLayoutManager(new GridLayoutManager(this, 8));
                final List<Emotion> list = new ArrayList<>();
                for (String key : EmotionUtil.map.keySet()) {
                    Emotion emotion=new Emotion();
                    emotion.setResourceID(EmotionUtil.getImageByName(key));
                    emotion.setText(key);
                    list.add(emotion);
                }
                mEmotionList.setAdapter(new RecyclerViewAdapter<Emotion>(list, R.layout.adapter_emotion) {
                    @Override
                    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {
                        ImageView emotion = (ImageView) holder.findViewById(R.id.emotion);
                        emotion.setImageDrawable(getResources().getDrawable(list.get(position).getResourceID()));
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mComment.setText(WeiboTextUtil.formatWeiboText(getApplicationContext()
                                        , mComment.getText().toString() + list.get(position).getText(), mComment));
                                mComment.setSelection(mComment.getText().toString().length());
                            }
                        });
                    }
                });
                mFirst = false;
            }
            CommonUtil.hideInputKeyBoard(getApplicationContext(), mComment);
            Observable.timer(300,TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(this.<Long>bindToLifecycle())
                    .subscribe(new Action1<Long>() {
                        @Override
                        public void call(Long aLong) {
                            mEmotionList.setVisibility(View.VISIBLE);
                        }
                    });
            mShowEmotion=true;
        }
    }

    public void onEvent(String name) {
        mComment.setText(WeiboTextUtil.formatWeiboText(getApplicationContext(), "@" + name + " ", mComment));
        mComment.setSelection(mComment.getText().toString().length());
        CommonUtil.showInputKeyboard(getApplicationContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setData(CreateComment data) {
        if (data.getError()!=null){
            showToast(ErrorCodeUtil.getErrorCodeTip(data.getError_code(),data.getError()));
        }else {
            if (mType==WeiboOperate.COMMENT.getIntValue()){
                int index=getIntent().getIntExtra("index",-1);
                EventBus.getDefault().post(new UpdateComment(data.getText(),data.getUser().getAvatar_large()
                        ,index,data.getUser().getName(),true,data.getCreated_at()));
                showToast(getString(R.string.comments_success));
                finish();
            }
        }

    }

    @Override
    public void setError(String error) {
        showToast(error);
    }

    @Override
    public <V> Observable.Transformer<V, V> rxLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void setRepostWeibo(StatusRepost statusRepost) {
        if (statusRepost.getError()!=null){
            showToast(ErrorCodeUtil.getErrorCodeTip(statusRepost.getError_code(),statusRepost.getError()));
        }else {
            if (mType==WeiboOperate.FORWARD_WEIBO.getIntValue()){
                int index=getIntent().getIntExtra("index",-1);
                EventBus.getDefault().post(new UpdateRepost(index,true));
                showToast(getString(R.string.repost_success));
                finish();
            }
        }
    }

    @Override
    public void setSendWeibo(StatusesUpdate sendWeibo) {
        if (sendWeibo.getError()!=null){
            showToast(ErrorCodeUtil.getErrorCodeTip(sendWeibo.getError_code(),sendWeibo.getError()));
        }else {
            if (mType==WeiboOperate.SEND_WEIBO.getIntValue()){
                EventBus.getDefault().post("refresh");
                showToast(getString(R.string.send_weibo_success));
                finish();
            }
        }
    }
}
