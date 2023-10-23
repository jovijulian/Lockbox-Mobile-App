package com.example.penitipanbarang.model;

public class Order {
    private Integer order_id;
    private Integer invoice_id;
    private Integer qty;
    private Integer harga;
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Order(Integer order_id, Integer invoice_id, Integer qty, Integer harga, Integer total) {
        this.order_id = order_id;
        this.invoice_id = invoice_id;
        this.qty = qty;
        this.harga = harga;
        this.total = (qty * harga);
    }
}
