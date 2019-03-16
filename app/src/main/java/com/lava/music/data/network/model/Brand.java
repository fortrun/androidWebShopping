package com.lava.music.data.network.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand {

    @Expose
    @SerializedName("id")
    private int ID;

    @Expose
    @SerializedName("name")
    private String mName;

    @Expose
    @SerializedName("list_pic_url")
    private String list_pic_url;

    @Expose
    @SerializedName("simple_desc")
    private String mSimpleDesc;

    @Expose
    @SerializedName("pic_url")
    private String pic_url;

    @Expose
    @SerializedName("sort_order")
    private int sort_order;

    @Expose
    @SerializedName("is_show")
    private int is_show;

    @Expose
    @SerializedName("floor_price")
    private float floor_price;

    @Expose
    @SerializedName("app_list_pic_url")
    private String app_list_pic_url;

    @Expose
    @SerializedName("is_new")
    private int is_new;

    @Expose
    @SerializedName("new_pic_url")
    private String new_pic_url;

    @Expose
    @SerializedName("new_sort_order")
    private int new_sort_order;

    public int getID() {
        return ID;
    }

    public String getName() {
        return mName;
    }

    public String getSimpleDesc() {
        return mSimpleDesc;
    }

    public String getPic_url() {
        return pic_url;
    }

    public int getSort_order() {
        return sort_order;
    }

    public int getIs_show() {
        return is_show;
    }

    public float getFloor_price() {
        return floor_price;
    }

    public String getApp_list_pic_url() {
        return app_list_pic_url;
    }

    public String getNew_pic_url() {
        return new_pic_url;
    }

    public int getNew_sort_order() {
        return new_sort_order;
    }
}
