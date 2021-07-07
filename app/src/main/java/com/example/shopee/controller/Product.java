package com.example.shopee.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.shopee.database.Database;
import com.example.shopee.models.ProdukDetails;
import com.example.shopee.views.AddProduct;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private SQLiteDatabase db,dbRead;
    private Database database;
    List<ProdukDetails>produkDetails = new ArrayList<>();
    public final static String Tabel_name="tb_produk";
    public final static String Column_1="id";
    public final static String Column_2="nama_brg";
    public final static String Column_3="harga_brg";
    public final static String Column_4="stock_brg";
    public final static String Column_5="foto_brg";

    String[] allProduk={Column_2,Column_3,Column_4,Column_5};

    public Product(Context context) {
        database=new Database(context);
    }

    public void open() throws SQLException{
        db=database.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public void insertProduct(ProdukDetails produkDetails){
        ContentValues contentValues =new ContentValues();
        contentValues.put(Column_2,produkDetails.getNama_brg());
        contentValues.put(Column_3,produkDetails.getHarga_brg());
        contentValues.put(Column_4,produkDetails.getStock_brg());
        contentValues.put(Column_5,produkDetails.getFoto_brg());
        db.insert(Tabel_name,null,contentValues);
        close();
    }
    public Cursor getAllProduct(String sql){
        db=database.getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    public Cursor searchAllProduct(String sql){
        db=database.getReadableDatabase();
        return db.rawQuery(sql,null);
    }


}
