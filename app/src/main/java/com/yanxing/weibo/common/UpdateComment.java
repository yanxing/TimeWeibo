package com.yanxing.weibo.common;

/**
 * Created by lishuangxiang on 2017/2/16.
 */
public class UpdateComment {

    private int index;
    private boolean success;
    private String name;
    private String time;
    private String headPic;
    private String content;

    public UpdateComment(String content, String headPic, int index, String name, boolean success, String time) {
        this.content = content;
        this.headPic = headPic;
        this.index = index;
        this.name = name;
        this.success = success;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
