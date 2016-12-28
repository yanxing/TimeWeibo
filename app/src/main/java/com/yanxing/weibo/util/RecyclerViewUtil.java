package com.yanxing.weibo.util;

import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView是否滑动到了底部工具类
 * Created by 李双祥 on 2016/12/24.
 */
public class RecyclerViewUtil {

    /**
     * RecyclerView是否滑动到了底部
     *
     * @param recyclerView
     * @return
     */
    public static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return false;
        }
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }

    /**
     * RecyclerView是否可以刷新，用于上拉到接近底部时预加载数据
     *
     * @param recyclerView
     * @return
     */
    public static boolean isCanRefresh(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return false;
        }
        int e=recyclerView.computeVerticalScrollExtent();
        int o=recyclerView.computeVerticalScrollOffset();
        int r=recyclerView.computeVerticalScrollRange();
        if ((e+o)*1.0/r>0.7){
            return true;
        }
        return false;
    }
}
