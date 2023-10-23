package com.example.penitipanbarang.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    private String id;
    private String nama_barang;
    private String deskripsi_barang;
    private String kondisi;
    private String tgl_penitipan;
    private String tgl_pengambilan;
    private String nama_customer;
    private String category_id;

    public Item(String nama_barang, String deskripsi_barang, String kondisi, String tgl_penitipan, String tgl_pengambilan, String nama_customer, String category_id) {
        this.nama_barang = nama_barang;
        this.deskripsi_barang = deskripsi_barang;
        this.kondisi = kondisi;
        this.tgl_penitipan = tgl_penitipan;
        this.tgl_pengambilan = tgl_pengambilan;
        this.nama_customer = nama_customer;
        this.category_id = category_id;
    }

    public String getId() {
        return id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getDeskripsi_barang() {
        return deskripsi_barang;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getTgl_penitipan() {
        return tgl_penitipan;
    }

    public String getTgl_pengambilan() {
        return tgl_pengambilan;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public String getCategory() {
        return category_id;
    }
}

