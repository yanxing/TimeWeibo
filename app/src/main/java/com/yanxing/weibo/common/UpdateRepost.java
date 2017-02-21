package com.yanxing.weibo.common;

/**
 * Created by lishuangxiang on 2017/2/21.
 */
public class UpdateRepost {

    private boolean success;
    private int index;

    public UpdateRepost(int index, boolean success) {
        this.index = index;
        this.success = success;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
