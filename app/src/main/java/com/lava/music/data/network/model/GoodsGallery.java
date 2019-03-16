package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoodsGallery {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("goods_id")
    private int goods_id;

    @Expose
    @SerializedName("img_url")
    private String img_url;

    @Expose
    @SerializedName("img_desc")
    private int img_desc;

    @Expose
    @SerializedName("sort_order")
    private int sort_order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getImg_desc() {
        return img_desc;
    }

    public void setImg_desc(int img_desc) {
        this.img_desc = img_desc;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }
}
