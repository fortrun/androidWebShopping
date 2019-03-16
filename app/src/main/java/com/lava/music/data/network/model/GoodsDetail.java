package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoodsDetail extends ApiBase{


    @Expose
    @SerializedName("category_id")
    private int category_id;


    @Expose
    @SerializedName("goods_sn")
    private String goods_sn;


    @Expose
    @SerializedName("brand_id")
    private int brand_id;


    @Expose
    @SerializedName("goods_number")
    private int goods_number;

    @Expose
    @SerializedName("keywords")
    private String keywords;

    @Expose
    @SerializedName("goods_brief")
    private String goods_brief;


    @Expose
    @SerializedName("goods_desc")
    private String goods_desc;


    @Expose
    @SerializedName("is_on_sale")
    private int is_on_sale;


    @Expose
    @SerializedName("add_time")
    private long add_time;


    @Expose
    @SerializedName("sort_order")
    private int sort_order;


    @Expose
    @SerializedName("is_delete")
    private int is_delete;


    @Expose
    @SerializedName("attribute_category")
    private int attribute_category;

    @Expose
    @SerializedName("counter_price")
    private float counter_price;


    @Expose
    @SerializedName("extra_price")
    private float extra_price;


    @Expose
    @SerializedName("is_new")
    private int is_new;


    @Expose
    @SerializedName("goods_unit")
    private String goods_unit;


    @Expose
    @SerializedName("primary_pic_url")
    private String primary_pic_url;


    @Expose
    @SerializedName("list_pic_url")
    private String list_pic_url;


    @Expose
    @SerializedName("retail_price")
    private int retail_price;


    @Expose
    @SerializedName("sell_volume")
    private int sell_volume;


    @Expose
    @SerializedName("primary_product_id")
    private int primary_product_id;


    @Expose
    @SerializedName("unit_price")
    private float unit_price;


    @Expose
    @SerializedName("promotion_desc")
    private String promotion_desc;


    @Expose
    @SerializedName("promotion_tag")
    private String promotion_tag;

    @Expose
    @SerializedName("app_exclusive_price")
    private int app_exclusive_price;


    @Expose
    @SerializedName("is_app_exclusive")
    private int is_app_exclusive;


    @Expose
    @SerializedName("is_limited")
    private int is_limited;


    @Expose
    @SerializedName("is_hot")
    private int is_hot;

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getGoods_sn() {
        return goods_sn;
    }

    public void setGoods_sn(String goods_sn) {
        this.goods_sn = goods_sn;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(int goods_number) {
        this.goods_number = goods_number;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public int isIs_on_sale() {
        return is_on_sale;
    }

    public void setIs_on_sale(int is_on_sale) {
        this.is_on_sale = is_on_sale;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public int isIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public int getAttribute_category() {
        return attribute_category;
    }

    public void setAttribute_category(int attribute_category) {
        this.attribute_category = attribute_category;
    }

    public float getCounter_price() {
        return counter_price;
    }

    public void setCounter_price(float counter_price) {
        this.counter_price = counter_price;
    }

    public float getExtra_price() {
        return extra_price;
    }

    public void setExtra_price(float extra_price) {
        this.extra_price = extra_price;
    }

    public int isIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public String getGoods_unit() {
        return goods_unit;
    }

    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    public String getPrimary_pic_url() {
        return primary_pic_url;
    }

    public void setPrimary_pic_url(String primary_pic_url) {
        this.primary_pic_url = primary_pic_url;
    }

    public String getList_pic_url() {
        return list_pic_url;
    }

    public void setList_pic_url(String list_pic_url) {
        this.list_pic_url = list_pic_url;
    }

    public int getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }

    public int getSell_volume() {
        return sell_volume;
    }

    public void setSell_volume(int sell_volume) {
        this.sell_volume = sell_volume;
    }

    public int getPrimary_product_id() {
        return primary_product_id;
    }

    public void setPrimary_product_id(int primary_product_id) {
        this.primary_product_id = primary_product_id;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getPromotion_desc() {
        return promotion_desc;
    }

    public void setPromotion_desc(String promotion_desc) {
        this.promotion_desc = promotion_desc;
    }

    public String getPromotion_tag() {
        return promotion_tag;
    }

    public void setPromotion_tag(String promotion_tag) {
        this.promotion_tag = promotion_tag;
    }

    public int getApp_exclusive_price() {
        return app_exclusive_price;
    }

    public void setApp_exclusive_price(int app_exclusive_price) {
        this.app_exclusive_price = app_exclusive_price;
    }

    public int isIs_app_exclusive() {
        return is_app_exclusive;
    }

    public void setIs_app_exclusive(int is_app_exclusive) {
        this.is_app_exclusive = is_app_exclusive;
    }

    public int isIs_limited() {
        return is_limited;
    }

    public void setIs_limited(int is_limited) {
        this.is_limited = is_limited;
    }

    public int isIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }
}
