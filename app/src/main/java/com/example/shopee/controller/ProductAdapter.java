package com.example.shopee.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopee.R;
import com.example.shopee.models.ProdukDetails;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ProdukDetails>produkDetails;

    public ProductAdapter(Context context, int layout, ArrayList<ProdukDetails> produkDetails) {
        this.context = context;
        this.layout = layout;
        this.produkDetails = produkDetails;
    }

    @Override
    public int getCount() {
        return produkDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return produkDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private class ViewHolder{
        ImageView imageView;
        TextView txtIdBarang,txtBarang,txtPrice,txtStock;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View row = view;
        ViewHolder holder= new ViewHolder();
        if (row==null){
            LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.txtIdBarang=(TextView)row.findViewById(R.id.idProductTextView);
            holder.txtBarang=(TextView)row.findViewById(R.id.productTextView);
            holder.txtPrice=(TextView)row.findViewById(R.id.priceTextView);
            holder.txtStock=(TextView)row.findViewById(R.id.stockTextView);
            holder.imageView=(ImageView) row.findViewById(R.id.productImageView);
            row.setTag(holder);
        }else {
            holder=(ViewHolder)row.getTag();
        }

        ProdukDetails produkku = produkDetails.get(position);
        holder.txtIdBarang.setText(String.valueOf(produkku.getId()));
        holder.txtBarang.setText(produkku.getNama_brg());
        holder.txtPrice.setText("Rp. "+String.valueOf(produkku.getHarga_brg()));
        holder.txtStock.setText("Qyt : "+String.valueOf(produkku.getStock_brg()));
        byte[] produkImage=produkku.getFoto_brg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(produkImage,0,produkImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
