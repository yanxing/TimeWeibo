package com.yanxing.weibo.home;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.common.SendWeiboActivity;
import com.yanxing.weibo.common.UpdateComment;
import com.yanxing.weibo.common.UpdateRepost;
import com.yanxing.weibo.common.WeiboOperate;
import com.yanxing.weibo.util.LogUtil;
import com.yanxing.weibo.util.PermissionUtil;
import com.yanxing.weibo.util.RecyclerViewUtil;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.greenrobot.event.EventBus;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;

/**
 * 微博主页，关注人的微博列表
 * 列表中没有显示微博图片，有含有图片标志，考虑如下：微博更像个媒体社交，不想朋友圈、instagram，信息流很多，
 * 更多的是获取感兴趣的信息，微博含有的图片并不全是必要的， 用户浏览微博时，觉得文字信息感兴趣，才停下来去看，
 * 点击即可进行详情查看(显示的是中等图片)，这时会显示图片，后期做到分组下的好友圈时，默认显示微博图片
 * Created by lishuangxiang on 2016/12/22.
 */
public class HomeMainFragment extends BaseFragment<HomeMainView, HomeMainPresenter>
        implements HomeMainView {

    @BindView(R.id.ptrFrameLayout)
    PtrClassicFrameLayout mPtrFrameLayout;

    @BindView(R.id.weiBoList)
    RecyclerView mRecyclerView;

    private RecyclerViewAdapter<FriendTimeLine.StatusesBean> mRecyclerViewAdapter;
    private List<FriendTimeLine.StatusesBean> mWeiboList = new ArrayList<>();

    /**
     * 下拉刷新
     */
    private boolean mPullDownFresh = true;
    /**
     * 标志可以进行下拉刷新
     */
    private boolean mPullUpFresh = false;
    private int mCurrentPage = 1;
    private static final int QUESTION_LOCATION = 1;
    public static final String REFRESH ="refresh";

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected void afterInstanceView() {
        checkPermission();
        EventBus.getDefault().register(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter = new RecyclerViewAdapter<FriendTimeLine.StatusesBean>(mWeiboList,
                R.layout.adapter_home_main) {
            @Override
            public void onBindViewHolder(final RecyclerViewAdapter.MyViewHolder holder, final int position) {
                holder.setText(R.id.name, mDataList.get(position).getUser().getName());
                SimpleDraweeView head = (SimpleDraweeView) holder.findViewById(R.id.simple_drawee_view);
                head.setImageURI(Uri.parse(mDataList.get(position).getUser().getAvatar_large()));
                holder.setText(R.id.text, mDataList.get(position).getText());
                TextView weiboText = (TextView) holder.findViewById(R.id.text);
                weiboText.setText(WeiboTextUtil.formatWeiboText(getActivity(), mDataList.get(position).getText(), weiboText));
                holder.setText(R.id.attitudesCount, String.valueOf(mDataList.get(position).getAttitudes_count()));
                holder.setText(R.id.commentCount, String.valueOf(mDataList.get(position).getComments_count()));
                holder.setText(R.id.repostCount, String.valueOf(mDataList.get(position).getReposts_count()));
                holder.setText(R.id.time, TimeUtil.getTimeAgo(TimeUtil.format(mDataList.get(position).getCreated_at())));
                TextView location= (TextView) holder.findViewById(R.id.address);
                if (mDataList.get(position).getLocation()!=null){
                    location.setVisibility(View.VISIBLE);
                    location.setText(mDataList.get(position).getLocation());
                }else {
                    location.setVisibility(View.GONE);
                }
                //该微博为转发微博
                if (mDataList.get(position).getRetweeted_status() != null) {
                    TextView atWeibo = (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.VISIBLE);
                    String content = "@" + mDataList.get(position).getRetweeted_status().getUser().getName() + " :" +
                            mDataList.get(position).getRetweeted_status().getText();
                    atWeibo.setText(WeiboTextUtil.formatWeiboText(getActivity(), content, atWeibo));
                    //微博显示是否有图片策略：此微博是转发微博，原微博有图片，才标记此条微博有图片，无论转发时是否添加了图片
                    //此微博不是转发微博，有图片就显示此条微博含有图片，这里和微博显示一样
                    List<?> list = mDataList.get(position).getRetweeted_status().getPic_urls();
                    ImageView imageView = (ImageView) holder.findViewById(R.id.hasImage);
                    if (list != null && list.size() > 0) {
                        imageView.setVisibility(View.VISIBLE);
                    }else {
                        imageView.setVisibility(View.GONE);
                    }
                } else {
                    TextView atWeibo = (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.GONE);
                    List<?> list = mDataList.get(position).getPic_urls();
                    ImageView imageView = (ImageView) holder.findViewById(R.id.hasImage);
                    if (list != null && list.size() > 0) {
                        imageView.setVisibility(View.VISIBLE);
                    }else {
                        imageView.setVisibility(View.GONE);
                    }
                }

                //Item点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getActivity(),WeiboDetailActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putParcelable("weibo",mDataList.get(position));
                        intent.putExtra("index",position);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
                //点赞
                ImageView imageView= (ImageView) holder.findViewById(R.id.praise);
                if (mDataList.get(position).getIsAttitudes()==0){//当前用户没有被赞
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.praise));
                }else{
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.praised));
                }
                holder.findViewById(R.id.praise_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView imageView= (ImageView) holder.findViewById(R.id.praise);
                        startAnimator(imageView,position);
                    }
                });
                //评论
                holder.findViewById(R.id.comment_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(), SendWeiboActivity.class);
                        intent.putExtra("ID",mDataList.get(position).getId());
                        intent.putExtra("index",position);
                        intent.putExtra("type", WeiboOperate.COMMENT.getIntValue());
                        startActivity(intent);
                    }
                });
                //转发
                holder.findViewById(R.id.forward_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(), SendWeiboActivity.class);
                        intent.putExtra("ID",mDataList.get(position).getId());
                        intent.putExtra("index",position);
                        intent.putExtra("type",WeiboOperate.FORWARD_WEIBO.getIntValue());
                        startActivity(intent);
                    }
                });
                //用户详情
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getActivity(),UserDetailActivity.class);
                        intent.putExtra("uid",String.valueOf(mDataList.get(position).getUser().getId()));
                        startActivity(intent);
                    }
                });
            }
        };
        //先加载本地缓存数据
        mPresenter.getFollowWeiboList(mCurrentPage, 20, true);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        //下拉刷新
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPullDownFresh = true;
                mCurrentPage=1;
                mPresenter.getFollowWeiboList(mCurrentPage, 20);
            }
        });
        //上拉刷新
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerViewUtil.isCanRefresh(mRecyclerView) && mPullUpFresh) {
                    mPullUpFresh = false;
                    mPullDownFresh = false;
                    mPresenter.getFollowWeiboList(++mCurrentPage, 20);
                }
            }
        });
        mPtrFrameLayout.autoRefresh(true);
    }

    /**
     * 缩放动画
     *
     * @param target
     * @return
     */
    public void startAnimator(ImageView target,int position) {
        if (mWeiboList.get(position).getIsAttitudes()==0){//未被登录用户赞
            target.setImageDrawable(getResources().getDrawable(R.mipmap.praised));
        }else {
            target.setImageDrawable(getResources().getDrawable(R.mipmap.praise));
        }
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(target, View.SCALE_X, 1.0f, 1.6f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(target, View.SCALE_Y, 1.0f, 1.6f);

        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(target, View.SCALE_X, 1.6f, 1.0f);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(target, View.SCALE_Y, 1.6f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(scaleX, scaleY,scaleX1,scaleY1);
        animatorSet.setTarget(target);
        animatorSet.start();
        animatorSet.addListener(new AnimEndListener(position));
    }

    private class AnimEndListener extends AnimatorListenerAdapter {

        private int mPosition;

        public AnimEndListener(int position) {
            mPosition=position;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            if (mWeiboList.get(mPosition).getIsAttitudes()==0){//未被登录用户赞
                mWeiboList.get(mPosition).setIsAttitudes(1);//当前微博被登录用户赞
                mWeiboList.get(mPosition).setAttitudes_count(mWeiboList.get(mPosition).getAttitudes_count()+1);
            }else {
                mWeiboList.get(mPosition).setIsAttitudes(0);//当前微博被登录用户赞
                mWeiboList.get(mPosition).setAttitudes_count(mWeiboList.get(mPosition).getAttitudes_count()-1);
            }
            mRecyclerViewAdapter.update(mWeiboList);
        }
    }

    /**
     * 检查并申请写入权限
     */
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionUtil.checkSelfPermission(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                    , Manifest.permission.READ_EXTERNAL_STORAGE}, QUESTION_LOCATION);
        }
    }

    @Override
    protected HomeMainPresenter initPresenter() {
        return new HomeMainPresenter(this, getActivity());
    }

    @Override
    public void setData(FriendTimeLine friendTimeLine) {
        if (friendTimeLine == null) {
            return;
        }
        mPullUpFresh = true;
        if (mPullDownFresh) {
            mWeiboList.clear();
        }
        if (friendTimeLine.getStatuses()!=null&&friendTimeLine.getStatuses().size()>0){
            mWeiboList.addAll(friendTimeLine.getStatuses());
            mRecyclerViewAdapter.update(mWeiboList);
            mPresenter.getGeoToAddress(mWeiboList);
        }
        mPtrFrameLayout.refreshComplete();

    }

    @Override
    public void updateNotifyItemChanged(int position) {
        mRecyclerViewAdapter.update(position);
    }


    @Override
    public void setError(String error) {
        mPullUpFresh = true;
        mPtrFrameLayout.refreshComplete();
        LogUtil.d(TAG, error);
        showToast(error);
    }

    @Override
    public <V> Observable.Transformer<V, V> rxLifecycle() {
        return this.bindToLifecycle();
    }

    public void onEvent(View view){
        showToast(view.toString());
    }

    public void onEvent(UpdateComment updateComment){
        if (updateComment.isSuccess()){
            FriendTimeLine.StatusesBean statusesBean=mWeiboList.get(updateComment.getIndex());
            statusesBean.setComments_count(statusesBean.getComments_count()+1);
            mRecyclerViewAdapter.update(mWeiboList);
        }
    }

    public void onEvent(UpdateCount updateCount){
        FriendTimeLine.StatusesBean statusesBean=mWeiboList.get(updateCount.getIndex());
        statusesBean.setAttitudes_count(updateCount.getAttitudesCount());
        statusesBean.setComments_count(updateCount.getCommentsCount());
        statusesBean.setReposts_count(updateCount.getRepostsCount());
        mRecyclerViewAdapter.update(mWeiboList);
    }

    public void onEvent(UpdateRepost updateRepost){
        if (updateRepost.isSuccess()){
            FriendTimeLine.StatusesBean statusesBean=mWeiboList.get(updateRepost.getIndex());
            statusesBean.setComments_count(statusesBean.getReposts_count()+1);
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
            mPtrFrameLayout.autoRefresh(true);
        }
    }

    public void onEvent(String event){
        if (event.equals(REFRESH)){
            mRecyclerView.setAdapter(mRecyclerViewAdapter);//回到顶部
            mPtrFrameLayout.autoRefresh(true);
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions
            , @NonNull int[] grantResults) {
        if (requestCode == QUESTION_LOCATION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                for (String permission : permissions) {
                    PermissionUtil.getPermissionTip(permission);
                }
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
