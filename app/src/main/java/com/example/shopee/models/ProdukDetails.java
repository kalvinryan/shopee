package com.example.shopee.models;

public class ProdukDetails {
    int id;
    String nama_brg;
    int harga_brg;
    int stock_brg;
    byte[] foto_brg;

    public ProdukDetails(int id,String nama_brg, int harga_brg, int stock_brg,byte[] foto_brg) {
        this.id=id;
        this.nama_brg = nama_brg;
        this.harga_brg = harga_brg;
        this.stock_brg = stock_brg;
        this.foto_brg = foto_brg;
    }
    public ProdukDetails(String nama_brg, int harga_brg, int stock_brg,byte[] foto_brg) {
        this.nama_brg = nama_brg;
        this.harga_brg = harga_brg;
        this.stock_brg = stock_brg;
        this.foto_brg = foto_brg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_brg() {
        return nama_brg;
    }

    public void setNama_brg(String nama_brg) {
        this.nama_brg = nama_brg;
    }

    public int getHarga_brg() {
        return harga_brg;
    }

    public void setHarga_brg(int harga_brg) {
        this.harga_brg = harga_brg;
    }

    public int getStock_brg() {
        return stock_brg;
    }

    public void setStock_brg(int stock_brg) {
        this.stock_brg = stock_brg;
    }

    public byte[] getFoto_brg() {
        return foto_brg;
    }

    public void setFoto_brg(byte[] foto_brg) {
        this.foto_brg = foto_brg;
    }
}
