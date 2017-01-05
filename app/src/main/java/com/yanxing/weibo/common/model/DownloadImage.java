package com.yanxing.weibo.common.model;

/**
 * Created by lishuangxiang on 2017/1/5.
 */
public class DownloadImage {

    private boolean download;

    public DownloadImage(boolean download) {
        this.download = download;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }
}
