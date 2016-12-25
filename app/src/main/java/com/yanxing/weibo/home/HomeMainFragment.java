package com.yanxing.weibo.home;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.util.LogUtil;
import com.yanxing.weibo.util.RecyclerViewUtil;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * 微博主页，关注人的微博列表
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
    private int mCurrentPage = 1;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_home_main;
    }

    @Override
    protected void afterInstanceView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewAdapter = new RecyclerViewAdapter<FriendTimeLine.StatusesBean>(mWeiboList,
                R.layout.adapter_home_main) {
            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {
                holder.setText(R.id.name, mWeiboList.get(position).getUser().getName());
                SimpleDraweeView head= (SimpleDraweeView) holder.findViewById(R.id.simple_drawee_view);
                head.setImageURI(Uri.parse(mWeiboList.get(position).getUser().getAvatar_large()));
                holder.setText(R.id.text,mWeiboList.get(position).getText());
                holder.setText(R.id.attitudesCount,String.valueOf(mWeiboList.get(position).getAttitudes_count()));
                holder.setText(R.id.commentCount,String.valueOf(mWeiboList.get(position).getComments_count()));
                holder.setText(R.id.repostCount,String.valueOf(mWeiboList.get(position).getReposts_count()));
                holder.setText(R.id.time, TimeUtil.getTimeAgo(TimeUtil.format(mWeiboList.get(position).getCreated_at())));
                //点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }
        };
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        //下拉刷新
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPullDownFresh = true;
                //mPresenter.loadTestData(getActivity());
                mPresenter.getFollowWeiboList(mCurrentPage,10, getActivity());
            }
        });
        //上拉刷新
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerViewUtil.isSlideToBottom(mRecyclerView)) {
                    mPullDownFresh = false;
                    mPresenter.getFollowWeiboList(++mCurrentPage, 10,getActivity());
                }
            }
        });
        mPtrFrameLayout.autoRefresh(true);
    }

    @Override
    protected HomeMainPresenter initPresenter() {
        return new HomeMainPresenter(this, getActivity());
    }

    @Override
    public void setData(FriendTimeLine friendTimeLine) {
        if (mPullDownFresh) {
            mWeiboList.clear();
            mWeiboList.addAll(friendTimeLine.getStatuses());
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
        } else {
            mWeiboList.addAll(friendTimeLine.getStatuses());
            mRecyclerViewAdapter.update(mWeiboList);
        }
        mPtrFrameLayout.refreshComplete();
    }

    @Override
    public void setError(String error) {
        mPtrFrameLayout.refreshComplete();
        LogUtil.d(TAG,error);
        showToast(error);
    }
}
