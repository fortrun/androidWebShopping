package com.lava.music.data.network.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Banner extends NideResponse{

    public DataItems getDataItems() {
        return mDataItems;
    }

    public void setDataItems(DataItems dataItems) {
        this.mDataItems = dataItems;
    }

    @Expose
    @SerializedName("data")
    private DataItems mDataItems;

    public static class DataItems {

        public List<Item> getBanners() {
            Collections.sort(mBanners);
            return mBanners;
        }

        public List<Channel> getChannels() {
            return mChannels;
        }

        public List<NewGoods> getNewGoodsList() {
            return mNewGoodsList;
        }

        public List<NewGoods> getHotGoodsList() {
            return mHotGoodsList;
        }

        public List<Brand> getBrandList() {
            return mBrandList;
        }

        public List<Topic> getTopicList() {
            return mTopicList;
        }

        @Expose
        @SerializedName("banner")
        private List<Item> mBanners;

        @Expose
        @SerializedName("channel")
        private List<Channel> mChannels;

        @Expose
        @SerializedName("newGoodsList")
        private List<NewGoods> mNewGoodsList;

        @Expose
        @SerializedName("hotGoodsList")
        private List<NewGoods> mHotGoodsList;

        @Expose
        @SerializedName("brandList")
        private List<Brand> mBrandList;

        @Expose
        @SerializedName("topicList")
        private List<Topic> mTopicList;


//        @Expose
//        @SerializedName("brandList")
//        private List<Topic> mTopicList;
    }

    public static class Topic {
        @Expose
        @SerializedName("id")
        private int ID;

        @Expose
        @SerializedName("title")
        private String title;

        @Expose
        @SerializedName("content")
        private String content;

        @Expose
        @SerializedName("avatar")
        private String avatar;

        @Expose
        @SerializedName("item_pic_url")
        private String item_pic_url;

        @Expose
        @SerializedName("subtitle")
        private String subtitle;

        @Expose
        @SerializedName("topic_category_id")
        private int topic_category_id;

        @Expose
        @SerializedName("price_info")
        private float price_info;

        @Expose
        @SerializedName("read_count")
        private String read_count;

        @Expose
        @SerializedName("scene_pic_url")
        private String scene_pic_url;

        @Expose
        @SerializedName("topic_template_id")
        private int topic_template_id;

        @Expose
        @SerializedName("topic_tag_id")
        private int topic_tag_id;

        @Expose
        @SerializedName("sort_order")
        private int sort_order;

        @Expose
        @SerializedName("is_show")
        private int is_show;

    }

    public static class HotGoods extends NewGoods {

        @Expose
        @SerializedName("goods_brief")
        private String mGoodsBrief;

        public void setGoodsBrief(String mGoodsBrief) {
            this.mGoodsBrief = mGoodsBrief;
        }
    }

    public static class NewGoods {

        @Expose
        @SerializedName("id")
        private int ID;

        @Expose
        @SerializedName("name")
        private String mName;


        @Expose
        @SerializedName("retail_price")
        private int mRetailPrice;

        @Expose
        @SerializedName("list_pic_url")
        private String mPicUrl;

        public int getID() {
            return ID;
        }

        public String getName() {
            return mName;
        }

        public int getRetailPrice() {
            return mRetailPrice;
        }

        public String getPicUrl() {
            return mPicUrl;
        }
    }

    public static class Channel {

        @Expose
        @SerializedName("id")
        private int ID;

        @Expose
        @SerializedName("name")
        private String mName;


        @Expose
        @SerializedName("url")
        private String mUrl;

        @Expose
        @SerializedName("icon_url")
        private String mImageUrl;

        @Expose
        @SerializedName("sort_order")
        private int mSortOrder;

        public int getID() {
            return ID;
        }

        public String getName() {
            return mName;
        }

        public String getUrl() {
            return mUrl;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public int getSortOrder() {
            return mSortOrder;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public void setName(String mName) {
            this.mName = mName;
        }

        public void setUrl(String mUrl) {
            this.mUrl = mUrl;
        }

        public void setImageUrl(String mImageUrl) {
            this.mImageUrl = mImageUrl;
        }

        public void setSortOrder(int mSortOrder) {
            this.mSortOrder = mSortOrder;
        }
    }

    public static class Item implements Comparable<Item>{
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


        public int getID() {
            return ID;
        }

        public String getLink() {
            return mLink;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

        public String getContent() {
            return mContent;
        }

        public String getName() {
            return mName;
        }

        public int getMediaType() {
            return mMediaType;
        }

        public int getEndTime() {
            return mEndTime;
        }

        public int getEnanbled() {
            return Enanbled;
        }


        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Item) {
                Item o = (Item) obj;
                return o.getID() == this.ID;
            }
            return false;
        }

        @Override
        public int compareTo(@NonNull Item o) {
            return adPositionId - o.adPositionId;
        }
    }
}
