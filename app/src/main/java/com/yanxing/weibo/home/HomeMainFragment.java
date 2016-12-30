package com.yanxing.weibo.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
 * 列表中没有显示微博图片，有含有图片标志，考虑如下：微博更像个媒体社交，不想朋友圈、instagram，信息流很多，
 * 更多的是获取感兴趣的信息，微博含有的图片并不全是必要的， 用户浏览微博时，觉得文字信息感兴趣，才停下来去看，
 * 点击即可进行详情查看，这时会显示图片，后期做到分组下的好友圈时，默认显示微博图片
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
                TextView weiboText = (TextView) holder.findViewById(R.id.text);
                weiboText.setText(WeiboTextUtil.formatWeiboText(getActivity(), mWeiboList.get(position).getText(), weiboText));
                holder.setText(R.id.attitudesCount, String.valueOf(mWeiboList.get(position).getAttitudes_count()));
                holder.setText(R.id.commentCount, String.valueOf(mWeiboList.get(position).getComments_count()));
                holder.setText(R.id.repostCount, String.valueOf(mWeiboList.get(position).getReposts_count()));
                holder.setText(R.id.time, TimeUtil.getTimeAgo(TimeUtil.format(mWeiboList.get(position).getCreated_at())));
                TextView location= (TextView) holder.findViewById(R.id.address);
                if (mWeiboList.get(position).getLocation()!=null){
                    location.setVisibility(View.VISIBLE);
                    location.setText(mWeiboList.get(position).getLocation());
                }else {
                    location.setVisibility(View.GONE);
                }
                //该微博为转发微博
                if (mWeiboList.get(position).getRetweeted_status() != null) {
                    TextView atWeibo = (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.VISIBLE);
                    String content = "@" + mWeiboList.get(position).getRetweeted_status().getUser().getName() + " :" +
                            mWeiboList.get(position).getRetweeted_status().getText();
                    atWeibo.setText(WeiboTextUtil.formatWeiboText(getActivity(), content, atWeibo));
                    //微博显示是否有图片策略：此微博是转发微博，原微博有图片，才标记此条微博有图片，无论转发时是否添加了图片
                    //此微博不是转发微博，有图片就显示此条微博含有图片，这里和微博显示一样
                    List<?> list = mWeiboList.get(position).getRetweeted_status().getPic_urls();
                    if (list != null && list.size() > 0) {
                        ImageView imageView = (ImageView) holder.findViewById(R.id.hasImage);
                        imageView.setVisibility(View.VISIBLE);
                    }
                } else {
                    TextView atWeibo = (TextView) holder.findViewById(R.id.textChild);
                    atWeibo.setVisibility(View.GONE);
                    List<?> list = mWeiboList.get(position).getPic_urls();
                    if (list != null && list.size() > 0) {
                        ImageView imageView = (ImageView) holder.findViewById(R.id.hasImage);
                        imageView.setVisibility(View.VISIBLE);
                    }
                }

                //点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getActivity(),WeiboDetailActivity.class);
                        Bundle bundle=new Bundle();
//                        bundle.putParcelable("weibo",mWeiboList.get(position));
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
            mWeiboList.addAll(friendTimeLine.getStatuses());
            mRecyclerView.setAdapter(mRecyclerViewAdapter);
        } else {
            mWeiboList.addAll(friendTimeLine.getStatuses());
            mRecyclerViewAdapter.update(mWeiboList);
        }
        mPtrFrameLayout.refreshComplete();
        mPresenter.getGeoToAddress(mWeiboList);
    }

    @Override
    public void upateNotifyItemChanged(int position) {
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
    public <T> Observable.Transformer<T, T> rxLifecycle() {
        return this.bindToLifecycle();
    }

}
