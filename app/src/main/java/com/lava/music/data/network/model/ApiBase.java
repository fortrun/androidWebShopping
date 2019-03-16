package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class ApiBase {

    @Expose
    @SerializedName("id")
    int id = -1;

    @Expose
    @SerializedName("name")
    String name = "";

    abstract void setName(String n);

    abstract String getName();

    abstract void setId(int id);
    abstract int getId();
}
