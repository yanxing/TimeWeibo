package com.yanxing.weibo.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.home.WeiboDetailActivity;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;

/**
 * 个人中心,微博流用户详情共用
 * Created by lishuangxiang on 2016/12/22.
 */
public class MeMainFragment extends BaseFragment<MeMainView, MeMainPresenter> implements MeMainView {

    @BindView(R.id.user_bg)
    SimpleDraweeView mUserBg;

    @BindView(R.id.head)
    SimpleDraweeView mHead;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.follow)
    TextView mFollow;

    @BindView(R.id.fans)
    TextView mFans;

    @BindView(R.id.weiBoList)
    RecyclerView mWeiBoList;

    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.ptrFrameLayout)
    PtrClassicFrameLayout mPtrFrameLayout;

    @BindView(R.id.tip)
    TextView mTip;

    @BindView(R.id.back)
    ImageView mBack;

    @BindView(R.id.setting)
    ImageView mSetting;

    private List<FriendTimeLine.StatusesBean> mUserWeiboList = new ArrayList<>();
    private RecyclerViewAdapter<FriendTimeLine.StatusesBean> mRecyclerViewAdapter;
    private int mCurrentPage = 1;
    private int mPageSize = 20;
    private String mUid;
    private String mScreenName=null;
    private boolean mUserDetail=false;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_me_main;
    }

    @Override
    protected void afterInstanceView() {
        Bundle bundle=getArguments();
        mUid=bundle.getString("uid");
        mUserDetail=bundle.getBoolean("userDetail");
        if (mUid==null){
            mScreenName=bundle.getString("screenName");
        }
        mPresenter.getMeInfo(mUid,mScreenName);
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPresenter.getMeInfo(mUid,mScreenName);
                mCurrentPage = 1;
                mPresenter.getMeWeiboList(mUid,mScreenName,mCurrentPage, mPageSize);
            }
        });
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //只有在最顶部才能下拉刷新
                if (verticalOffset!=0){
                    mPtrFrameLayout.setEnabled(false);
                }else {
                    mPtrFrameLayout.setEnabled(true);
                }
            }
        });
        if (mUserDetail){
            mBack.setVisibility(View.VISIBLE);
            mSetting.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.back)
    public void onClick(){
        getActivity().finish();
    }

    @Override
    protected MeMainPresenter initPresenter() {
        return new MeMainPresenter(this, getActivity());
    }

    @Override
    public void setData(User data) {
        if (data==null){
            return;
        }
        if (data.getCover_image_phone()!=null){
            mUserBg.setImageURI(Uri.parse(data.getCover_image_phone()));
        }
        mHead.setImageURI(Uri.parse(data.getAvatar_large()));
        mName.setText(data.getName());
        if (mUserDetail){
            showToast(getString(R.string.api_limit));
            return;
        }
        mFollow.setText(String.valueOf(data.getFriends_count()));
        mFans.setText(String.valueOf(data.getFollowers_count()));
        mWeiBoList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter = new RecyclerViewAdapter<FriendTimeLine.StatusesBean>(mUserWeiboList, R.layout.adapter_me_main) {
            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {
                holder.setText(R.id.name, mDataList.get(position).getUser().getName());
                holder.setText(R.id.text, mDataList.get(position).getText());
                TextView weiboText = (TextView) holder.findViewById(R.id.text);
                weiboText.setText(WeiboTextUtil.formatWeiboText(getActivity(), mDataList.get(position).getText(), weiboText));
                holder.setText(R.id.attitudesCount, String.valueOf(mDataList.get(position).getAttitudes_count()));
                holder.setText(R.id.commentCount, String.valueOf(mDataList.get(position).getComments_count()));
                holder.setText(R.id.repostCount, String.valueOf(mDataList.get(position).getReposts_count()));
                holder.setText(R.id.time, TimeUtil.getTimeDetail(TimeUtil.format(mDataList.get(position).getCreated_at())));
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
                    } else {
                        imageView.setVisibility(View.GONE);
                    }
                } else {
                    TextView atWeibo = (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.GONE);
                    List<?> list = mDataList.get(position).getPic_urls();
                    ImageView imageView = (ImageView) holder.findViewById(R.id.hasImage);
                    if (list != null && list.size() > 0) {
                        imageView.setVisibility(View.VISIBLE);
                    } else {
                        imageView.setVisibility(View.GONE);
                    }
                }
                //Item点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), WeiboDetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("weibo", mDataList.get(position));
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        };
        mWeiBoList.setAdapter(mRecyclerViewAdapter);
        mPresenter.getMeWeiboList(mUid,mScreenName,mCurrentPage, mPageSize);
    }

    @Override
    public void setError(String error) {
        mPtrFrameLayout.refreshComplete();
        showToast(error);
    }

    @Override
    public <V> Observable.Transformer<V, V> rxLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void setUserTimeLine(FriendTimeLine userTimeLine) {
        mPtrFrameLayout.refreshComplete();
        if (userTimeLine == null) {
            return;
        }
        if (userTimeLine.getStatuses() != null && userTimeLine.getStatuses().size() > 0) {
            mUserWeiboList.clear();
            mUserWeiboList.addAll(userTimeLine.getStatuses());
            mRecyclerViewAdapter.update(mUserWeiboList);
            mTip.setVisibility(View.VISIBLE);
        }
    }
}
