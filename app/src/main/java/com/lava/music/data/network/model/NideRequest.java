package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NideRequest {

    private NideRequest(){

    }

    public static class GoodsRequest{

        @Expose
        @SerializedName("id")
        private String Id;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public GoodsRequest(String id) {
            Id = id;
        }
    }
}
