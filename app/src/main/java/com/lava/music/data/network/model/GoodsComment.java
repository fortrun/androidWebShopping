package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoodsComment {
    @Expose
    @SerializedName("content")
    private String content;

    @Expose
    @SerializedName("add_time")
    private String add_time;

    @Expose
    @SerializedName("pic_list")
    private List<CommentPics> pic_list;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public List<CommentPics> getPic_list() {
        return pic_list;
    }

    public void setPic_list(List<CommentPics> pic_list) {
        this.pic_list = pic_list;
    }
}
