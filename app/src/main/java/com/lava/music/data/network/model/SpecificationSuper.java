package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecificationSuper {

    @Expose
    @SerializedName("specification_id")
    private int specification_id;

    @Expose
    @SerializedName("name")
    private String name;
}
