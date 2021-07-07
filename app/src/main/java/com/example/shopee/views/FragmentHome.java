package com.example.shopee.views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopee.R;
import com.example.shopee.controller.Product;
import com.example.shopee.controller.ProductAdapter;
import com.example.shopee.database.Database;
import com.example.shopee.models.ProdukDetails;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    Button btnSearch;
    GridView gridView;
    ArrayList<ProdukDetails>list;
    ProductAdapter adapter=null;
    Product myproduk;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_home,container,false);
         gridView=(GridView) view.findViewById(R.id.gridview);
         btnSearch=view.findViewById(R.id.btn_search);
         list=new ArrayList<>();
         adapter=new ProductAdapter(getContext(),R.layout.fragment_produk,list);
         gridView.setAdapter(adapter);
        try {
            myproduk=new Product(getContext());
            Cursor cursor = myproduk.getAllProduct("SELECT * FROM tb_produk");
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
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent cari = new Intent(getActivity(),Search_product.class);
//                startActivity(cari);
//            }
//        });

        return view;
    }
}
