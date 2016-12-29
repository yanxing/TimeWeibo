package com.yanxing.adapterlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * RecyclerView适配器抽象类 itemClick和ItemLongClick用ViewHolder.item设置
 * Created by lishuangxiang on 2016/3/23.
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<T> mDataList;
    private int mLayoutID;

    /**
     * @param dataList
     * @param layoutID 布局文件
     */
    public RecyclerViewAdapter(List<T> dataList, int layoutID) {
        this.mLayoutID = layoutID;
        this.mDataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutID, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * 添加指定元素，有动画效果
     *
     * @param position
     * @param data
     */
    public void add(int position, T data) {
        mDataList.add(position, data);
        notifyItemInserted(position);
    }

    /**
     * 移除指定元素，有动画效果
     *
     * @param position
     */
    public void remove(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 更新数据，没有动画效果
     */
    public void update(List<T> dataList) {
        this.mDataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * 更新数据
     */
    public void update(int position) {
        notifyItemChanged(position);
    }

    /**
     * ViewHolder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);
        }

        /**
         * 通过控件的Id获取控件
         *
         * @param viewID
         * @param <T>
         * @return
         */
        public <T extends View> T findViewById(int viewID) {
            View view = itemView.findViewById(viewID);
            return (T) view;
        }

        /**
         * 为TextView设置字符串
         *
         * @param viewId
         * @param text
         * @return
         */
        public void setText(int viewId, CharSequence text) {
            TextView view = findViewById(viewId);
            view.setText(text);
        }
    }
}

