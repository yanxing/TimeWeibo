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
}
