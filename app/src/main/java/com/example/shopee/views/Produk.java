package com.example.shopee.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.shopee.R;
import com.example.shopee.controller.Product;
import com.example.shopee.models.ProdukDetails;

import java.util.ArrayList;
import java.util.List;


public class Produk extends Fragment {


    public Produk() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_produk, container, false);

        return view;
    }
}