package com.yanxing.weibo.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseActivity;
import com.yanxing.weibo.util.RecyclerViewUtil;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.weiboapi.ConstantAPI;
import com.yanxing.weibo.weiboapi.model.FriendTimeLine;
import com.yanxing.weibo.weiboapi.model.WeiboComment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * 微博正文
 * Created by lishuangxiang on 2016/12/29.
 */
public class WeiboDetailActivity extends BaseActivity<WeiboDetailView, WeiboDetailPresenter>
        implements WeiboDetailView {

    @BindView(R.id.simple_drawee_view)
    SimpleDraweeView mHead;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.time)
    TextView mTime;

    @BindView(R.id.weibo)
    TextView mWeibo;

    @BindView(R.id.atWeibo)
    TextView mAtWeibo;

    @BindView(R.id.image)
    RecyclerView mImageRecyclerView;

    @BindView(R.id.comment)
    RecyclerView mComment;

    @BindView(R.id.attitudesCount)
    TextView mAttitudesCount;

    @BindView(R.id.commentCount)
    TextView mCommentCount;

    @BindView(R.id.repostCount)
    TextView mRepostCount;

    private RecyclerViewAdapter<String> mRecyclerViewImageAdapter;
    private RecyclerView.LayoutParams mParams;
    private RecyclerViewAdapter<WeiboComment.CommentsBean> mRecyclerViewCommentAdapter;
    private List<WeiboComment.CommentsBean> mWeiboCommentList = new ArrayList<>();
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
        return R.layout.activity_weibo_detail;
    }

    @Override
    protected void afterInstanceView() {
        Bundle bundle = getIntent().getExtras();
        FriendTimeLine.StatusesBean weibo = bundle.getParcelable("weibo");
        mHead.setImageURI(Uri.parse(weibo.getUser().getAvatar_large()));
        mName.setText(weibo.getUser().getName());
        mTime.setText(TimeUtil.getTimeDetail(TimeUtil.format(weibo.getCreated_at())));
        mWeibo.setText(WeiboTextUtil.formatWeiboText(this, weibo.getText(), mWeibo));
        mAttitudesCount.setText(weibo.getAttitudes_count() + getString(R.string.praise));
        mCommentCount.setText(weibo.getComments_count() + getString(R.string.comment));
        mRepostCount.setText(weibo.getReposts_count() + getString(R.string.repost));
        //该微博为转发微博
        if (weibo.getRetweeted_status() != null) {
            mAtWeibo.setVisibility(View.VISIBLE);
            String content = "@" + weibo.getRetweeted_status().getUser().getName() + " :" +
                    weibo.getRetweeted_status().getText();
            mAtWeibo.setText(WeiboTextUtil.formatWeiboText(this, content, mAtWeibo));
        }
        showImage(weibo);
        loadComments(weibo.getId());
    }

    /**
     * 显示用户上传的图片，如果有的话
     */
    public void showImage(final FriendTimeLine.StatusesBean statusesBean) {
        final List<String> imageList = new ArrayList<>();
        //如果是转发微博，因api限制只能获取到原微博的图片（如果有图片）
        if (statusesBean.getRetweeted_status() != null) {
            final FriendTimeLine.StatusesBean.RetweetedStatusBean repost = statusesBean.getRetweeted_status();
            List<FriendTimeLine.StatusesBean.RetweetedStatusBean.PicUrlsBean> picUrls = repost.getPic_urls();
            if (picUrls != null) {//有图片
                for (int i = 0; i < picUrls.size(); i++) {
                    imageList.add(picUrls.get(i).getThumbnail_pic());
                }
            }
        } else {
            if (statusesBean.getPic_urls() != null) {
                for (int i = 0; i < statusesBean.getPic_urls().size(); i++) {
                    imageList.add(statusesBean.getPic_urls().get(i).getThumbnail_pic());
                }
            }
        }
        int layout = R.layout.adapter_weibo_detail;
        if (imageList.size() == 1) {
            mParams = new RecyclerView.LayoutParams
                    (RecyclerView.LayoutParams.MATCH_PARENT, 800);
        } else if (imageList.size() == 2) {
            mParams = new RecyclerView.LayoutParams
                    (RecyclerView.LayoutParams.MATCH_PARENT, 460);
        } else if (imageList.size() == 4) {
            mParams = new RecyclerView.LayoutParams
                    (RecyclerView.LayoutParams.MATCH_PARENT, 420);
        } else {
            mParams = new RecyclerView.LayoutParams
                    (RecyclerView.LayoutParams.MATCH_PARENT, 340);
        }

        mRecyclerViewImageAdapter = new RecyclerViewAdapter<String>(imageList, layout) {
            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, final int position) {
                final SimpleDraweeView image = (SimpleDraweeView) holder.findViewById(R.id.simple_drawee_view);
                image.setLayoutParams(mParams);
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        //先加载缩略图，再加载中等图
                        .setLowResImageRequest(ImageRequest.fromUri(imageList.get(position)))
                        .setImageRequest(ImageRequest.fromUri(imageList.get(position)
                                .replaceAll(ConstantAPI.THUMBNAIL_PIC, ConstantAPI.BMIDDLE_PIC)))
                        .setOldController(image.getController())
                        .setAutoPlayAnimations(true)
                        .build();
                image.setController(controller);

            }
        };
        //微博最多有9张图片
        int count = 1;
        if (imageList.size() == 2 | imageList.size() == 4
                | imageList.size() == 5 | imageList.size() == 6) {
            count = 2;
        } else if (imageList.size() == 3 | imageList.size() == 7
                | imageList.size() == 8 | imageList.size() == 9) {
            count = 3;
        }
        mImageRecyclerView.setLayoutManager(new GridLayoutManager(this, count));
        mImageRecyclerView.setAdapter(mRecyclerViewImageAdapter);
    }


    /**
     * 加载评论列表
     */
    public void loadComments(final long weiboID) {
        mRecyclerViewCommentAdapter = new RecyclerViewAdapter<WeiboComment.CommentsBean>(mWeiboCommentList
                , R.layout.adapter_weibo_detail_comment) {
            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
                SimpleDraweeView head = (SimpleDraweeView) holder.findViewById(R.id.simple_drawee_view);
                head.setImageURI(Uri.parse(mWeiboCommentList.get(position).getUser().getAvatar_hd()));
                holder.setText(R.id.name, mWeiboCommentList.get(position).getUser().getName());
                holder.setText(R.id.time, TimeUtil.getTimeDetail(TimeUtil.format(mWeiboCommentList.get(position).getCreated_at())));
                TextView comment = (TextView) holder.findViewById(R.id.comment);
                comment.setText(WeiboTextUtil.formatWeiboText(getApplicationContext(), mWeiboCommentList.get(position).getText(), comment));
            }
        };
        mComment.setLayoutManager(new LinearLayoutManager(this));
        mComment.setAdapter(mRecyclerViewCommentAdapter);
        mPresenter.getWeiboCommentList(weiboID, mCurrentPage, 50);
        mPullDownFresh = true;
        mComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerViewUtil.isCanRefresh(mComment) && mPullUpFresh) {
                    mPullUpFresh = false;
                    mPullDownFresh = false;
                    mPresenter.getWeiboCommentList(weiboID, ++mCurrentPage, 50);
                }
            }
        });
    }

    @Override
    protected WeiboDetailPresenter initPresenter() {
        return new WeiboDetailPresenter(this, getApplicationContext());
    }

    @OnClick({R.id.simple_drawee_view, R.id.atWeibo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_drawee_view:

                break;
            case R.id.atWeibo:
                break;
        }
    }

    /**
     * 设置评论列表
     */
    @Override
    public void setData(WeiboComment weiboComment) {
        WeiboComment.StatusBean statusBean=weiboComment.getStatus();
        mAttitudesCount.setText(statusBean.getAttitudes_count() + getString(R.string.praise));
        mCommentCount.setText(statusBean.getComments_count() + getString(R.string.comment));
        mRepostCount.setText(statusBean.getReposts_count() + getString(R.string.repost));
        if (weiboComment == null) {
            return;
        }
        mPullUpFresh = true;
        if (mPullDownFresh) {
            mWeiboCommentList.clear();
        }
        mWeiboCommentList.addAll(weiboComment.getComments());
        mRecyclerViewCommentAdapter.update(mWeiboCommentList);
    }

    @Override
    public void setError(String error) {
        showToast(error);
    }

    @Override
    public <T> Observable.Transformer<T, T> rxLifecycle() {
        return this.bindToLifecycle();
    }
}
