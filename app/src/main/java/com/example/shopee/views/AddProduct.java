package com.example.shopee.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shopee.R;
import com.example.shopee.controller.Product;
import com.example.shopee.models.ProdukDetails;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddProduct extends AppCompatActivity {

    ImageButton back_home;
    Button btnUploadgbr,btnInsertBrgjual;
    ImageView imageView;
    EditText txtNama;
    EditText txtHarga;
    EditText txtStock;
    Product produk;
    final int REQUEST_CODE_GALLERY = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        txtNama=(EditText) findViewById(R.id.txtNama_brg);
        txtHarga=(EditText) findViewById(R.id.txtharga_brg);
        txtStock=(EditText) findViewById(R.id.txtStock_brrg);
        imageView =(ImageView) findViewById(R.id.foto_brg);
        back_home=(ImageButton) findViewById(R.id.btn_backTohome);
        produk=new Product(this);
        btnUploadgbr = (Button) findViewById(R.id.btnUploadGbr_brg);
        btnInsertBrgjual=(Button) findViewById(R.id.btnTambah_brg);

        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(AddProduct.this,Home.class);
                startActivity(back);
            }
        });

        btnUploadgbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        AddProduct.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY
                );
            }
        });
        btnInsertBrgjual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myid=null;
                String namabrg = txtNama.getText().toString().trim();
                int Hargabrg = Integer.parseInt(String.valueOf(txtHarga.getText()));
                int stock = Integer.parseInt(String.valueOf(txtStock.getText()));
                    ProdukDetails produkDetails =new ProdukDetails(namabrg,Hargabrg,stock,imageViewToByte(imageView));
                    produk.open();
                    produk.insertProduct(produkDetails);
                    Toast.makeText(AddProduct.this, "Barang Berhasil Di Tambahkan", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(AddProduct.this,Home.class);
                    startActivity(home);
            }
        });
    }

    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100, stream);
        byte[] byteArray =stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent =new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);

            }
            else{
                Toast.makeText(getApplicationContext(), "Anda tidak mempunyai izin untuk mengakses file ini", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream= getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}