package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Banner {

    @Expose
    @SerializedName("errno")
    private String error;

    @Expose
    @SerializedName("errmsg")
    private String errmsg;

    @Expose
    @SerializedName("banner")
    private List<Item> mBanners;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<Item> getBanners() {
        return mBanners;
    }

    public void setBanners(List<Item> mBanners) {
        this.mBanners = mBanners;
    }

    public static class Item {
        @Expose
        @SerializedName("ad_position_id")
        private int adPositionId;

        @Expose
        @SerializedName("id")
        private int ID;

        @Expose
        @SerializedName("link")
        private String mLink;

        @Expose
        @SerializedName("image_url")
        private String mImageUrl;

        @Expose
        @SerializedName("content")
        private String mContent;

        @Expose
        @SerializedName("name")
        private String mName;

        @Expose
        @SerializedName("media_type")
        private int mMediaType;

        @Expose
        @SerializedName("end_time")
        private int mEndTime;

        @Expose
        @SerializedName("enabled")
        private int Enanbled;

        public int getAdPositionId() {
            return adPositionId;
        }

        public void setAdPositionId(int adPositionId) {
            this.adPositionId = adPositionId;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getLink() {
            return mLink;
        }

        public void setLink(String mLink) {
            this.mLink = mLink;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public void setImageUrl(String mImageUrl) {
            this.mImageUrl = mImageUrl;
        }

        public String getContent() {
            return mContent;
        }

        public void setContent(String mContent) {
            this.mContent = mContent;
        }

        public String getName() {
            return mName;
        }

        public void setName(String mName) {
            this.mName = mName;
        }

        public int getMediaType() {
            return mMediaType;
        }

        public void setMediaType(int mMediaType) {
            this.mMediaType = mMediaType;
        }

        public int getEndTime() {
            return mEndTime;
        }

        public void setEndTime(int mEndTime) {
            this.mEndTime = mEndTime;
        }

        public int getEnanbled() {
            return Enanbled;
        }

        public void setEnanbled(int enanbled) {
            Enanbled = enanbled;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Item) {
                Item o = (Item) obj;
                return o.getID() == this.ID;
            }
            return false;
        }
    }
}
