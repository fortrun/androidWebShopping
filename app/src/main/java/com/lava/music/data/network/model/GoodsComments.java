package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoodsComments {

    @Expose
    @SerializedName("count")
    private int count;


    @Expose
    @SerializedName("data")
    private GoodsComment data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GoodsComment getData() {
        return data;
    }

    public void setData(GoodsComment data) {
        this.data = data;
    }
}
