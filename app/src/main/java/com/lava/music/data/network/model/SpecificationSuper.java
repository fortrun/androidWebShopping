package com.lava.music.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpecificationSuper {

    @Expose
    @SerializedName("specification_id")
    private int specification_id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("valueList")
    private List<Specification> valueList;

    public int getSpecification_id() {
        return specification_id;
    }

    public void setSpecification_id(int specification_id) {
        this.specification_id = specification_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Specification> getValueList() {
        return valueList;
    }

    public void setValueList(List<Specification> valueList) {
        this.valueList = valueList;
    }
}
