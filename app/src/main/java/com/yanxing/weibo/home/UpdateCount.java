package com.yanxing.weibo.home;

/**
 * Created by lishuangxiang on 2017/2/16.
 */
public class UpdateCount {

    private int index;
    private long attitudesCount;
    private long commentsCount;
    private long repostsCount;

    public UpdateCount(int index,long attitudesCount, long repostsCount, long commentsCount) {
        this.index=index;
        this.attitudesCount = attitudesCount;
        this.repostsCount = repostsCount;
        this.commentsCount = commentsCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(long attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public long getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(long repostsCount) {
        this.repostsCount = repostsCount;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }
}
