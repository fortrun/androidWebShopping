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


    public DataItems getDataItems() {
        return mDataItems;
    }

    public void setDataItems(DataItems dataItems) {
        this.mDataItems = dataItems;
    }

    @Expose
    @SerializedName("data")
    private DataItems mDataItems;

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


    public static class DataItems {

        public List<Item> getBanners() {
            return mBanners;
        }

        public void setBanners(List<Item> mBanners) {
            this.mBanners = mBanners;
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
        private List<HotGoods> mHotGoodsList;

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

//    public static class Topic {
//
//    }
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

    public static class Brand {

        @Expose
        @SerializedName("id")
        private int ID;

        @Expose
        @SerializedName("name")
        private String mName;

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
        @SerializedName("new_pic_url")
        private String new_pic_url;

        @Expose
        @SerializedName("new_sort_order")
        private int new_sort_order;

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
