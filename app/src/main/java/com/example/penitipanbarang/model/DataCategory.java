package com.example.penitipanbarang.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCategory {

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("items")
    @Expose
    private List<ItemsCategory> items;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<ItemsCategory> getItems() {
        return items;
    }

    public void setItems(List<ItemsCategory> items) {
        this.items = items;
    }

}