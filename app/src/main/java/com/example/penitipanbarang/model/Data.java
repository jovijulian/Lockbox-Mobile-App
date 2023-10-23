package com.example.penitipanbarang.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("items")
    @Expose
    private List<Item_1> items;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item_1> getItems() {
        return items;
    }

    public void setItems(List<Item_1> items) {
        this.items = items;
    }

}
