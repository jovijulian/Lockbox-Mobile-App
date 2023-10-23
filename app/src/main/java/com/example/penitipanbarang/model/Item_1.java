package com.example.penitipanbarang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item_1 {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama_barang")
    @Expose
    private String namaBarang;
    @SerializedName("deskripsi_barang")
    @Expose
    private String deskripsiBarang;
    @SerializedName("kondisi")
    @Expose
    private String kondisi;
    @SerializedName("tgl_penitipan")
    @Expose
    private String tglPenitipan;
    @SerializedName("tgl_pengambilan")
    @Expose
    private String tglPengambilan;
    @SerializedName("nama_customer")
    @Expose
    private String namaCustomer;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getDeskripsiBarang() {
        return deskripsiBarang;
    }

    public void setDeskripsiBarang(String deskripsiBarang) {
        this.deskripsiBarang = deskripsiBarang;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getTglPenitipan() {
        return tglPenitipan;
    }

    public void setTglPenitipan(String tglPenitipan) {
        this.tglPenitipan = tglPenitipan;
    }

    public String getTglPengambilan() {
        return tglPengambilan;
    }

    public void setTglPengambilan(String tglPengambilan) {
        this.tglPengambilan = tglPengambilan;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Item_1(String namaBarang, String deskripsiBarang, String kondisi, String tglPenitipan, String tglPengambilan, String namaCustomer, Category category) {
        this.namaBarang = namaBarang;
        this.deskripsiBarang = deskripsiBarang;
        this.kondisi = kondisi;
        this.tglPenitipan = tglPenitipan;
        this.tglPengambilan = tglPengambilan;
        this.namaCustomer = namaCustomer;
        this.category = category;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
