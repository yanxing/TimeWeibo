package com.yanxing.weibo.message;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yanxing.adapterlibrary.RecyclerViewAdapter;
import com.yanxing.weibo.R;
import com.yanxing.weibo.base.BaseFragment;
import com.yanxing.weibo.util.TimeUtil;
import com.yanxing.weibo.util.WeiboTextUtil;
import com.yanxing.weibo.view.CustomLinearLayoutManager;
import com.yanxing.weibo.weiboapi.model.Comment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;

/**
 * 消息主界面，私信、@我、评论
 * Created by lishuangxiang on 2016/12/22.
 */
public class MessageMainFragment extends BaseFragment<MessageView,MessagePresenter>
    implements MessageView{

    @BindView(R.id.commentList)
    RecyclerView mCommentList;

    @BindView(R.id.commentTip)
    TextView mCommentTip;

    @BindView(R.id.allComment)
    View mAllComment;

    @BindView(R.id.ptrFrameLayout)
    PtrClassicFrameLayout mPtrClassicFrameLayout;

    private RecyclerViewAdapter<Comment.CommentsBean> mRecyclerViewAdapter;
    private List<Comment.CommentsBean> mComments=new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_message_main;
    }

    @Override
    protected void afterInstanceView() {
        CustomLinearLayoutManager layoutManage=new CustomLinearLayoutManager(getActivity());
        layoutManage.setScrollEnable(false);
        mCommentList.setLayoutManager(layoutManage);
        mRecyclerViewAdapter=new RecyclerViewAdapter<Comment.CommentsBean>(mComments
                ,R.layout.adapter_message_main) {
            @Override
            public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
                holder.setText(R.id.name,mComments.get(position).getUser().getName());
                holder.setText(R.id.time,
                        TimeUtil.getTimeDetail(TimeUtil.format(mComments.get(position).getCreated_at())));
                SimpleDraweeView head = (SimpleDraweeView) holder.findViewById(R.id.head);
                head.setImageURI(Uri.parse(mComments.get(position).getUser().getProfile_image_url()));
                TextView comment = (TextView) holder.findViewById(R.id.comment);
                comment.setText(WeiboTextUtil.formatWeiboText(getActivity()
                        , mComments.get(position).getText(), comment));
            }
        };
        mCommentList.setAdapter(mRecyclerViewAdapter);
        mPtrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPresenter.getComments(1,6);
            }
        });
        mPtrClassicFrameLayout.autoRefresh(true);
    }

    @Override
    protected MessagePresenter initPresenter() {
        return new MessagePresenter(this,getActivity());
    }

    @Override
    public void setData(Comment data) {
        mPtrClassicFrameLayout.refreshComplete();
        if (data!=null&&data.getComments()!=null&&data.getComments().size()>0){
            mComments.clear();
            mComments.addAll(data.getComments());
            mCommentTip.setVisibility(View.VISIBLE);
            mRecyclerViewAdapter.update(mComments);
            mAllComment.setVisibility(View.VISIBLE);
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
}
