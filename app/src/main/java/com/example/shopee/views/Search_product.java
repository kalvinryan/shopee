package com.example.shopee.views;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SearchView;

import com.example.shopee.R;
import com.example.shopee.controller.Product;
import com.example.shopee.controller.ProductAdapter;
import com.example.shopee.models.ProdukDetails;

import java.util.ArrayList;

public class Search_product extends AppCompatActivity {
    EditText edt_search;
    GridView gridView;
    ArrayList<ProdukDetails> list;
    ProductAdapter adapter=null;
    Product myproduk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        edt_search=findViewById(R.id.txt_searchsProduct);
        gridView=(GridView) findViewById(R.id.gridviewSearch);
        list=new ArrayList<>();
        adapter=new ProductAdapter(this,R.layout.fragment_produk,list);
        gridView.setAdapter(adapter);
        try {
            myproduk=new Product(this);
            String nama = edt_search.getText().toString();
            String mySql = "SELECT * FROM tb_produk WHERE nama_brg LIKE '" +nama+"'";
            Cursor cursor = myproduk.getAllProduct(mySql);
            list.clear();
            while (cursor.moveToNext()){
                int idBarang = cursor.getInt(0);
                String barang =cursor.getString(1);
                int price =cursor.getInt(2);
                int stock =cursor.getInt(3);
                byte[] image =cursor.getBlob(4);
                list.add(new ProdukDetails(idBarang,barang,price,stock,image));
            }
            adapter.notifyDataSetChanged();
        }catch (Exception e){

        }

    }
}