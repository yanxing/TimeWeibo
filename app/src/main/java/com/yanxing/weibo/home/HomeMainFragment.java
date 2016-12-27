package com.yanxing.weibo.home;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.util.LogUtil;
import com.yanxing.weibo.util.RecyclerViewUtil;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;

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
    /**
     * 标志可以进行下拉刷新
     */
    private boolean mPullUpFresh=false;
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
                SimpleDraweeView head = (SimpleDraweeView) holder.findViewById(R.id.simple_drawee_view);
                head.setImageURI(Uri.parse(mWeiboList.get(position).getUser().getAvatar_large()));
                holder.setText(R.id.text, mWeiboList.get(position).getText());
                TextView weiboText= (TextView) holder.findViewById(R.id.text);
                weiboText.setText(WeiboTextUtil.formatWeiboText(getActivity(),mWeiboList.get(position).getText(),weiboText));
                holder.setText(R.id.attitudesCount, String.valueOf(mWeiboList.get(position).getAttitudes_count()));
                holder.setText(R.id.commentCount, String.valueOf(mWeiboList.get(position).getComments_count()));
                holder.setText(R.id.repostCount, String.valueOf(mWeiboList.get(position).getReposts_count()));
                holder.setText(R.id.time, TimeUtil.getTimeAgo(TimeUtil.format(mWeiboList.get(position).getCreated_at())));
                //该微博为转发微博
                if (mWeiboList.get(position).getRetweeted_status()!=null){
                    TextView atWeibo= (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.VISIBLE);
                    String content="@"+mWeiboList.get(position).getRetweeted_status().getUser().getName()+" :"+
                            mWeiboList.get(position).getRetweeted_status().getText();
                    atWeibo.setText(WeiboTextUtil.formatWeiboText(getActivity(),content,atWeibo));
                }
                //点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
            }
        };
        //先加载本地缓存数据
        mPresenter.getFollowWeiboList(mCurrentPage, 10, true);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        //下拉刷新
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPullDownFresh = true;
                mPresenter.getFollowWeiboList(mCurrentPage, 10);
            }
        });
        //上拉刷新
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerViewUtil.isSlideToBottom(mRecyclerView,40)&&mPullUpFresh) {
                    mPullUpFresh=false;
                    mPullDownFresh = false;
                    mPresenter.getFollowWeiboList(++mCurrentPage, 10);
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
        if (friendTimeLine == null) {
            return;
        }
        mPullUpFresh=true;
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
        mPullUpFresh=true;
        mPtrFrameLayout.refreshComplete();
        LogUtil.d(TAG, error);
        showToast(error);
    }

    @Override
    public Observable.Transformer<FriendTimeLine, FriendTimeLine> rxLifecycle() {
        return this.bindToLifecycle();
    }
}
