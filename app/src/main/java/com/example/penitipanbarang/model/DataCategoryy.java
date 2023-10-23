package com.example.penitipanbarang.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCategoryy {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("page_info")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("errors")
    @Expose
    private List<Object> errors;
    @SerializedName("data")
    @Expose
    private DataCategory data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public DataCategory getDataCategory() {
        return data;
    }

    public void setData(DataCategory data) {
        this.data = data;
    }

}