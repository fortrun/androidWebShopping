package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GoodsResponse extends NideResponse {


    @Expose
    @SerializedName("data")
    Data GoodsData;

    public Data getGoodsData() {
        return GoodsData;
    }

    public void setGoodsData(Data goodsData) {
        GoodsData = goodsData;
    }

    class GoodsData extends Data{
        @Expose
        @SerializedName("info")
        GoodsDetail info;


        @Expose
        @SerializedName("gallery")
        List<GoodsGallery> gallery;


        @Expose
        @SerializedName("attribute")
        List<GoodsAttribute> attribute;

        @Expose
        @SerializedName("userHasCollect")
        int userHasCollect;


        @Expose
        @SerializedName("issue")
        List<Issue> issue;


//        @Expose
//        @SerializedName("comment")
//        Comment comment;

        @Expose
        @SerializedName("brand")
        Brand brand;

        @Expose
        @SerializedName("specificationList")
        List<Specification> specificationList;


        @Expose
        @SerializedName("productList")
        List<Product> productList;

        public GoodsDetail getInfo() {
            return info;
        }

        public void setInfo(GoodsDetail info) {
            this.info = info;
        }

        public List<GoodsGallery> getGallery() {
            return gallery;
        }

        public void setGallery(List<GoodsGallery> gallery) {
            this.gallery = gallery;
        }

        public List<GoodsAttribute> getAttribute() {
            return attribute;
        }

        public void setAttribute(List<GoodsAttribute> attribute) {
            this.attribute = attribute;
        }

        public int getUserHasCollect() {
            return userHasCollect;
        }

        public void setUserHasCollect(int userHasCollect) {
            this.userHasCollect = userHasCollect;
        }

        public List<Issue> getIssue() {
            return issue;
        }

        public void setIssue(List<Issue> issue) {
            this.issue = issue;
        }

        public Brand getBrand() {
            return brand;
        }

        public void setBrand(Brand brand) {
            this.brand = brand;
        }

        public List<Specification> getSpecificationList() {
            return specificationList;
        }

        public void setSpecificationList(List<Specification> specificationList) {
            this.specificationList = specificationList;
        }

        public List<Product> getProductList() {
            return productList;
        }

        public void setProductList(List<Product> productList) {
            this.productList = productList;
        }
    }
}
